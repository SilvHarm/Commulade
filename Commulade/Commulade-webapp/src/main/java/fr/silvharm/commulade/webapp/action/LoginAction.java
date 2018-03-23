package fr.silvharm.commulade.webapp.action;

import fr.silvharm.commulade.model.pojo.User;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class LoginAction extends SessionHelper {
	
	private String contentJsp = "login", css = "regis-login", js = null, title = "Se connecter au site";
	private User user;
	
	
	public String execute() {
		return SUCCESS;
	}
	
	
	public String disconnect() {
		removeUserId();
		removeUsername();
		
		return SUCCESS;
	}
	
	
	public String login() {
		user = userInteractions.connectUser(user);
		
		if (user == null) {
			return ERROR;
		}
		
		addUserId(user.getId());
		addUsername(user.getUsername());
		
		return SUCCESS;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the contentJsp
	 */
	public String getContentJsp() {
		return contentJsp;
	}
	
	
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	
	/**
	 * @param user
	 *           the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
