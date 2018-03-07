package fr.silvharm.commulade.model.bean;

import java.util.List;

public class SiteFormBean {
	
	private List<SecteurFormBean> listSecteur;
	private String date, name, pathIndication, photoName, place;
	
	
	public SiteFormBean() {
		
	}
	
	
	/**
	 * @param name
	 * @param date
	 * @param photoName
	 * @param place
	 * @param pathIndication
	 * @param listSecteur
	 */
	public SiteFormBean(String name, String date, String photoName, String place, String pathIndication,
			List<SecteurFormBean> listSecteur) {
		this.name = name;
		this.date = date;
		this.photoName = photoName;
		this.place = place;
		this.pathIndication = pathIndication;
		this.listSecteur = listSecteur;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the listSecteur
	 */
	public List<SecteurFormBean> getListSecteur() {
		return listSecteur;
	}
	
	
	/**
	 * @param listSecteur
	 *           the listSecteur to set
	 */
	public void setListSecteur(List<SecteurFormBean> listSecteur) {
		this.listSecteur = listSecteur;
	}
	
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	
	/**
	 * @param date
	 *           the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the pathIndication
	 */
	public String getPathIndication() {
		return pathIndication;
	}
	
	
	/**
	 * @param pathIndication
	 *           the pathIndication to set
	 */
	public void setPathIndication(String pathIndication) {
		this.pathIndication = pathIndication;
	}
	
	
	/**
	 * @return the photoName
	 */
	public String getPhotoName() {
		return photoName;
	}
	
	
	/**
	 * @param photoName
	 *           the photoName to set
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	
	
	/**
	 * @param place
	 *           the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
}
