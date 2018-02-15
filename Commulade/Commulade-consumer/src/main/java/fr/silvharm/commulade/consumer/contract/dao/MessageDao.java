package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Message;

public interface MessageDao {
	
	public void create(Message message);
	
	
	public void delete(int id);
	
	
	public Message find(int id);
	
	
	public void update(Message message);
	
}
