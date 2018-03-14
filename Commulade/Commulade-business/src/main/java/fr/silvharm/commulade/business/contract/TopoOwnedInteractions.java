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
	
	
	/**
	 * Call the consumer module to add the couple {userId, topoId} to the shared
	 * Topo in the database
	 * 
	 * @param topoId
	 * @param userId
	 */
	void startSharing(int topoId, int userId);
	
	
	/**
	 * Call the consumer module to remove the couple {userId, topoId} from the
	 * shared Topo in the database
	 * 
	 * @param topoId
	 * @param userId
	 */
	void stopSharing(int topoId, int userId);
}
