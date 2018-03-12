package fr.silvharm.commulade.business.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.consumer.contract.dao.UserDao;
import fr.silvharm.commulade.model.pojo.User;


public class UserInteractionsImpl implements UserInteractions {
	
	private static final Logger logger = LogManager.getLogger();
	
	private UserDao userDao;
	
	
	public User connectUser(User user) {
		if (isUserConform(user)) {
			User queryUser = userDao.findByName(user.getUsername());
			if (queryUser != null) {
				if (user.getUsername().equals(queryUser.getUsername())
						&& user.getPassword().equals(queryUser.getPassword())) {
					return queryUser;
				}
			}
		}
		
		return null;
	}
	
	
	/**
	 * Verify if the User is conform to what is expected
	 * 
	 * @param user
	 * @return true if the User is conform or false
	 */
	private Boolean isUserConform(User user) {
		String tempo = user.getUsername();
		if (tempo.replaceAll("[a-zA-Z]", "").length() == 0) {
			if (5 < tempo.length() && tempo.length() < 33) {
				
				tempo = user.getPassword();
				if (5 < tempo.length() && tempo.length() < 17) {
					logger.info("User is conform");
					
					return true;
				}
				
				logger.info("password property length is unexpected : " + user.getPassword());
			}
			
			logger.info("username property length is unexpected : " + user.getUsername());
		}
		
		logger.info("username property doesn't math regex : " + user.getUsername());
		
		return false;
	}
	
	
	public User registerUser(User user) {
		if (isUserConform(user)) {
			if (userDao.findByName(user.getUsername()) == null) {
				user.setId(userDao.create(user));
				
				return user;
			}
		}
		
		return null;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param userDao
	 *           the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
