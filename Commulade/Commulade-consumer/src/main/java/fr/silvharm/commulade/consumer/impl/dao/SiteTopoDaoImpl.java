package fr.silvharm.commulade.consumer.impl.dao;

import java.util.List;

import fr.silvharm.commulade.consumer.contract.dao.SiteTopoDao;


public class SiteTopoDaoImpl extends AbstractDaoImpl implements SiteTopoDao {
	
	public void createList(int topoId, List<Integer> siteIdList) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + TOPO_ID + "," + SITE_ID + ") VALUES ";
		
		for (Integer siteId : siteIdList) {
			if (siteId != null) {
				vSQL += "(" + topoId + "," + siteId + "),";
			}
		}
		
		vSQL = vSQL.replaceAll(",$", ";");
		
		jdbcTemplate.update(vSQL);
	}
}
