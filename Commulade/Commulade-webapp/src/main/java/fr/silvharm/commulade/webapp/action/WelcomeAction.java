package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;


public class WelcomeAction extends ActionSupport {
	
	private String contentJsp = "index", css = "index", js = null, title = "Welcome";
	
	
	public String execute() {
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
	
}
