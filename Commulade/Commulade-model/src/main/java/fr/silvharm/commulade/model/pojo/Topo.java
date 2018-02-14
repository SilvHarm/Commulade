package fr.silvharm.commulade.model.pojo;

import java.time.LocalDate;

public class Topo {
	
	private int id;
	private LocalDate editionDate;
	private String description, name;
	
	
	/**
	 * @param id
	 * @param name
	 * @param editionDate
	 * @param description
	 */
	public Topo(int id, String name, LocalDate editionDate, String description) {
		this.id = id;
		this.name = name;
		this.editionDate = editionDate;
		this.description = description;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
