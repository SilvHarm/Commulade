package fr.silvharm.commulade.model.pojo;

import java.time.LocalDateTime;

public class Comment {
	
	private Integer id, postId, postType, userId;
	private LocalDateTime dateTime;
	private String comment;
	
	
	public Comment() {}
	
	
	/**
	 * Used to create a new Comment that was just post by a User with the purpose to
	 * add it to the database
	 * 
	 * @param userId
	 * @param postType
	 * @param postId
	 * @param dateTime
	 * @param comment
	 */
	public Comment(Integer userId, Integer postType, Integer postId, LocalDateTime dateTime, String comment) {
		this.userId = userId;
		this.postType = postType;
		this.postId = postId;
		this.dateTime = dateTime;
		this.comment = comment;
	}
	
	
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
	 * @return the postType
	 */
	public Integer getPostType() {
		return postType;
	}
	
	
	/**
	 * @param postType
	 *           the postType to set
	 */
	public void setPostType(Integer postType) {
		this.postType = postType;
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
