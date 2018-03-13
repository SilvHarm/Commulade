package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;

public interface TopoOwnedByUserDao {
	
	final String TABLE_NAME = "topo_ownedby_user";
	
	final String ID = "id", OWNER_ID = "owner_id", TOPO_ID = "topo_id";
	
	
	/**
	 * Insert the provided Topo in the database
	 * 
	 * @param userId
	 * @param topoId
	 * @return the id of the TopoOwnedByUser that was inserted
	 */
	public int create(int userId, int topoId);
	
	
	/**
	 * Delete from the database the TopoOwnedByUser associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the TopoOwnedByUser whom the id is equal to the one
	 * provided
	 * 
	 * @param id
	 * @return the TopoOwnedByUser associated to the id provided or null if it
	 *         doesn't exist
	 */
	public TopoOwnedByUser findById(int id);
	
	
	/**
	 * Get from the database all the TopoOwnedByUser whom the topoId is equal to the
	 * one provided
	 * 
	 * @param topoId
	 * @return a List containing all the TopoOwnedByUser associated to the topoId
	 *         provided
	 */
	public List<TopoOwnedByUser> findByOwnerId(int topoId);
	
	
	/**
	 * Get from the database all the TopoOwnedByUser whom the ownerId is equal to
	 * the one provided
	 * 
	 * @param ownerId
	 * @return a List containing all the TopoOwnedByUser associated to the ownerId
	 *         provided
	 */
	public List<TopoOwnedByUser> findByTopoId(int ownerId);
	
	
	/**
	 * Get from the database the TopoOwnedByUser whom the ownerId and the topoId are
	 * equals to the ones provided
	 * 
	 * @param ownerId
	 * @param topoId
	 * @return the TopoOwnedByUser associated to the ownerId and topoId provided or
	 *         null if it doesn't exist
	 */
	public TopoOwnedByUser findByTopoOwnerId(int ownerId, int topoId);
	
	
	/**
	 * Get all the TopoOwnedByUser from the database
	 * 
	 * @return a List containing all the TopoOwnedByUser of the database
	 */
	public List<TopoOwnedByUser> getAll();
}
