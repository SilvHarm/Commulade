package fr.silvharm.commulade.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.consumer.contract.dao.LongueurDao;
import fr.silvharm.commulade.consumer.contract.dao.SecteurDao;
import fr.silvharm.commulade.consumer.contract.dao.SiteDao;
import fr.silvharm.commulade.consumer.contract.dao.VoieDao;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Longueur;
import fr.silvharm.commulade.model.pojo.Secteur;
import fr.silvharm.commulade.model.pojo.Site;
import fr.silvharm.commulade.model.pojo.Voie;

public class SiteInteractionsImpl implements SiteInteractions {
	
	private static final Logger logger = LogManager.getLogger();
	
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
	
	
	/**
	 * Verify if the form properties have the format expected, if not it's set them
	 * to "" or just return null
	 * 
	 * @return the formBean verificated and corrected if necessary or null
	 */
	private Boolean formVerification(SiteSearchFormBean formBean) {
		// if every properties are empty
		if ((formBean.getSiteName() + formBean.getMinHeight() + formBean.getMaxHeight() + formBean.getMinPointNumber()
				+ formBean.getMaxPointNumber() + formBean.getCotation()).isEmpty()) {
			logger.info("All properties of the Form are empty");
			
			return false;
		}
		
		if (formBean.getSiteName().length() > 48) {
			logger.info("siteName property length is unexpected");
			
			return false;
		}
		
		int i;
		try {
			// if form field wasn't left empty
			if (!formBean.getMinHeight().isEmpty()) {
				// test if field content is an Integer
				i = Integer.parseInt(formBean.getMinHeight());
				// test if value is unexpected
				if (i < 1 && 99 < i) {
					logger.info("minHeight property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMaxHeight().isEmpty()) {
				i = Integer.parseInt(formBean.getMaxHeight());
				if (i < 2 && 100 < i) {
					logger.info("maxHeight property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMinPointNumber().isEmpty()) {
				i = Integer.parseInt(formBean.getMinPointNumber());
				if (i < 1 && 99 < i) {
					logger.info("minPointNumber property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMaxPointNumber().isEmpty()) {
				i = Integer.parseInt(formBean.getMaxPointNumber());
				if (i < 2 && 100 < i) {
					logger.info("maxPointNumber property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getCotation().isEmpty()) {
				i = Integer.parseInt(formBean.getCotation());
				if (i < 3 && 9 < i) {
					logger.info("cotation property value is unexpected");
					
					return false;
				}
			}
		}
		catch (NumberFormatException e) {
			logger.info("A property of the form who should have been an Integer wasn't one\n", e);
			
			return false;
		}
		
		
		return true;
	}
	
	
	public List<Site> getAllSite() {
		return siteDao.getAllSite();
	}
	
	
	public List<Site> getListSiteByIdList(List<Integer> list) {
		List<Site> siteList = siteDao.findByListId(list);
		
		logger.info(siteList.size());
		
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
		if (!formVerification(formBean)) {
			return null;
		}
		
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
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
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
