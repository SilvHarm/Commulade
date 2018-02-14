package fr.silvharm.commulade.model.pojo;

import java.time.LocalDateTime;

public class Message {
	
	private Boolean messageRead;
	private Integer id, previousMessageId, receiverId, senderId;
	private LocalDateTime dateTime;
	private String content, subject;
	
	
	/**
	 * @param id
	 * @param receiverId
	 * @param senderId
	 * @param previousMessageId
	 * @param dateTime
	 * @param messageRead
	 * @param subject
	 * @param content
	 */
	public Message(Integer id, Integer receiverId, Integer senderId, Integer previousMessageId, LocalDateTime dateTime,
			Boolean messageRead, String subject, String content) {
		this.id = id;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.previousMessageId = previousMessageId;
		this.dateTime = dateTime;
		this.messageRead = messageRead;
		this.subject = subject;
		this.content = content;
	}
	
	
	/**
	 * @return the messageRead
	 */
	public Boolean getMessageRead() {
		return messageRead;
	}
	
	
	/**
	 * @param messageRead
	 *           the messageRead to set
	 */
	public void setMessageRead(Boolean messageRead) {
		this.messageRead = messageRead;
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
	 * @return the previousMessageId
	 */
	public Integer getPreviousMessageId() {
		return previousMessageId;
	}
	
	
	/**
	 * @param previousMessageId
	 *           the previousMessageId to set
	 */
	public void setPreviousMessageId(Integer previousMessageId) {
		this.previousMessageId = previousMessageId;
	}
	
	
	/**
	 * @return the receiverId
	 */
	public Integer getReceiverId() {
		return receiverId;
	}
	
	
	/**
	 * @param receiverId
	 *           the receiverId to set
	 */
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	
	
	/**
	 * @return the senderId
	 */
	public Integer getSenderId() {
		return senderId;
	}
	
	
	/**
	 * @param senderId
	 *           the senderId to set
	 */
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	
	/**
	 * @param content
	 *           the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	
	/**
	 * @param subject
	 *           the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
