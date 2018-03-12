package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorAction extends ActionSupport {
	
	private String contentJsp = "error", css = null, js = null, title = "ERROR";
	
	
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
}
