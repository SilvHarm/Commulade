package fr.silvharm.commulade.model.pojo;

public class TopoOwnedByUser {
	
	private Integer id, topoId, ownerId;
	private String topoName, username;
	
	
	public TopoOwnedByUser() {}
	
	
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
	 * @return the topoId
	 */
	public Integer getTopoId() {
		return topoId;
	}
	
	
	/**
	 * @param topoId
	 *           the topoId to set
	 */
	public void setTopoId(Integer topoId) {
		this.topoId = topoId;
	}
	
	
	/**
	 * @return the ownerId
	 */
	public Integer getOwnerId() {
		return ownerId;
	}
	
	
	/**
	 * @param ownerId
	 *           the ownerId to set
	 */
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	
	
	/**
	 * @return the topoName
	 */
	public String getTopoName() {
		return topoName;
	}
	
	
	/**
	 * @param topoName
	 *           the topoName to set
	 */
	public void setTopoName(String topoName) {
		this.topoName = topoName;
	}
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	
	/**
	 * @param username
	 *           the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
