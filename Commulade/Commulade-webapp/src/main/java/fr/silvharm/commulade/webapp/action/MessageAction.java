package fr.silvharm.commulade.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.MessageInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.bean.SendMessageFormBean;
import fr.silvharm.commulade.model.pojo.Message;


public class MessageAction extends ActionSupport implements SessionAware {
	
	private Integer messageId, userId;
	private List<Message> receivedList, sentList;
	private Map<Integer, String> usernameMap;
	private Map<String, Object> session;
	private Message message;
	private MessageInteractions messageInteractions;
	private SendMessageFormBean sendMessageForm;
	private String contentJsp = "view-messages", css = "view-messages", js = "view-messages", otherName,
			title = "Messagerie", username;
	private UserInteractions userInteractions;
	
	
	public String execute() {
		getUserId();
		getUsername();
		
		if (userId != null && username != null) {
			if (userInteractions.verifyUser(userId, username)) {
				List<List<Message>> list = messageInteractions.getUserMessageList(userId);
				
				if (list != null) {
					List<Integer> userIdList = new ArrayList<Integer>();
					
					if (list.get(0) != null) {
						receivedList = list.get(0);
						
						for (Message message : receivedList) {
							if (!userIdList.contains(message.getSenderId())) {
								userIdList.add(message.getSenderId());
							}
						}
					}
					if (list.get(1) != null) {
						sentList = list.get(1);
						
						for (Message message : sentList) {
							if (!userIdList.contains(message.getReceiverId())) {
								userIdList.add(message.getReceiverId());
							}
						}
					}
					
					usernameMap = userInteractions.getUsernameMapByIdList(userIdList);
				}
				
				return SUCCESS;
			}
		}
		
		return ERROR;
	}
	
	
	public String getSendMessageJsp() {
		return SUCCESS;
	}
	
	
	public String getSpecificMessage() {
		getUserId();
		getUsername();
		
		if (userId != null && username != null) {
			if (userInteractions.verifyUser(userId, username)) {
				message = messageInteractions.getUserMessage(messageId, userId);
				
				if (message != null) {
					Integer idToGet;
					
					if (message.getReceiverId().equals(userId)) {
						message.setReceiverId(null);
						idToGet = message.getSenderId();
					}
					else {
						message.setSenderId(null);
						idToGet = message.getReceiverId();
					}
					
					
					if (idToGet != null) {
						otherName = userInteractions.getUsernameById(idToGet);
					}
					
					return SUCCESS;
				}
			}
		}
		
		return ERROR;
	}
	
	
	public String sendMessage() {
		getUserId();
		getUsername();
		
		if (userId != null && username != null) {
			if (userInteractions.verifyUser(userId, username)) {
				messageInteractions.sendMessage(sendMessageForm, userId);
				
				return SUCCESS;
			}
		}
		
		return ERROR;
	}
	
	
	public String wasRead() {
		getUserId();
		getUsername();
		
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
	 * @return the otherName
	 */
	public String getOtherName() {
		return otherName;
	}
	
	
	/**
	 * @return the receivedList
	 */
	public List<Message> getReceivedList() {
		return receivedList;
	}
	
	
	/**
	 * @return the sendMessageForm
	 */
	public SendMessageFormBean getSendMessageForm() {
		return sendMessageForm;
	}
	
	
	/**
	 * @param sendMessageForm
	 *           the sendMessageForm to set
	 */
	public void setSendMessageForm(SendMessageFormBean sendMessageForm) {
		this.sendMessageForm = sendMessageForm;
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
	
	
	public void getUserId() {
		this.userId = (Integer) session.get("userId");
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
	
	public void getUsername() {
		this.username = (String) session.get("username");
	}
	
	
	/**
	 * @return the usernameMap
	 */
	public Map<Integer, String> getUsernameMap() {
		return usernameMap;
	}
	
	
	/**
	 * @param usernameMap
	 *           the usernameMap to set
	 */
	public void setUsernameMap(Map<Integer, String> usernameMap) {
		this.usernameMap = usernameMap;
	}
	
}
