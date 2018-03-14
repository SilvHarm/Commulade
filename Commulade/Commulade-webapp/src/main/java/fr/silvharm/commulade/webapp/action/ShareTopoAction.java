package fr.silvharm.commulade.webapp.action;

import java.time.LocalDate;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.model.bean.TopoFormBean;

public class ShareTopoAction extends ActionSupport implements SessionAware {
	
	private Boolean wishToShare;
	private Integer newTopoId;
	private LocalDate todayDate = LocalDate.now();
	private Map<String, Object> session;
	private String contentJsp = "share-topo", css = "share-site-topo", editionDate, js = "share-site-topo",
			title = "Partager un topo";
	private TopoFormBean topoForm;
	private TopoInteractions topoInteractions;
	private TopoOwnedInteractions topoOwnedInteractions;
	
	
	public String execute() {
		return SUCCESS;
	}
	
	
	public String getForm() {
		if (topoForm == null) {
			return ERROR;
		}
		
		topoForm.setEditionDate(editionDate);
		
		newTopoId = topoInteractions.shareTopo(topoForm);
		
		if (newTopoId == null) {
			return ERROR;
		}
		
		// if user is connected and wish to share Topo with others
		Integer userId = (Integer) session.get("userId");
		// wishToShare = null when it's not check and false when it is
		if (userId != null && wishToShare != null) {
			topoOwnedInteractions.startSharing(newTopoId, userId);
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
	 * @return the editionDate
	 */
	public String getEditionDate() {
		return editionDate;
	}
	
	
	/**
	 * @param editionDate
	 *           the editionDate to set
	 */
	public void setEditionDate(String editionDate) {
		this.editionDate = editionDate;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @return the newTopoId
	 */
	public Integer getNewTopoId() {
		return newTopoId;
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @return the todayDate
	 */
	public LocalDate getTodayDate() {
		return todayDate;
	}
	
	
	/**
	 * @param topoInteractions
	 *           the topoInteractions to set
	 */
	public void setTopoInteractions(TopoInteractions topoInteractions) {
		this.topoInteractions = topoInteractions;
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
	
	
	/**
	 * @param topoOwnedInteractions
	 *           the topoOwnedInteractions to set
	 */
	public void setTopoOwnedInteractions(TopoOwnedInteractions topoOwnedInteractions) {
		this.topoOwnedInteractions = topoOwnedInteractions;
	}
	
	
	/**
	 * @return the wishToShare
	 */
	public Boolean isWishToShare() {
		return wishToShare;
	}
	
	
	/**
	 * @param wishToShare
	 *           the wishToShare to set
	 */
	public void setWishToShare(Boolean wishToShare) {
		this.wishToShare = wishToShare;
	}
	
}
