package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;

public interface TopoOwnedInteractions {
	
	/**
	 * Verify if the TopoOwnedByUser associated to the topoOwnedId provided do exist
	 * in the database and return it if it does
	 * 
	 * @param topoOwnedId
	 * @return the TopoOwnedByUser associated to topoOwnedId or null
	 */
	TopoOwnedByUser doesTopoOwnedExist(int topoOwnedId);
	
	
	/**
	 * Get all the TopoOwnedByUser of the database except the ones associated to
	 * userId
	 * 
	 * @param userId
	 * @return a List containing all the TopoOwnedByUser who aren't associated to
	 *         userId
	 */
	List<TopoOwnedByUser> getAllExceptUserTopoOwned(int userId);
	
	
	/**
	 * Get all the TopoOwnedByUser of the database
	 * 
	 * @return a List containing all the TopoOwnedByUser of the database
	 */
	List<TopoOwnedByUser> getAllTopoOwned();
	
	
	/**
	 * Get all the TopoOwnedByUser borrowed by the User associated to the userId
	 * provided
	 * 
	 * @param userId
	 * @return a List containing all the TopoOwnedByUser whom the User associated to
	 *         userId have asked to borrow in the future
	 */
	List<TopoOwnedByUser> getBorrowedTopoOwned(int userId);
	
	
	/**
	 * Get all the TopoOwnedByUser of an User
	 * 
	 * @param userId
	 * @return a List containing all the TopoOwnedByUser associated to userId
	 */
	List<TopoOwnedByUser> getUserTopoOwned(int userId);
	
	
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
