package fr.silvharm.commulade.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.pojo.User;

public class RegisterAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
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
		
		session.put("userId", user.getId());
		session.put("username", user.getUsername());
		
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
	 * @param contentJsp
	 *           the contentJsp to set
	 */
	public void setContentJsp(String contentJsp) {
		this.contentJsp = contentJsp;
	}
	
	
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	
	
	/**
	 * @param css
	 *           the css to set
	 */
	public void setCss(String css) {
		this.css = css;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @param js
	 *           the js to set
	 */
	public void setJs(String js) {
		this.js = js;
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @param title
	 *           the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
