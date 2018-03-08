package fr.silvharm.commulade.model.bean;

import java.util.List;

public class TopoFormBean {
	
	private List<SiteFormBean> listSite;
	private String description, editionDate, name;
	
	
	public TopoFormBean() {
	}
	
	
	/**
	 * @param name
	 * @param editionDate
	 * @param description
	 * @param listSite
	 */
	public TopoFormBean(String name, String editionDate, String description, List<SiteFormBean> listSite) {
		this.name = name;
		this.editionDate = editionDate;
		this.description = description;
		this.listSite = listSite;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the listSite
	 */
	public List<SiteFormBean> getListSite() {
		return listSite;
	}
	
	
	/**
	 * @param listSite
	 *           the listSite to set
	 */
	public void setListSite(List<SiteFormBean> listSite) {
		this.listSite = listSite;
	}
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * @param description
	 *           the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * @return the editionDate
	 */
	public String getEditionDate() {
		return editionDate;
	}
	
	
	/**
	 * @param editionDate
	 *           the editionDate to set
	 */
	public void setEditionDate(String editionDate) {
		this.editionDate = editionDate;
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
