package fr.silvharm.commulade.business.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.silvharm.commulade.model.bean.CommentFormBean;
import fr.silvharm.commulade.model.bean.LongueurFormBean;
import fr.silvharm.commulade.model.bean.SecteurFormBean;
import fr.silvharm.commulade.model.bean.SiteFormBean;
import fr.silvharm.commulade.model.bean.TopoFormBean;
import fr.silvharm.commulade.model.bean.VoieFormBean;
import fr.silvharm.commulade.model.pojo.Comment;
import fr.silvharm.commulade.model.pojo.Longueur;
import fr.silvharm.commulade.model.pojo.Secteur;
import fr.silvharm.commulade.model.pojo.Site;
import fr.silvharm.commulade.model.pojo.Topo;
import fr.silvharm.commulade.model.pojo.Voie;

public class FormConverterHelper {
	
	public static String stringSqlConform(String str) {
		return str.replaceAll("'", "''");
	}
	
	
	public static Comment commentFormToComment(CommentFormBean commentForm) {
		Integer userId = commentForm.getUserId();
		if (userId == 0) {
			userId = null;
		}
		
		return new Comment(userId, Integer.parseInt(commentForm.getPostType()), Integer.parseInt(commentForm.getPostId()),
				LocalDateTime.now(), stringSqlConform(commentForm.getComment()));
	}
	
	
	public static Site siteFormToSite(SiteFormBean siteForm, LocalDate date) {
		int i, j, k;
		List<LongueurFormBean> listLongueur;
		List<SecteurFormBean> listSecteur;
		List<VoieFormBean> listVoie;
		Longueur longueur;
		LongueurFormBean longueurForm;
		Secteur secteur;
		SecteurFormBean secteurForm;
		String ext, tempo;
		String[] tempoTab;
		Voie voie;
		VoieFormBean voieForm;
		
		Site site = new Site();
		site.setListSecteur(new ArrayList<Secteur>());
		
		site.setName(stringSqlConform(siteForm.getName()));
		site.setDate(date);
		site.setPlace(stringSqlConform(siteForm.getPlace()));
		site.setPathIndication(stringSqlConform(siteForm.getPathIndication()));
		
		if (siteForm.getPhotoName() != null) {
			site.setPhoto(siteForm.getPhoto());
			
			tempoTab = siteForm.getPhotoName().split("\\.");
			ext = "." + tempoTab[tempoTab.length - 1];
			
			tempo = siteForm.getPhotoName().trim();
			tempo = tempo.replaceAll(ext + "$", "");
			tempo = stringSqlConform(tempo);
			
			if (60 < tempo.length()) {
				tempo = tempo.substring(0, 59);
			}
			
			tempo += "_" + ((int) (Math.random() * (99999999 - 1000001) + 1000000)) + ext;
			
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
					
					tempoTab = secteurForm.getPhotoName().split("\\.");
					ext = "." + tempoTab[tempoTab.length - 1];
					
					tempo = secteurForm.getPhotoName().trim();
					tempo = tempo.replaceAll(ext + "$", "");
					tempo = stringSqlConform(tempo);
					
					if (60 < tempo.length()) {
						tempo = tempo.substring(0, 59);
					}
					
					tempo += "_" + ((int) (Math.random() * (99999999 - 1000001) + 1000000)) + ext;
					
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
	
	
	public static Topo topoFormToTopo(TopoFormBean topoForm) {
		Topo topo = new Topo();
		
		topo.setName(stringSqlConform(topoForm.getName()));
		topo.setEditionDate(LocalDate.parse(topoForm.getEditionDate()));
		
		if (!topoForm.getDescription().isEmpty()) {
			topo.setDescription(stringSqlConform(topoForm.getDescription()));
		}
		
		return topo;
	}
	
}
