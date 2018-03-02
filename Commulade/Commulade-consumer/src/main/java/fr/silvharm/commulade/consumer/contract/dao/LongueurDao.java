package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

import fr.silvharm.commulade.model.pojo.Longueur;

public interface LongueurDao {
	
	final String TABLE_NAME = "longueur";
	
	final String ID = "id", VOIE_ID = "voie_id", PREVIOUS_LONGUEUR_ID = "previous_longueur_id", HEIGHT = "height",
			NOMBRE_POINTS = "nombre_points", COTATION = "cotation";
	
	
	/**
	 * Insert the provided Longueur in the database
	 * 
	 * @param longueur
	 */
	public void create(Longueur longueur);
	
	
	/**
	 * Delete from the database the Longueur associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Longueur whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Longueur associated to the id provided
	 */
	public Longueur findById(int id);
	
	
	/**
	 * Get from the database all the Longueur whom the id are equals to the ones
	 * provided
	 * 
	 * @param list
	 * @return the List of Longueur associated to the ids provided
	 */
	public List<Longueur> findByListVoieId(List<Integer> list);
	
	
	/**
	 * Update the properties of the Longueur from the database, whom the id is equal
	 * to the id of the Longueur provided, by the ones of the Longueur provided
	 * 
	 * @param longueur
	 */
	public void update(Longueur longueur);
	
}
