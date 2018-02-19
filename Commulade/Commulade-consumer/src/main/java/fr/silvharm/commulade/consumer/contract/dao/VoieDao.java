package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Voie;

public interface VoieDao {
	
	final String TABLE_NAME = "voie";
	
	final String ID = "id", NAME = "name", SECTEUR_ID = "secteur_id";
	
	
	/**
	 * Insert the provided Voie in the database
	 * 
	 * @param voie
	 */
	public void create(Voie voie);
	
	
	/**
	 * Delete from the database the Voie associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Voie whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Voie associated to the id provided
	 */
	public Voie findById(int id);
	
	
	/**
	 * Update the properties of the Voie from the database, whom the id is equal to
	 * the id of the Voie provided, by the ones of the Voie provided
	 * 
	 * @param voie
	 */
	public void update(Voie voie);
	
}
