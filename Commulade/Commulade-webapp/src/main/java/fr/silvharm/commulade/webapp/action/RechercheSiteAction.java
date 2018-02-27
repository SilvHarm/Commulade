package fr.silvharm.commulade.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.SiteInteractions;
import fr.silvharm.commulade.model.pojo.ConfigContainer;
import fr.silvharm.commulade.model.pojo.Site;


public class RechercheSiteAction extends ActionSupport {
	
	private ConfigContainer configContainer;
	private List<Site> list;
	private SiteInteractions siteInteractions;
	private String contentJsp = "recherche-site", css = "recherche-site", js = "recherche-site", photoPath,
			title = "Recherche de Site";
	
	
	public String execute() {
		list = siteInteractions.getAllSite();
		
		return SUCCESS;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param configContainer
	 *           the configContainer to set
	 */
	public void setConfigContainer(ConfigContainer configContainer) {
		this.configContainer = configContainer;
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
	 * @return the list
	 */
	public List<Site> getList() {
		return list;
	}
	
	
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return configContainer.getSitePhotoPath();
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
