package fr.silvharm.commulade.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.MessageInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.pojo.Message;


public class MessageAction extends ActionSupport implements SessionAware {
	
	private Integer messageId, userId;
	private List<Message> receivedList, sentList;
	private Map<String, Object> session;
	private Message message;
	private MessageInteractions messageInteractions;
	private String contentJsp = "view-messages", css = "view-messages", js = "view-messages", title = "Messagerie",
			username;
	private UserInteractions userInteractions;
	
	
	public String execute() {
		setUserId();
		setUsername();
		
		if (userId != null && username != null) {
			if (userInteractions.verifyUser(userId, username)) {
				List<List<Message>> list = messageInteractions.getUserMessageList(userId);
				
				if (list != null) {
					if (list.get(0) != null) {
						receivedList = list.get(0);
					}
					if (list.get(1) != null) {
						sentList = list.get(1);
					}
				}
				
				return SUCCESS;
			}
		}
		
		return ERROR;
	}
	
	
	public String getSpecificMessage() {
		setUserId();
		setUsername();
		
		if (userId != null && username != null) {
			if (userInteractions.verifyUser(userId, username)) {
				message = messageInteractions.getUserMessage(messageId, userId);
				
				if (message != null) {
					if (message.getSenderId() == userId) {
						message.setSenderId(null);
					}
					else {
						message.setReceiverId(null);
					}
					
					return SUCCESS;
				}
			}
		}
		
		return ERROR;
	}
	
	
	public String wasRead() {
		setUserId();
		setUsername();
		
		if (messageId != null && userId != null && username != null) {
			if (userInteractions.verifyUser(userId, username)) {
				messageInteractions.messageWasRead(messageId, userId);
			}
		}
		
		return NONE;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the contentJsp
	 */
	public String getContentJsp() {
		return contentJsp;
	}
	
	
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}
	
	
	/**
	 * @param messageId
	 *           the messageId to set
	 */
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	
	
	/**
	 * @param messageInteractions
	 *           the messageInteractions to set
	 */
	public void setMessageInteractions(MessageInteractions messageInteractions) {
		this.messageInteractions = messageInteractions;
	}
	
	
	/**
	 * @return the receivedList
	 */
	public List<Message> getReceivedList() {
		return receivedList;
	}
	
	
	/**
	 * @return the sentList
	 */
	public List<Message> getSentList() {
		return sentList;
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	public void setUserId() {
		this.userId = (Integer) session.get("userId");
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
	
	public void setUsername() {
		this.username = (String) session.get("username");
	}
	
}
