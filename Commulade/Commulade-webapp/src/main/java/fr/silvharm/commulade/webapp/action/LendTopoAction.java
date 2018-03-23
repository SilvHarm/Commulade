package fr.silvharm.commulade.webapp.action;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class LendTopoAction extends SessionHelper {
	
	private String contentJsp = "lend-topo", css = "lend-topo", js = null, title = "Espace de partage";
	private TopoInteractions topoInteractions;
	
	
	public String execute() {
		if (userInteractions.verifyUser(getUserId(), getUsername())) {
			
		}
		
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
	
}
