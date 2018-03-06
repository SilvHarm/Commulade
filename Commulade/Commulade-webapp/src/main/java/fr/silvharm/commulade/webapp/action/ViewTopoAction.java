package fr.silvharm.commulade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.model.pojo.ConfigContainer;
import fr.silvharm.commulade.model.pojo.Topo;

public class ViewTopoAction extends ActionSupport {
	
	private Boolean isUpToDate;
	private ConfigContainer configContainer;
	private int topoId;
	private Topo topo;
	private TopoInteractions topoInteractions;
	private String contentJsp = "view-topo", css = "view-site-topo", js = "view-site-topo", title = "Topo: ";
	
	@SuppressWarnings("unused") // are used by struts in the jsp
	private String secteurPhotoPath, sitePhotoPath;
	
	
	public String execute() {
		topo = topoInteractions.getTopo(topoId);
		
		if (topo != null) {
			title += topo.getName();
			
			isUpToDate = topoInteractions.isUpToDate(topo);
		}
		else {
			title = "Topo not Found";
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
	 * @return the isUpToDate
	 */
	public Boolean getIsUpToDate() {
		return isUpToDate;
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
	public Topo getTopo() {
		return topo;
	}
	
	
	/**
	 * @param siteId
	 *           the siteId to set
	 */
	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}
	
	
	/**
	 * @param siteInteractions
	 *           the siteInteractions to set
	 */
	public void setTopoInteractions(TopoInteractions topoInteractions) {
		this.topoInteractions = topoInteractions;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
}
