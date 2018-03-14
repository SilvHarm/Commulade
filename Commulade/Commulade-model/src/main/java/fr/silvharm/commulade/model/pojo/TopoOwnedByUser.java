package fr.silvharm.commulade.model.pojo;

public class TopoOwnedByUser {
	
	private Integer id, topoId, userId;
	
	
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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	
	
	/**
	 * @param userId
	 *           the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
