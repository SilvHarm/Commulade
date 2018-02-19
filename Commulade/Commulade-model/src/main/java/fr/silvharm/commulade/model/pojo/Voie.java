package fr.silvharm.commulade.model.pojo;


public class Voie {
	
	private Integer id, secteurId;
	private String name;
	
	
	public Voie() {
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param secteurId
	 */
	public Voie(Integer id, String name, Integer secteurId) {
		this.id = id;
		this.name = name;
		this.secteurId = secteurId;
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
	 * @return the secteurId
	 */
	public Integer getSecteurId() {
		return secteurId;
	}
	
	
	/**
	 * @param secteurId
	 *           the secteurId to set
	 */
	public void setSecteurId(Integer secteurId) {
		this.secteurId = secteurId;
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
