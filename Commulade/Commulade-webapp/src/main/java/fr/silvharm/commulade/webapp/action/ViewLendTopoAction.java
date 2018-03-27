package fr.silvharm.commulade.webapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import fr.silvharm.commulade.business.contract.LendTopoInteractions;
import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.model.pojo.LendingTopo;
import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class ViewLendTopoAction extends SessionHelper {
	
	private static final Logger logger = LogManager.getLogger();
	
	private LendTopoInteractions lendTopoInteractions;
	private List<LendingTopo> lendingList;
	private List<LocalDate[]> freeLendingList;
	private LocalDate todayPlus = LocalDate.now().plusDays(1), todayPlusMonth = LocalDate.now().plusMonths(2);
	private int topoOwnedId;
	Map<Integer, String> usernameMap;
	private String contentJsp = "view-lend-topo", css = "view-lend-topo", endDate, js = "view-lend-topo", startDate,
			title = "Espace de partage";
	private TopoOwnedByUser topoOwned;
	private TopoOwnedInteractions topoOwnedInteractions;
	
	
	public String execute() {
		topoOwned = topoOwnedInteractions.doesTopoOwnedExist(topoOwnedId);
		
		if (topoOwned != null) {
			if (topoOwned.getOwnerId() == getUserId()) {
				lendingList = lendTopoInteractions.getMoreLendDateOfTopoOwned(topoOwnedId);
				
				List<Integer> userIdList = new ArrayList<Integer>();
				for (LendingTopo lendingTopo : lendingList) {
					if (!userIdList.contains(lendingTopo.getBorrowerId())) {
						userIdList.add(lendingTopo.getBorrowerId());
					}
				}
				
				if (userIdList.size() > 0) {
					usernameMap = userInteractions.getUsernameMapByIdList(userIdList);
				}
			}
			else {
				freeLendingList = lendTopoInteractions.getFreeDateOfTopoOwned(topoOwnedId);
			}
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
	public String borrowTopoOwned() {
		setUserId();
		
		if (userInteractions.verifyUser(userId, getUsername())) {
			HttpServletRequest request = ServletActionContext.getRequest();
			String url[] = request.getHeader("referer").split("/");
			
			try {
				topoOwnedId = Integer.parseInt(url[url.length - 1]);
				
				LendingTopo lendingTopo = new LendingTopo(topoOwnedId, userId, LocalDate.parse(startDate),
						LocalDate.parse(endDate));
				
				if (lendTopoInteractions.borrowTopoOwned(lendingTopo)) {
					return NONE;
				}
			}
			catch (NumberFormatException e) {
				logger.info("Requesting url wasn't as expected");
				
				return ERROR;
			}
			catch (DateTimeParseException e) {
				logger.info("At least one of the borrowing date wasn't in the correct format");
				
				return ERROR;
			}
		}
		
		return ERROR;
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
	 * @param endDate
	 *           the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @return the lendingList
	 */
	public List<LendingTopo> getLendingList() {
		return lendingList;
	}
	
	
	/**
	 * @param lendTopoInteractions
	 *           the lendTopoInteractions to set
	 */
	public void setLendTopoInteractions(LendTopoInteractions lendTopoInteractions) {
		this.lendTopoInteractions = lendTopoInteractions;
	}
	
	
	/**
	 * @param startDate
	 *           the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	/**
	 * @return the freeLendingList
	 */
	public List<LocalDate[]> getFreeLendingList() {
		return freeLendingList;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @return the todayPlus
	 */
	public LocalDate getTodayPlus() {
		return todayPlus;
	}
	
	
	/**
	 * @return the todayPlusMonth
	 */
	public LocalDate getTodayPlusMonth() {
		return todayPlusMonth;
	}
	
	
	/**
	 * @return the topoOwned
	 */
	public TopoOwnedByUser getTopoOwned() {
		return topoOwned;
	}
	
	
	/**
	 * @param the
	 *           topoOwnedId the topoOwnedId to set
	 */
	public void setTopoOwnedId(int topoOwnedId) {
		this.topoOwnedId = topoOwnedId;
	}
	
	
	/**
	 * @param topoOwnedInteractions
	 *           the topoOwnedInteractions to set
	 */
	public void setTopoOwnedInteractions(TopoOwnedInteractions topoOwnedInteractions) {
		this.topoOwnedInteractions = topoOwnedInteractions;
	}
	
	
	/**
	 * @return the usernameMap
	 */
	public Map<Integer, String> getUsernameMap() {
		return usernameMap;
	}
	
}
