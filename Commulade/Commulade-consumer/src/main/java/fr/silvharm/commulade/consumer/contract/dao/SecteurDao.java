package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Secteur;

public interface SecteurDao {
	
	final String TABLE_NAME = "secteur";
	
	final String ID = "id", NAME = "name", SITE_ID = "site_id", PHOTO_NAME = "photo_name";
	
	
	/**
	 * Insert the provided Secteur in the database
	 * 
	 * @param secteur
	 */
	public void create(Secteur secteur);
	
	
	/**
	 * Delete from the database the Secteur associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Secteur whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Secteur associated to the id provided
	 */
	public Secteur findById(int id);
	
	
	/**
	 * Update the properties of the Secteur from the database, whom the id is equal
	 * to the id of the Secteur provided, by the ones of the Secteur provided
	 * 
	 * @param secteur
	 */
	public void update(Secteur secteur);
	
}
