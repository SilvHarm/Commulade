package fr.silvharm.commulade.model.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
	
	private Boolean messageRead;
	private Integer id, previousMessageId, receiverId, senderId;
	private LocalDateTime dateTime;
	private String content, dateStr, dateTimeStr, subject, timeStr;
	
	
	public Message() {}
	
	
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
		
		setDateTimeStr();
		setDateStr();
		setTimeStr();
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
	 * @return the dateStr
	 */
	public String getDateStr() {
		return dateStr;
	}
	
	
	private void setDateStr() {
		dateStr = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(dateTime);
	}
	
	
	/**
	 * @return the dateTimeStr
	 */
	public String getDateTimeStr() {
		return dateTimeStr;
	}
	
	
	private void setDateTimeStr() {
		dateTimeStr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
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
	
	
	/**
	 * @return the timeStr
	 */
	public String getTimeStr() {
		return timeStr;
	}
	
	
	private void setTimeStr() {
		timeStr = DateTimeFormatter.ofPattern("HH:mm").format(dateTime);
	}
	
}
