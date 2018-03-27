package fr.silvharm.commulade.business.contract;

import java.time.LocalDate;
import java.util.List;

import fr.silvharm.commulade.model.pojo.LendingTopo;

public interface LendTopoInteractions {
	
	/**
	 * Verify if the lendingTopoToAdd can be added safely and, if it's the case, add
	 * it to the database
	 * 
	 * @param lendingTopoToAdd
	 * @return true if everything worked or false
	 */
	Boolean borrowTopoOwned(LendingTopo lendingTopoToAdd);
	
	
	/**
	 * Make a List of the Date who are free for the User to borrow the Topo
	 * 
	 * @param topoOwnedId
	 * @return a List of LocalDate[] representing the Date who are free for
	 *         borrowing
	 */
	List<LocalDate[]> getFreeDateOfTopoOwned(int topoOwnedId);
	
	
	/**
	 * Get all LendingTopo of one TopoOwnedByUser whom the lending_end if after now
	 * and who are associated to the topoOwnedId provided
	 * 
	 * @param topoOwnedId
	 * @return a List of LendingTopo whom lendingEnd property is after now and who
	 *         are associated to topoOwnedId
	 */
	List<LendingTopo> getLendDateOfTopoOwned(int topoOwnedId);
	
	
	/**
	 * Get all LendingTopo of one TopoOwnedByUser whom the lending_end if after a
	 * month ago and who are associated to the topoOwnedId provided
	 * 
	 * @param topoOwnedId
	 * @return a List of LendingTopo whom lendingEnd property is after a month ago
	 *         and who are associated to topoOwnedId
	 */
	List<LendingTopo> getMoreLendDateOfTopoOwned(int topoOwnedId);
	
}
