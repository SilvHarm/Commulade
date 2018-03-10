package fr.silvharm.commulade.model.pojo;

import java.io.File;
import java.util.List;

public class Secteur {
	
	private File photo;
	private Integer id, siteId;
	private List<Voie> listVoie;
	private String name, photoName;
	
	
	public Secteur() {}
	
	
	/**
	 * @param id
	 * @param name
	 * @param siteId
	 * @param photoName
	 * @param listVoie
	 */
	public Secteur(Integer id, String name, Integer siteId, String photoName, List<Voie> listVoie) {
		this.id = id;
		this.name = name;
		this.siteId = siteId;
		this.photoName = photoName;
		this.listVoie = listVoie;
	}
	
	
	/**
	 * Add the Voie provided to listVoie
	 * 
	 * @param item
	 */
	public void addItemToList(Voie item) {
		listVoie.add(item);
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * @return the siteId
	 */
	public Integer getSiteId() {
		return siteId;
	}
	
	
	/**
	 * @param siteId
	 *           the siteId to set
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
	
	/**
	 * @return the listVoie
	 */
	public List<Voie> getListVoie() {
		return listVoie;
	}
	
	
	/**
	 * @param listVoie
	 *           the listVoie to set
	 */
	public void setListVoie(List<Voie> listVoie) {
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
	
}
