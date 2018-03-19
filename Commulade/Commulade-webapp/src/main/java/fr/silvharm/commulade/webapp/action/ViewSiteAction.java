package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.model.pojo.ConfigContainer;
import fr.silvharm.commulade.model.pojo.Site;

public class ViewSiteAction extends ActionSupport {
	
	private ConfigContainer configContainer;
	private int siteId;
	private Site site;
	private SiteInteractions siteInteractions;
	private String contentJsp = "view-site", css = "view-site-topo", js = "view-site-topo", title = "Site: ";
	
	@SuppressWarnings("unused") // are used by struts in the jsp
	private String secteurPhotoPath, sitePhotoPath;
	
	
	public String execute() {
		site = siteInteractions.getSiteById(siteId);
		
		if (site != null) {
			title += site.getName();
		}
		else {
			title = "Site not Found";
		}
		
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
	 * @return the secteurPhotoPath
	 */
	public String getSecteurPhotoPath() {
		return configContainer.getSecteurPhotoPath();
	}
	
	
	/**
	 * @return the sitePhotoPath
	 */
	public String getSitePhotoPath() {
		return configContainer.getSitePhotoPath();
	}
	
	
	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}
	
	
	/**
	 * @param siteId
	 *           the siteId to set
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
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
