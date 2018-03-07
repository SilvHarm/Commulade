package fr.silvharm.commulade.model.bean;

import java.util.List;

public class SecteurFormBean {
	
	private List<VoieFormBean> listVoie;
	private String name, photoName;
	
	
	public SecteurFormBean() {
	}
	
	
	/**
	 * @param name
	 * @param photoName
	 * @param listVoie
	 */
	public SecteurFormBean(String name, String photoName, List<VoieFormBean> listVoie) {
		this.name = name;
		this.photoName = photoName;
		this.listVoie = listVoie;
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
	
}
