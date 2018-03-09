package fr.silvharm.commulade.model.bean;

import java.io.File;
import java.util.List;

public class SecteurFormBean {
	
	private File photo;
	private List<VoieFormBean> listVoie;
	private String name, photoName, photoType;
	
	
	public SecteurFormBean() {}
	
	
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
	 * @return the listVoie
	 */
	public List<VoieFormBean> getListVoie() {
		return listVoie;
	}
	
	
	/**
	 * @param listVoie
	 *           the listVoie to set
	 */
	public void setListVoie(List<VoieFormBean> listVoie) {
		this.listVoie = listVoie;
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
	
}
