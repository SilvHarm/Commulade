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
			contentJsp = "error";
			
			return ERROR;
		}
		
		newSiteId = siteInteractions.shareSite(topoForm);
		
		if (newSiteId == null) {
			contentJsp = "error";
			
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
	 * @param title
	 *           the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
