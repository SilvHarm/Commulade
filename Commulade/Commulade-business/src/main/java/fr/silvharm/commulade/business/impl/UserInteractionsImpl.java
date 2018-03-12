package fr.silvharm.commulade.business.impl;

import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.consumer.contract.dao.UserDao;
import fr.silvharm.commulade.model.pojo.User;


public class UserInteractionsImpl implements UserInteractions {
	
	private UserDao userDao;
	
	
	public Boolean connectUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Boolean isUserConform(User user) {
		String tempo = user.getUsername();
		if (tempo.matches("[0-9a-zA-Z]")) {
			if (5 < tempo.length() && tempo.length() < 33) {
				
			}
		}
		
		return false;
	}
	
	
	public User registerUser(User user) {
		// TODO Auto-generated method stub
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
