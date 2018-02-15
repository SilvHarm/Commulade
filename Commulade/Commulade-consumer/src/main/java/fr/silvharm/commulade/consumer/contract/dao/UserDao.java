package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.User;

public interface UserDao {
	
	public void create(User user);
	
	
	public void delete(int id);
	
	
	public User find(int id);
	
	
	public void update(User user);
	
}
