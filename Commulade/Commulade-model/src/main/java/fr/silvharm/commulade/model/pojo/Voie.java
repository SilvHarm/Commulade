package fr.silvharm.commulade.model.pojo;


public class Voie {
	
	private int id, secteurId;
	private String name;
	
	
	/**
	 * @param id
	 * @param name
	 * @param secteurId
	 */
	public Voie(int id, String name, int secteurId) {
		this.id = id;
		this.name = name;
		this.secteurId = secteurId;
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
	 * @return the secteurId
	 */
	public int getSecteurId() {
		return secteurId;
	}
	
	
	/**
	 * @param secteurId
	 *           the secteurId to set
	 */
	public void setSecteurId(int secteurId) {
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
