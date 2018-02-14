package fr.silvharm.commulade.model.pojo;


public class Secteur {
	
	private int id, siteId;
	private String name;
	
	
	/**
	 * @param id
	 * @param name
	 * @param siteId
	 */
	public Secteur(int id, String name, int siteId) {
		this.id = id;
		this.name = name;
		this.siteId = siteId;
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
	 * @return the siteId
	 */
	public int getSiteId() {
		return siteId;
	}
	
	
	/**
	 * @param siteId
	 *           the siteId to set
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
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
