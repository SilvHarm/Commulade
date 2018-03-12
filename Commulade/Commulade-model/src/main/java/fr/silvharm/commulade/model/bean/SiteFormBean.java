package fr.silvharm.commulade.model.bean;

import java.io.File;
import java.util.List;

public class SiteFormBean {
	
	private File photo;
	private List<SecteurFormBean> listSecteur;
	private String name, pathIndication, photoName, photoType, place;
	
	
	public SiteFormBean() {}
	
	
	/********************************
	 * Struts 2
	 *******************************/
	
	/**
	 * @param contentType
	 *           the contentType to set
	 */
	public void setPhotoContentType(String contentType) {
		this.photoType = contentType;
	}
	
	
	/**
	 * @param fileName
	 *           the fileName to set
	 */
	public void setPhotoFileName(String fileName) {
		this.photoName = fileName;
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
	 * @return the photo
	 */
	public File getPhoto() {
		return photo;
	}
	
	
	/**
	 * @param photo
	 *           the photo to set
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
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
	 * @return the photoType
	 */
	public String getPhotoType() {
		return photoType;
	}
	
	
	/**
	 * @param photoType
	 *           the photoType to set
	 */
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
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
