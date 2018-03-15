package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.pojo.Message;

public interface MessageInteractions {
	
	/**
	 * Call the consumer module to get the Message of the user and sort them between
	 * received and send
	 * 
	 * @param userId
	 * @param username
	 * @return a List containing 2 List<Message>, the first for the received and the
	 *         second for the sended or null if User don't exist
	 */
	public List<List<Message>> getUserMessages(int userId, String username);
	
	
	/**
	 * Mark the message with the provided id as read
	 * 
	 * @param messageId
	 * @param userId
	 * @param username
	 */
	public void messageWasRead(int messageId, int userId, String username);
	
	
	/**
	 * Send a Message to another User
	 * 
	 * @param message
	 * @param senderName
	 */
	public boolean sendMessage(Message message, String senderName, String receiverName);
}
