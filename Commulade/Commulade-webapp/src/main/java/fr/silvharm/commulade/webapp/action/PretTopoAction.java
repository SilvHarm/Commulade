package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;


public class PretTopoAction extends ActionSupport {
	
	private String contentJsp = "pret-topo", css = null, js = null, title = "Prêt de Topo";
	
	
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
