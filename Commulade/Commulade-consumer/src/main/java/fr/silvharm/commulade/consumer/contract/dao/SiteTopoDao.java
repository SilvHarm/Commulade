package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

public interface SiteTopoDao {
	
	final String TABLE_NAME = "site_topo";
	
	final String SITE_ID = "site_id", TOPO_ID = "topo_id";
	
	
	/**
	 * Add the couple {topoId, siteIdList[i]} to the database for each id of
	 * siteIdList
	 * 
	 * @param topoId
	 * @param siteIdList
	 */
	void createList(int topoId, List<Integer> siteIdList);
	
}
