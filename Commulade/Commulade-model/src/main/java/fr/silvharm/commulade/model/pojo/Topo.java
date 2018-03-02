package fr.silvharm.commulade.model.pojo;

import java.time.LocalDate;
import java.util.List;

public class Topo {
	
	private Integer id;
	private List<Site> listSite;
	private LocalDate editionDate;
	private String description, name;
	
	
	public Topo() {
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param editionDate
	 * @param description
	 * @param listSite
	 */
	public Topo(Integer id, String name, LocalDate editionDate, String description, List<Site> listSite) {
		this.id = id;
		this.name = name;
		this.editionDate = editionDate;
		this.description = description;
		this.listSite = listSite;
	}
	
	
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
	 * @return the listSite
	 */
	public List<Site> getListSite() {
		return listSite;
	}
	
	
	/**
	 * @param listSite
	 *           the listSite to set
	 */
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	
	
	/**
	 * @return the editionDate
	 */
	public LocalDate getEditionDate() {
		return editionDate;
	}
	
	
	/**
	 * @param editionDate
	 *           the editionDate to set
	 */
	public void setEditionDate(LocalDate editionDate) {
		this.editionDate = editionDate;
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
