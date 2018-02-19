package fr.silvharm.commulade.model.pojo;

import java.time.LocalDateTime;

public class Comment {
	
	private Integer id, postId, postTypeId, userId;
	private LocalDateTime dateTime;
	private String comment;
	
	
	public Comment() {
	}
	
	
	/**
	 * @param id
	 * @param userId
	 * @param postTypeId
	 * @param postId
	 * @param dateTime
	 * @param comment
	 */
	public Comment(Integer id, Integer userId, Integer postTypeId, Integer postId, LocalDateTime dateTime,
			String comment) {
		this.id = id;
		this.userId = userId;
		this.postTypeId = postTypeId;
		this.postId = postId;
		this.dateTime = dateTime;
		this.comment = comment;
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
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}
	
	
	/**
	 * @param postId
	 *           the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	
	/**
	 * @return the postTypeId
	 */
	public Integer getPostTypeId() {
		return postTypeId;
	}
	
	
	/**
	 * @param postTypeId
	 *           the postTypeId to set
	 */
	public void setPostTypeId(Integer postTypeId) {
		this.postTypeId = postTypeId;
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
	
	
	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	
	/**
	 * @param dateTime
	 *           the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	
	/**
	 * @param comment
	 *           the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
