package fr.silvharm.commulade.consumer.contract.dao;

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
	 * Update the properties of the Message from the database, whom the id is equal
	 * to the id of the Message provided, by the ones of the Message provided
	 * 
	 * @param message
	 */
	public void update(Message message);
	
}
