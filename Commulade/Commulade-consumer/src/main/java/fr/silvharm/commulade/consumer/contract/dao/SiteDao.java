package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

import fr.silvharm.commulade.model.pojo.Site;

public interface SiteDao {
	
	final String TABLE_NAME = "site";
	
	final String ID = "id", NAME = "name", DATE = "date", PHOTO_NAME = "photo_name", PLACE = "place",
			PATH_INDICATION = "path_indication";
	
	
	/**
	 * Insert the provided Site in the database
	 * 
	 * @param site
	 */
	public void create(Site site);
	
	
	/**
	 * Delete from the database the Site associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Site whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Site associated to the id provided
	 */
	public Site findById(int id);
	
	
	/**
	 * Get all the Site in the database and return them in a List
	 * 
	 * @return a List containing all the Site of the database
	 */
	public List<Site> getAllSite();
	
	
	/**
	 * Update the properties of the Site from the database, whom the id is equal to
	 * the id of the Site provided, by the ones of the Site provided
	 * 
	 * @param site
	 */
	public void update(Site site);
	
}
