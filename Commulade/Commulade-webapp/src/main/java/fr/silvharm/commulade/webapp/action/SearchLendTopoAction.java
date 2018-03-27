package fr.silvharm.commulade.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class SearchLendTopoAction extends SessionHelper {
	
	private List<Integer> topoIdList, userIdList;
	private List<TopoOwnedByUser> borrowedList, notOwnedList, userOwnedList;
	private Map<Integer, String> topoMap, userMap;
	private String contentJsp = "search-lend-topo", css = "search-lend-topo", js = "search-lend-topo",
			title = "Espace de partage";
	private TopoInteractions topoInteractions;
	private TopoOwnedInteractions topoOwnedInteractions;
	
	
	public String execute() {
		setUserId();
		
		topoIdList = new ArrayList<Integer>();
		userIdList = new ArrayList<Integer>();
		
		if (userInteractions.verifyUser(userId, getUsername())) {
			notOwnedList = topoOwnedInteractions.getAllExceptUserTopoOwned(userId);
			
			userOwnedList = topoOwnedInteractions.getUserTopoOwned(userId);
			if (!userOwnedList.isEmpty()) {
				for (TopoOwnedByUser topoOwned : userOwnedList) {
					if (!topoIdList.contains(topoOwned.getTopoId())) {
						topoIdList.add(topoOwned.getTopoId());
					}
				}
			}
			
			borrowedList = topoOwnedInteractions.getBorrowedTopoOwned(userId);
			if (!borrowedList.isEmpty()) {
				for (TopoOwnedByUser topoOwned : borrowedList) {
					if (!topoIdList.contains(topoOwned.getTopoId())) {
						topoIdList.add(topoOwned.getTopoId());
					}
					
					if (!userIdList.contains(topoOwned.getOwnerId())) {
						userIdList.add(topoOwned.getOwnerId());
					}
				}
			}
		}
		else {
			notOwnedList = topoOwnedInteractions.getAllTopoOwned();
		}
		
		
		if (notOwnedList != null) {
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
			
			if (userOwnedList != null && !userOwnedList.isEmpty()) {
				for (TopoOwnedByUser topoOwned : userOwnedList) {
					topoOwned.setTopoName(topoMap.get(topoOwned.getTopoId()));
					topoOwned.setUsername("#Vous#");
				}
			}
			else {
				userOwnedList = null;
			}
			
			if (borrowedList != null && !borrowedList.isEmpty()) {
				for (TopoOwnedByUser topoOwned : borrowedList) {
					topoOwned.setTopoName(topoMap.get(topoOwned.getTopoId()));
					topoOwned.setUsername(userMap.get(topoOwned.getOwnerId()));
				}
			}
			else {
				borrowedList = null;
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
