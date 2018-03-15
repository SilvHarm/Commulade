package fr.silvharm.commulade.business.impl;

import java.util.ArrayList;
import java.util.List;

import fr.silvharm.commulade.business.contract.MessageInteractions;
import fr.silvharm.commulade.consumer.contract.dao.MessageDao;
import fr.silvharm.commulade.consumer.contract.dao.UserDao;
import fr.silvharm.commulade.model.pojo.Message;
import fr.silvharm.commulade.model.pojo.User;


public class MessageInteractionsImpl implements MessageInteractions {
	
	private MessageDao messageDao;
	private UserDao userDao;
	
	
	public List<List<Message>> getUserMessageList(int userId) {
		List<Message> list = messageDao.findByUserId(userId);
		
		if (list != null && !list.isEmpty()) {
			List<Message> received = new ArrayList<Message>();
			List<Message> sended = new ArrayList<Message>();
			
			for (Message message : list) {
				if (message.getReceiverId() == userId) {
					received.add(message);
				}
				else {
					sended.add(message);
				}
			}
			
			List<List<Message>> toReturn = new ArrayList<List<Message>>();
			toReturn.add(received);
			toReturn.add(sended);
			
			return toReturn;
		}
		
		return null;
	}
	
	
	public Message getUserMessage(int messageId, int userId) {
		return messageDao.findByIdUserId(messageId, userId);
	}
	
	
	public void messageWasRead(int messageId, int userId) {
		messageDao.updateAsRead(messageId, userId);
	}
	
	
	public boolean sendMessage(Message message, String receiverName) {
		User receiver = userDao.findByName(receiverName);
		
		if (receiver != null) {
			message.setReceiverId(receiver.getId());
			
			messageDao.create(message);
			
			return true;
		}
		
		return false;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param messageDao
	 *           the messageDao to set
	 */
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	
	/**
	 * @param userDao
	 *           the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
