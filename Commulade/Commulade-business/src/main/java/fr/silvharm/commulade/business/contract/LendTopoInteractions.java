package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.pojo.LendingTopo;

public interface LendTopoInteractions {
	
	/**
	 * Get all LendingTopo of one TopoOwnedByUser whom the lending_end if after now
	 * and who are associated to the topoOwnedId provided
	 * 
	 * @param topoOwnedId
	 * @return a List of LendingTopo whom lendingEnd property is after now and who
	 *         are associated to topoOwnedId
	 */
	List<LendingTopo> getLendDateOfTopoOwned(int topoOwnedId);
	
}
