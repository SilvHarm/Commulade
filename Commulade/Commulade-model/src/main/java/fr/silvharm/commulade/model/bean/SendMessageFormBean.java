package fr.silvharm.commulade.model.bean;


public class SendMessageFormBean {
	
	private String content, receiverName, subject;
	
	
	public SendMessageFormBean() {};
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
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
	 * @return the receiverName
	 */
	public String getReceiverName() {
		return receiverName;
	}
	
	
	/**
	 * @param receiverName
	 *           the receiverName to set
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
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
