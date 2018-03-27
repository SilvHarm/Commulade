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
	 * Delete the LendingTopo associated to lendingId
	 * 
	 * @param lendingId
	 * @return true if the LendingTopo was deleted or false
	 */
	Boolean cancelLending(int lendingId, int ownerId);
	
	
	/**
	 * Get all LendingTopo that the User associated with the borrowerId provided has
	 * borrowed for the TopoOwned associated to topoOwnedId
	 * 
	 * @param borrowerId
	 * @return a List of LendingTopo representing what the User borrowed
	 */
	List<LendingTopo> getBorrowedByUserTopoOwned(int topoOwnedId, int borrowerId);
	
	
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
	
	
	/**
	 * Verify in the database if it is possible to add lendingTopo or if the Dates
	 * are already taken
	 * 
	 * @param lendingTopo
	 * @return true if it isn't already lent or false
	 */
	Boolean isAlreadyLend(LendingTopo lendingTopo);
	
}
