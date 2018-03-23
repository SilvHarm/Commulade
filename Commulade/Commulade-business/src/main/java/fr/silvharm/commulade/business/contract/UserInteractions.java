package fr.silvharm.commulade.business.contract;

import java.util.List;
import java.util.Map;

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
	 * Call the consumer module to get the username of the User associated to the id
	 * provided
	 * 
	 * @param userId
	 * @return the username of the User associated to userId
	 */
	public String getUsernameById(int userId);
	
	
	/**
	 * Get all User associated to the id provided from the database and put their
	 * username in a Map using their id as key
	 * 
	 * @param userId
	 * @return a Map containing all {id, username} pair associated to the id in the
	 *         List
	 */
	public Map<Integer, String> getUsernameMapByIdList(List<Integer> userIdList);
	
	
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
	public Boolean verifyUser(Integer userId, String username);
	
}
