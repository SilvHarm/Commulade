package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

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
	 * @return the Topo associated to the id provided or null if it doesn't exist
	 */
	public Topo findById(int id);
	
	
	/**
	 * Get all the Topo in the database and return them in a List
	 * 
	 * @return a List containing all the Topo of the database
	 */
	public List<Topo> getAllTopo();
	
	
	/**
	 * Get from the database all the Topo whom the name is like the one provided
	 * 
	 * @param topoName
	 * @return a list containing all the Topo whom the name are like topoName
	 */
	public List<Topo> getByName(String topoName);
	
	
	/**
	 * Update the properties of the Topo from the database, whom the id is equal to
	 * the id of the Topo provided, by the ones of the Topo provided
	 * 
	 * @param topo
	 */
	public void update(Topo topo);
	
}
