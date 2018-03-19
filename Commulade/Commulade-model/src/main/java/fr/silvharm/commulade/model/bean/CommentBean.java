package fr.silvharm.commulade.model.bean;

public class CommentBean {
	
	private String comment, date, time, username;
	
	
	public CommentBean() {}
	
	
	/**
	 * @param username
	 * @param date
	 * @param time
	 * @param comment
	 */
	public CommentBean(String username, String date, String time, String comment) {
		this.username = username;
		this.date = date;
		this.comment = comment;
	}
	
	
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	
	/**
	 * @param date
	 *           the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	
	
	/**
	 * @param time
	 *           the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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
