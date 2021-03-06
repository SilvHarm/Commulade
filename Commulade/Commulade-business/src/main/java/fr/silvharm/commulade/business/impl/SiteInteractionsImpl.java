package fr.silvharm.commulade.business.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.business.helper.FormConverterHelper;
import fr.silvharm.commulade.business.helper.FormVerificationHelper;
import fr.silvharm.commulade.consumer.contract.dao.LongueurDao;
import fr.silvharm.commulade.consumer.contract.dao.SecteurDao;
import fr.silvharm.commulade.consumer.contract.dao.SiteDao;
import fr.silvharm.commulade.consumer.contract.dao.VoieDao;
import fr.silvharm.commulade.model.bean.SiteFormBean;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.bean.TopoFormBean;
import fr.silvharm.commulade.model.pojo.ConfigContainer;
import fr.silvharm.commulade.model.pojo.Longueur;
import fr.silvharm.commulade.model.pojo.Secteur;
import fr.silvharm.commulade.model.pojo.Site;
import fr.silvharm.commulade.model.pojo.Voie;

public class SiteInteractionsImpl implements SiteInteractions {
	
	private static final Logger logger = LogManager.getLogger();
	
	private ConfigContainer configContainer;
	private LongueurDao longueurDao;
	private SecteurDao secteurDao;
	private SiteDao siteDao;
	private VoieDao voieDao;
	
	
	/**
	 * Take all the Site from the List and complete them by requesting all their
	 * childs from the consumer module before letting the method mergeInListSite
	 * fused them together
	 * 
	 * @param siteList
	 * @return the List whom all the Site have seen their List filled
	 */
	private List<Site> completeSiteFromList(List<Site> siteList) {
		logger.info("siteList size: " + siteList.size());
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		for (Site site : siteList) {
			list.add(site.getId());
		}
		
		List<Secteur> secteurList = secteurDao.findByListSiteId(list);
		logger.info("secteurList size: " + secteurList.size());
		
		
		for (Secteur secteur : secteurList) {
			list.add(secteur.getId());
		}
		
		List<Voie> voieList = voieDao.findByListSecteurId(list);
		logger.info("voieList size: " + voieList.size());
		
		
		for (Voie voie : voieList) {
			list.add(voie.getId());
		}
		
		List<Longueur> longueurList = longueurDao.findByListVoieId(list);
		logger.info("longueurList size: " + longueurList.size());
		
		
		return mergeInListSite(siteList, secteurList, voieList, longueurList);
	}
	
	
	public List<Site> getAllSite() {
		return siteDao.getAllSite();
	}
	
	
	public List<Site> getListSiteByIdList(List<Integer> list) {
		List<Site> siteList = siteDao.findByListId(list);
		
		if (siteList.size() == 0) {
			return null;
		}
		
		return completeSiteFromList(siteList);
	}
	
	
	public List<Site> getListSiteByTopoId(int topoId) {
		List<Site> siteList = siteDao.getSiteListByTopoId(topoId);
		
		if (siteList.size() == 0) {
			return null;
		}
		
		return completeSiteFromList(siteList);
	}
	
	
	public List<Site> getSearchSite(SiteSearchFormBean formBean) {
		if (!FormVerificationHelper.siteSearch(formBean)) {
			return null;
		}
		
		formBean.setSiteName(FormConverterHelper.stringSqlConform(formBean.getSiteName()));
		
		return siteDao.findBySearch(formBean);
	}
	
	
	public Site getSiteById(int id) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(id);
		
		List<Site> siteList = getListSiteByIdList(list);
		
		if (siteList == null) {
			return null;
		}
		
