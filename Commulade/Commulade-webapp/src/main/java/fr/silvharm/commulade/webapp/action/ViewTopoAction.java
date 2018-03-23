package fr.silvharm.commulade.webapp.action;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.pojo.ConfigContainer;
import fr.silvharm.commulade.model.pojo.Topo;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class ViewTopoAction extends SessionHelper {
	
	private Boolean isOwned, isUpToDate;
	private ConfigContainer configContainer;
	private int topoId;
	private Topo topo;
	private TopoInteractions topoInteractions;
	private TopoOwnedInteractions topoOwnedInteractions;
	private UserInteractions userInteractions;
	private String contentJsp = "view-topo", css = "view-site-topo", js = "view-site-topo", title = "Topo: ";
	
	@SuppressWarnings("unused") // are used by struts in the jsp
	private String secteurPhotoPath, sitePhotoPath;
	
	
	public String execute() {
		topo = topoInteractions.getTopo(topoId);
		
		if (topo != null) {
			title += topo.getName();
			
			isUpToDate = topoInteractions.isUpToDate(topo);
			
			setUserId();
			if (userInteractions.verifyUser(userId, getUsername())) {
				isOwned = topoOwnedInteractions.isTopoOwned(topoId, userId);
			}
		}
		else {
			title = "Topo not Found";
		}
		
		return SUCCESS;
	}
	
	
	public String iDontOwnIt() {
		setUserId();
		
		if (userInteractions.verifyUser(userId, getUsername())) {
			topoOwnedInteractions.stopSharing(topoId, userId);
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
	public String iOwnIt() {
		setUserId();
		
		if (userInteractions.verifyUser(userId, getUsername())) {
			topoOwnedInteractions.startSharing(topoId, userId);
			
			return SUCCESS;
		}
		
		return ERROR;
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
	public Boolean getIsOwned() {
		return isOwned;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @param topoInteractions
	 *           the TopoInteractions to set
	 */
	public void setTopoInteractions(TopoInteractions topoInteractions) {
		this.topoInteractions = topoInteractions;
	}
	
	
	/**
	 * @param topoOwnedInteractions
	 *           the TopoOwnedInteractions to set
	 */
	public void setTopoOwnedInteractions(TopoOwnedInteractions topoOwnedInteractions) {
		this.topoOwnedInteractions = topoOwnedInteractions;
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
