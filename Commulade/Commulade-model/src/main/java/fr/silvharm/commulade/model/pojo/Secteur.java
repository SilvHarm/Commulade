package fr.silvharm.commulade.model.pojo;


public class Secteur {
	
	private Integer id, siteId;
	private String name;
	
	
	/**
	 * @param id
	 * @param name
	 * @param siteId
	 */
	public Secteur(Integer id, String name, Integer siteId) {
		this.id = id;
		this.name = name;
		this.siteId = siteId;
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
