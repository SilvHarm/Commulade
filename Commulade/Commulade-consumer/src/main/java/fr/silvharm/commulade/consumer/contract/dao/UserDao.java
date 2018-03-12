package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.User;

public interface UserDao {
	
	final String TABLE_NAME = "user_table";
	
	final String ID = "id", USERNAME = "username", PASSWORD = "password";
	
	
	/**
	 * Insert the provided User in the database
	 * 
	 * @param user
	 * @return the id of the newly created user
	 */
	public Integer create(User user);
	
	
	/**
	 * Delete from the database the User associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the User whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the User associated to the id provided
	 */
	public User findById(int id);
	
	
	/**
	 * Get from the database the User whom the username is equal to the one provided
	 * 
	 * @param username
	 * @return the User associated to the username provided
	 */
	public User findByName(String username);
	
	
	/**
	 * Update the properties of the User from the database, whom the id is equal to
	 * the id of the User provided, by the ones of the User provided
	 * 
	 * @param user
	 */
	public void update(User user);
	
}
