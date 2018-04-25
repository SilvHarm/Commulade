package fr.silvharm.commulade.webapp.helper;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.UserInteractions;


public abstract class SessionHelper extends ActionSupport implements SessionAware {
	
	protected Map<String, Object> session;
	
	public static final String USERNAME_KEY = "username", USER_ID_KEY = "userId";
	
	protected Integer userId;
	protected String username;
	protected UserInteractions userInteractions;
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	/**
	 * Put username value in session using usernameKey as key
	 * 
	 * @param username
	 */
	public void addUsername(String username) {
		session.put(USERNAME_KEY, username);
	}
	
	
	/**
	 * Retrieve the username property in session
	 * 
	 * @return the username of the User or null
	 */
	public String getUsername() {
		return (String) session.get(USERNAME_KEY);
	}
	
	
	/**
	 * username value become getUsername() result
	 */
	public void setUsername() {
		username = getUsername();
	}
	
	
	/**
	 * remove the username property in session
	 */
	public void removeUsername() {
		session.remove(USERNAME_KEY);
	}
	
	
	/**
	 * Put userId value in session using userIdKey as key
	 * 
	 * @param userId
	 */
	public void addUserId(Integer userId) {
		session.put(USER_ID_KEY, userId);
	}
	
	
	/**
	 * Retrieve the userId property in session
	 * 
	 * @return the userId of the User or null
	 */
	public Integer getUserId() {
		return (Integer) session.get(USER_ID_KEY);
	}
	
	
	/**
	 * userId value become getUserId() result
	 */
	public void setUserId() {
		userId = getUserId();
	}
	
	
	/**
	 * remove the userId property in session
	 */
	public void removeUserId() {
		session.remove(USER_ID_KEY);
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
