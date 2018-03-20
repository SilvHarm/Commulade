package fr.silvharm.commulade.model.bean;


public class CommentFormBean {
	
	private String comment, postId, postType, username;
	
	
	public CommentFormBean() {}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
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
	
	
	/**
	 * @return the postId
	 */
	public String getPostId() {
		return postId;
	}
	
	
	/**
	 * @param postId
	 *           the postId to set
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	
	/**
	 * @return the postType
	 */
	public String getPostType() {
		return postType;
	}
	
	
	/**
	 * @param postType
	 *           the postType to set
	 */
	public void setPostType(String postType) {
		this.postType = postType;
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
