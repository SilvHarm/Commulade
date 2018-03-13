package fr.silvharm.commulade.business.contract;


public interface TopoOwnedInteractions {
	
	/**
	 * Call the consumer module to know if the User own the Topo
	 * 
	 * @param topoId
	 * @param userId
	 * @return true if the User own the Topo or false
	 */
	Boolean isTopoOwned(int topoId, int userId);
}
