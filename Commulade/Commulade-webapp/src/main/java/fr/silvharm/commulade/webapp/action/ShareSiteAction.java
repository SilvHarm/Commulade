package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.model.bean.TopoFormBean;

public class ShareSiteAction extends ActionSupport {
	
	private Integer newSiteId;
	private SiteInteractions siteInteractions;
	private String contentJsp = "share-site", css = "share-site-topo", js = "share-site-topo",
			title = "Partager un site";
	private TopoFormBean topoForm;
	
	
	public String execute() {
		return SUCCESS;
	}
	
	
	public String getForm() {
		if (topoForm == null) {
			return ERROR;
		}
		
		newSiteId = siteInteractions.shareSite(topoForm);
		
		if (newSiteId == null) {
			return ERROR;
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
	 * @return the newSiteId
	 */
	public int getNewSiteId() {
		return newSiteId;
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
	
	
	/**
	 * @return the topoForm
	 */
	public TopoFormBean getTopoForm() {
		return topoForm;
	}
	
	
	/**
	 * @param topoForm
	 *           the topoForm to set
	 */
	public void setTopoForm(TopoFormBean topoForm) {
		this.topoForm = topoForm;
	}
	
}
