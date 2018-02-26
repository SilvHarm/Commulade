package fr.silvharm.commulade.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.SiteInteractions;
import fr.silvharm.commulade.model.pojo.Site;


public class RechercheSiteAction extends ActionSupport {
	
	private String contentJsp = "recherche-site", css = null, js = null, title = "Recherche de Site";
	
	private SiteInteractions siteInteractions;
	
	
	public String execute() {
		List<Site> list = siteInteractions.getAllSite();
		
		System.out.println(list.size());
		
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
	 * @param siteInteractions
	 *           the siteInteractions to set
	 */
	public void setSiteInteractions(SiteInteractions siteInteractions) {
		this.siteInteractions = siteInteractions;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
}
