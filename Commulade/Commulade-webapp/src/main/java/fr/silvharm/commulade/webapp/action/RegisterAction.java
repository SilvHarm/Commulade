package fr.silvharm.commulade.webapp.action;

import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.pojo.User;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class RegisterAction extends SessionHelper {
	
	private String contentJsp = "register", css = "regis-login", js = null, title = "S'inscrire au site";
	private User user;
	private UserInteractions userInteractions;
	
	
	public String execute() {
		return SUCCESS;
	}
	
	
	public String register() {
		user = userInteractions.registerUser(user);
		
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
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
