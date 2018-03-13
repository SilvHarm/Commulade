package fr.silvharm.commulade.business.helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.silvharm.commulade.model.bean.LongueurFormBean;
import fr.silvharm.commulade.model.bean.SecteurFormBean;
import fr.silvharm.commulade.model.bean.SiteFormBean;
import fr.silvharm.commulade.model.bean.VoieFormBean;
import fr.silvharm.commulade.model.pojo.Longueur;
import fr.silvharm.commulade.model.pojo.Secteur;
import fr.silvharm.commulade.model.pojo.Site;
import fr.silvharm.commulade.model.pojo.Voie;

public class FormConverterHelper {
	
	public static String stringSqlConform(String str) {
		return str.replaceAll("'", "''");
	}
	
	
	public static Site siteFormToSite(SiteFormBean siteForm) {
		int i, j, k;
		List<LongueurFormBean> listLongueur;
		List<SecteurFormBean> listSecteur;
		List<VoieFormBean> listVoie;
		Longueur longueur;
		LongueurFormBean longueurForm;
		Secteur secteur;
		SecteurFormBean secteurForm;
		String tempo;
		Voie voie;
		VoieFormBean voieForm;
		
		Site site = new Site();
		site.setListSecteur(new ArrayList<Secteur>());
		
		site.setName(stringSqlConform(siteForm.getName()));
		site.setDate(LocalDate.now());
		site.setPlace(stringSqlConform(siteForm.getPlace()));
		site.setPathIndication(stringSqlConform(siteForm.getPathIndication()));
		
		if (siteForm.getPhotoName() != null) {
			site.setPhoto(siteForm.getPhoto());
			
			tempo = siteForm.getPhotoName().replaceAll(" ", "_");
			tempo = stringSqlConform(tempo);
			
			if (60 < tempo.length()) {
				tempo = tempo.substring(0, 59);
				
				tempo += "_" + ((int) (Math.random() * (99999999 - 1000001) + 1000000));
			}
			
			site.setPhotoName(tempo);
		}
		
		
		// Add Secteur to site
		listSecteur = siteForm.getListSecteur();
		for (i = 0; i < listSecteur.size(); i++) {
			secteurForm = listSecteur.get(i);
			
			if (secteurForm != null) {
				secteur = new Secteur();
				secteur.setListVoie(new ArrayList<Voie>());
				
				secteur.setName(stringSqlConform(secteurForm.getName()));
				
				if (secteurForm.getPhotoName() != null) {
					secteur.setPhoto(secteurForm.getPhoto());
					
					tempo = secteurForm.getPhotoName().replaceAll(" ", "_");
					tempo = stringSqlConform(tempo);
					
					if (60 < tempo.length()) {
						tempo = tempo.substring(0, 59);
						
						tempo += "_" + ((int) (Math.random() * (99999999 - 1000001) + 1000000));
					}
					
					secteur.setPhotoName(tempo);
				}
				
				
				// Add Voie to secteur
				listVoie = secteurForm.getListVoie();
				for (j = 0; j < listVoie.size(); j++) {
					voieForm = listVoie.get(j);
					
					if (voieForm != null) {
						voie = new Voie();
						voie.setListLongueur(new ArrayList<Longueur>());
						
						voie.setName(stringSqlConform(voieForm.getName()));
						
						
						// Add Longueur to voie
						listLongueur = voieForm.getListLongueur();
						for (k = 0; k < listLongueur.size(); k++) {
							longueurForm = listLongueur.get(k);
							
							if (longueurForm != null) {
								longueur = new Longueur();
								
								longueur.setHeight(Integer.parseInt(longueurForm.getHeight()));
								longueur.setNombrePoints(Integer.parseInt(longueurForm.getNombrePoints()));
								longueur.setCotation(stringSqlConform(longueurForm.getCotation()));
								
								voie.addItemToList(longueur);
							}
						}
						
						secteur.addItemToList(voie);
					}
				}
				
				site.addItemToList(secteur);
			}
		}
		
		return site;
	}
}
