package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Topo;

public interface TopoDao {
	
	final String TABLE_NAME = "topo";
	
	final String ID = "id", NAME = "name", EDITION_DATE = "edition_date", DESCRIPTION = "description";
	
	
	/**
	 * Insert the provided Topo in the database
	 * 
	 * @param topo
	 */
	public void create(Topo topo);
	
	
	/**
	 * Delete from the database the Topo associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Topo whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Topo associated to the id provided
	 */
	public Topo findById(int id);
	
	
	/**
	 * Update the properties of the Topo from the database, whom the id is equal to
	 * the id of the Topo provided, by the ones of the Topo provided
	 * 
	 * @param topo
	 */
	public void update(Topo topo);
	
}
