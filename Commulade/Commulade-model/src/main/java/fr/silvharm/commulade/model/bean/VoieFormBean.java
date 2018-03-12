package fr.silvharm.commulade.model.bean;

import java.util.List;

public class VoieFormBean {
	
	private List<LongueurFormBean> listLongueur;
	private String name;
	
	
	public VoieFormBean() {}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the listLongueur
	 */
	public List<LongueurFormBean> getListLongueur() {
		return listLongueur;
	}
	
	
	/**
	 * @param listLongueur
	 *           the listLongueur to set
	 */
	public void setListLongueur(List<LongueurFormBean> listLongueur) {
		this.listLongueur = listLongueur;
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
	
}
