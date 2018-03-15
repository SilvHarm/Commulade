package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

import fr.silvharm.commulade.model.pojo.Message;

public interface MessageDao {
	
	final String TABLE_NAME = "message";
	
	final String ID = "id", RECEIVER_ID = "receiver_id", SENDER_ID = "sender_id",
			PREVIOUS_MESSAGE_ID = "previous_message_id", DATE_TIME = "date_time", MESSAGE_READ = "message_read",
			SUBJECT = "subject", CONTENT = "content";
	
	
	/**
	 * Insert the provided Message in the database
	 * 
	 * @param message
	 */
	public void create(Message message);
	
	
	/**
	 * Delete from the database the Message associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Message whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Message associated to the id provided
	 */
	public Message findById(int id);
	
	
	/**
	 * Get from the database the Message whom the id and one of the userId are
	 * equals to the ones provided
	 * 
	 * @param id
	 * @param userId
	 * @return the Message associated to the id and userId provided
	 */
	public Message findByIdUserId(int id, int userId);
	
	
	/**
	 * Get from the database the Message whom the receiver_id or the sender_id is
	 * equal to the userId provided
	 * 
	 * @param userId
	 * @return a List of Message, ordered by recent first, associated to the userId
	 *         provided
	 */
	public List<Message> findByUserId(int userId);
	
	
	/**
	 * Update the properties of the Message from the database, whom the id is equal
	 * to the id of the Message provided, by the ones of the Message provided
	 * 
	 * @param message
	 */
	public void update(Message message);
	
	
	/**
	 * Change to true the message_read column of the Message whom the id and the
	 * receiver_id are equals to the ones provided
	 * 
	 * @param messageId
	 * @param receiverId
	 */
	public void updateAsRead(int messageId, int receiverId);
	
}
