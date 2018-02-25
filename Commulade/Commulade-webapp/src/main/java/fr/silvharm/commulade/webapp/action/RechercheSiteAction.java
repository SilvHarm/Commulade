package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;


public class RechercheSiteAction extends ActionSupport {
	
	private String contentJsp = "recherche-site", css = null, js = null, title = "Recherche de Site";
	
	
	public String execute() {
		return SUCCESS;
	}
	
	
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
