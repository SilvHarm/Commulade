package fr.silvharm.commulade.business.contract;

import fr.silvharm.commulade.model.pojo.User;

public interface UserInteractions {
	
	/**
	 * Verify if the User is conform and call the consumer module to know if he is
	 * registered in the database
	 * 
	 * @param user
	 * @return the User with it's id added or null
	 */
	public User connectUser(User user);
	
	
	/**
	 * Verify if the User is conform and call the consumer module to register it in
	 * the database
	 * 
	 * @param user
	 * @return the User registered with it's id or null
	 */
	public User registerUser(User user);
	
	
	/**
	 * Verify if there is a User with the couple {userId, username}
	 * 
	 * @param userId
	 * @param username
	 * @return true if there is one or false
	 */
	public Boolean verifyUser(int userId, String username);
	
}
