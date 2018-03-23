package fr.silvharm.commulade.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class LendTopoAction extends SessionHelper {
	
	private List<Integer> topoIdList, userIdList;
	private List<TopoOwnedByUser> borrowedList, notOwnedList, userOwnedList;
	private Map<Integer, String> topoMap, userMap;
	private String contentJsp = "lend-topo", css = "lend-topo", js = null, title = "Espace de partage";
	private TopoInteractions topoInteractions;
	private TopoOwnedInteractions topoOwnedInteractions;
	
	
	public String execute() {
		setUserId();
		
		topoIdList = new ArrayList<Integer>();
		userIdList = new ArrayList<Integer>();
		
		if (userInteractions.verifyUser(userId, getUsername())) {
			notOwnedList = topoOwnedInteractions.getAllExceptUserTopoOwned(userId);
			
			userOwnedList = topoOwnedInteractions.getUserTopoOwned(userId);
			if (userOwnedList != null) {
				for (TopoOwnedByUser topoOwned : userOwnedList) {
					if (!topoIdList.contains(topoOwned.getTopoId())) {
						topoIdList.add(topoOwned.getTopoId());
					}
				}
				
				topoMap = topoInteractions.getTopoNameMapByIdList(topoIdList);
				
				for (TopoOwnedByUser topoOwned : userOwnedList) {
					topoOwned.setTopoName(topoMap.get(topoOwned.getTopoId()));
					topoOwned.setUsername("#Vous#");
				}
			}
			
			// TODO borrowedList
		}
		else {
			notOwnedList = topoOwnedInteractions.getAllTopoOwned();
		}
		
		
		if (notOwnedList != null) {
			topoIdList.clear();
			userIdList.clear();
			
			for (TopoOwnedByUser topoOwned : notOwnedList) {
				if (!topoIdList.contains(topoOwned.getTopoId())) {
					topoIdList.add(topoOwned.getTopoId());
				}
				
				if (!userIdList.contains(topoOwned.getOwnerId())) {
					userIdList.add(topoOwned.getOwnerId());
				}
			}
			
			topoMap = topoInteractions.getTopoNameMapByIdList(topoIdList);
			userMap = userInteractions.getUsernameMapByIdList(userIdList);
			
			for (TopoOwnedByUser topoOwned : notOwnedList) {
				topoOwned.setTopoName(topoMap.get(topoOwned.getTopoId()));
				topoOwned.setUsername(userMap.get(topoOwned.getOwnerId()));
			}
			
			if (borrowedList != null) {
				for (TopoOwnedByUser topoOwned : borrowedList) {
					topoOwned.setTopoName(topoMap.get(topoOwned.getTopoId()));
					topoOwned.setUsername(userMap.get(topoOwned.getOwnerId()));
				}
			}
		}
		
		return SUCCESS;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	
	/**
	 * @return the borrowedList
	 */
	public List<TopoOwnedByUser> getBorrowedList() {
		return borrowedList;
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
	 * @return the notOwnedList
	 */
	public List<TopoOwnedByUser> getNotOwnedList() {
		return notOwnedList;
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
	 * @param topoOwnedInteractions
	 *           the topoOwnedInteractions to set
	 */
	public void setTopoOwnedInteractions(TopoOwnedInteractions topoOwnedInteractions) {
		this.topoOwnedInteractions = topoOwnedInteractions;
	}
	
	
	/**
	 * @return the userOwnedList
	 */
	public List<TopoOwnedByUser> getUserOwnedList() {
		return userOwnedList;
	}
	
}
