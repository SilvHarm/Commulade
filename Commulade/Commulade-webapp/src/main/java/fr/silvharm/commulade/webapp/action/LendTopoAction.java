package fr.silvharm.commulade.webapp.action;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class LendTopoAction extends SessionHelper {
	
	private String contentJsp = "lend-topo", css = "lend-topo", js = null, title = "Espace de partage";
	private TopoInteractions topoInteractions;
	private UserInteractions userInteractions;
	
	
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
	
	
	/**
	 * @param topoInteractions
	 *           the topoInteractions to set
	 */
	public void setTopoInteractions(TopoInteractions topoInteractions) {
		this.topoInteractions = topoInteractions;
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
