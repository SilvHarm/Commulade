package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

import fr.silvharm.commulade.model.pojo.LendingTopo;

public interface LendingTopoDao {
	
	final String TABLE_NAME = "lending_topo";
	
	final String ID = "id", TOPO_OWNED_ID = "topo_owned_id", BORROWER_ID = "borrower_id",
			LENDING_START = "lending_start", LENDING_END = "lending_end";
	
	
	/**
	 * Insert the provided LendingTopo in the database
	 * 
	 * @param lendingTopo
	 */
	public void create(LendingTopo lendingTopo);
	
	
	/**
	 * Delete from the database the LendingTopo associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the LendingTopo whom the id is equal to the one
	 * provided
	 * 
	 * @param id
	 * @return the LendingTopo associated to the id provided
	 */
	public LendingTopo findById(int id);
	
	
	/**
	 * Get from the database all the LendingTopo whom the topoOwnedId is equal to
	 * the one provided and have lending_end who is after today
	 * 
	 * @param id
	 * @return a List of LendingTopo associated to the topoOwnedId provided and who
	 *         end after today, or null
	 */
	public List<LendingTopo> findByIdAfterToday(int topoOwnedId);
	
	
	/**
	 * Update the properties of the LendingTopo from the database, whom the id is
	 * equal to the id of the LendingTopo provided, by the ones of the LendingTopo
	 * provided
	 * 
	 * @param lendingTopo
	 */
	public void update(LendingTopo lendingTopo);
	
}
