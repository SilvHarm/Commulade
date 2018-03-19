package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.bean.SendMessageFormBean;
import fr.silvharm.commulade.model.pojo.Message;

public interface MessageInteractions {
	
	/**
	 * Call the consumer module to get all the Message related to the user and sort
	 * them between received and send
	 * 
	 * @param userId
	 * @param username
	 * @return a List containing 2 List<Message> ordered by recent first; the first
	 *         for the received and the second for the sended or null if User don't
	 *         exist
	 */
	public List<List<Message>> getUserMessageList(int userId);
	
	
	/**
	 * Call the consumer module to get the Message sent or received by the user whom
	 * the id are equals to the ones provided
	 * 
	 * @param messageId
	 * @param userId
	 * @return the Message requested or null
	 */
	public Message getUserMessage(int messageId, int userId);
	
	
	/**
	 * Mark the message with the provided id as read
	 * 
	 * @param messageId
	 * @param userId
	 * @param username
	 */
	public void messageWasRead(int messageId, int userId);
	
	
	/**
	 * Send a Message to another User by using a SendMessageFormBean
	 * 
	 * @param messageForm
	 * @param senderId
	 */
	public boolean sendMessage(SendMessageFormBean messageForm, int senderId);
}