		return siteList.get(0);
	}
	
	
	/**
	 * Merge List the way that only List siteList remain; Longueur go in Voie who go
	 * in Secteur who go in Site
	 * 
	 * @param siteList
	 * @param secteurList
	 * @param voieList
	 * @param longueurList
	 * 
	 * @return siteList after every other List was merged in its Site
	 */
	private List<Site> mergeInListSite(List<Site> siteList, List<Secteur> secteurList, List<Voie> voieList,
			List<Longueur> longueurList) {
		int i, j, k;
		
		
		// Put the Longueur in the Voie to which they belong
		j = longueurList.size();
		for (Voie voie : voieList) {
			// voie's List might be null since it's given by the consumer module
			if (voie.getListLongueur() == null) {
				voie.setListLongueur(new ArrayList<Longueur>());
			}
			
			i = voie.getId();
			for (k = 0; k < j; k++) {
				if (longueurList.get(k).getVoieId() == i) {
					voie.addItemToList(longueurList.remove(k));
					
					j--;
					k--;
				}
			}
		}
		
		
		// Put the Voie in the Secteur to which they belong
		j = voieList.size();
		for (Secteur secteur : secteurList) {
			// secteur's List might be null since it's given by the consumer module
			if (secteur.getListVoie() == null) {
				secteur.setListVoie(new ArrayList<Voie>());
			}
			
			i = secteur.getId();
			for (k = 0; k < j; k++) {
				if (voieList.get(k).getSecteurId() == i) {
					secteur.addItemToList(voieList.remove(k));
					
					j--;
					k--;
				}
			}
		}
		
		
		// Put the Secteur in the Site to which they belong
		j = secteurList.size();
		for (Site site : siteList) {
			// site's List might be null since it's given by the consumer module
			if (site.getListSecteur() == null) {
				site.setListSecteur(new ArrayList<Secteur>());
			}
			
			i = site.getId();
			for (k = 0; k < j; k++) {
				if (secteurList.get(k).getSiteId() == i) {
					site.addItemToList(secteurList.remove(k));
					
					j--;
					k--;
				}
			}
		}
		
		
		return siteList;
	}
	
	
	public Integer shareSite(TopoFormBean topoForm) {
		List<SiteFormBean> list = topoForm.getListSite();
		
		if (list != null) {
			if (list.size() == 1 || list.get(0) != null) {
				if (FormVerificationHelper.shareSite(list.get(0))) {
					list = new ArrayList<SiteFormBean>();
					
					list.add(topoForm.getListSite().get(0));
					
					
					return shareListSite(list, LocalDate.now()).get(0);
				}
			}
		}
		
		return null;
	}
	
	
	public List<Integer> shareListSite(List<SiteFormBean> list, LocalDate date) {
		List<File> sitePhotoList = new ArrayList<File>();
		List<String> sitePhotoNameList = new ArrayList<String>();
		
		List<File> secteurPhotoList = new ArrayList<File>();
		List<String> secteurPhotoNameList = new ArrayList<String>();
		
		List<Site> siteList = new ArrayList<Site>();
		
		for (SiteFormBean siteForm : list) {
			// skip the SiteFormBean if it's null
			if (siteForm != null) {
				Site site = FormConverterHelper.siteFormToSite(siteForm, date);
				
				siteList.add(site);
				
				if (site.getPhoto() != null) {
					sitePhotoList.add(site.getPhoto());
					sitePhotoNameList.add(site.getPhotoName());
				}
			}
		}
		
		if (siteList.isEmpty()) {
			return null;
		}
		
		List<Integer> siteIdList = siteDao.createList(siteList);
		
		
		// add all the Secteur to database
		List<Secteur> secteurList = new ArrayList<Secteur>();
		for (int t = 0; t < siteList.size(); t++) {
			for (Secteur secteur : siteList.get(t).getListSecteur()) {
				secteur.setSiteId(siteIdList.get(t));
				
				secteurList.add(secteur);
				
				if (secteur.getPhoto() != null) {
					secteurPhotoList.add(secteur.getPhoto());
					secteurPhotoNameList.add(secteur.getPhotoName());
				}
			}
		}
		
		List<Integer> idList = secteurDao.createList(secteurList);
		
		
		// add all the Voie to database
		List<Voie> voieList = new ArrayList<Voie>();
		for (int i = 0; i < secteurList.size(); i++) {
			for (Voie voie : secteurList.get(i).getListVoie()) {
				voie.setSecteurId(idList.get(i));
				
				voieList.add(voie);
			}
		}
		
		idList = voieDao.createList(voieList);
		
		
		// set the id of the Voie to help set Longueur's voieId later
		for (int j = 0; j < voieList.size(); j++) {
			voieList.get(j).setId(idList.get(j));
		}
		
		
		// add all the Longueur to database
		Boolean boucle;
		int b, nbTurn = 0, listSize;
		List<Longueur> longueurList = new ArrayList<Longueur>();
		List<Longueur> toAddList = new ArrayList<Longueur>();
		Voie voie;
		do {
			boucle = false;
			toAddList.clear();
			
			listSize = voieList.size();
			for (b = 0; b < listSize; b++) {
				voie = voieList.get(b);
				longueurList = voie.getListLongueur();
				
				if (longueurList.size() <= nbTurn) {
					idList.remove(b);
					voieList.remove(b);
					b--;
					listSize--;
					
					continue;
				}
				
				longueurList.get(nbTurn).setVoieId(voie.getId());
				if (0 < nbTurn) {
					longueurList.get(nbTurn).setPreviousLongueurId(idList.get(b));
				}
				
				toAddList.add(longueurList.get(nbTurn));
				
				
				// if a Voie still has Longueur that will need to be added after that turn
				if (longueurList.size() > (nbTurn + 1)) {
					boucle = true;
				}
			}
			
			idList = longueurDao.createList(toAddList);
			
			nbTurn++;
		} while (boucle);
		
		
		try {
			String path;
			
			if (sitePhotoList.size() != 0) {
				path = configContainer.getSitePhotoSave();
				for (int i = 0; i < sitePhotoList.size(); i++) {
					Files.copy(Paths.get(sitePhotoList.get(i).getPath()), Paths.get(path, "/", sitePhotoNameList.get(i)),
							StandardCopyOption.COPY_ATTRIBUTES);
				}
			}
			
			
			if (secteurPhotoList != null) {
				path = configContainer.getSecteurPhotoSave();
				for (int i = 0; i < secteurPhotoList.size(); i++) {
					Files.copy(Paths.get(secteurPhotoList.get(i).getPath()),
							Paths.get(path + "/" + secteurPhotoNameList.get(i)), StandardCopyOption.COPY_ATTRIBUTES);
				}
			}
		}
		catch (InvalidPathException e) {
			logger.warn("A problem occured with a Path while moving the photos of the new Site/Secteur", e);
		}
		catch (IOException e) {
			logger.warn("A problem occured while moving the photos of the new Site/Secteur", e);
		}
		
		
		return siteIdList;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	
	/**
	 * @param configContainer
	 *           the configContainer to set
	 */
	public void setConfigContainer(ConfigContainer configContainer) {
		this.configContainer = configContainer;
	}
	
	
	/**
	 * @param longueurDao
	 *           the longueurDao to set
	 */
	public void setLongueurDao(LongueurDao longueurDao) {
		this.longueurDao = longueurDao;
	}
	
	
	/**
	 * @param secteurDao
	 *           the secteurDao to set
	 */
	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao = secteurDao;
	}
	
	
	/**
	 * @param siteDao
	 *           the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}
	
	
	/**
	 * @param voieDao
	 *           the voieDao to set
	 */
	public void setVoieDao(VoieDao voieDao) {
		this.voieDao = voieDao;
	}
	
}
