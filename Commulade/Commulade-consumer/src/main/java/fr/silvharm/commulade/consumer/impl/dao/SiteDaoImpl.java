package fr.silvharm.commulade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.LongueurDao;
import fr.silvharm.commulade.consumer.contract.dao.SecteurDao;
import fr.silvharm.commulade.consumer.contract.dao.SiteDao;
import fr.silvharm.commulade.consumer.contract.dao.SiteTopoDao;
import fr.silvharm.commulade.consumer.contract.dao.VoieDao;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Site;


public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
	public int create(Site site) {
		List<Site> list = new ArrayList<Site>();
		list.add(site);
		
		return createList(list).get(0);
	}
	
	
	public List<Integer> createList(List<Site> siteList) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + DATE + "," + PHOTO_NAME + "," + PLACE + ","
				+ PATH_INDICATION + ") VALUES ";
		
		for (Site site : siteList) {
			vSQL += "('" + site.getName() + "','" + site.getDate() + "',";
			
			if (site.getPhotoName() != null) {
				vSQL += "'" + site.getPhotoName() + "'";
			}
			else {
				vSQL += "null";
			}
			
			vSQL += ",'" + site.getPlace() + "','" + site.getPathIndication() + "'),";
		}
		
		vSQL = vSQL.replaceAll(",$", " RETURNING id;");
		
		
		Iterable<Map<String, Object>> iter = jdbcTemplate.queryForList(vSQL);
		
		List<Integer> list = new ArrayList<Integer>();
		for (Map<String, Object> map : iter) {
			list.add((Integer) map.get("id"));
		}
		
		return list;
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Site findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Site>(Site.class));
	}
	
	
	public List<Site> findByListId(List<Integer> list) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = " + list.get(0);
		
		list.remove(0);
		
		for (Integer i : list) {
			vSQL += " OR " + ID + " = " + i;
		}
		
		vSQL += ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<Site>(Site.class));
	}
	
	
	public List<Site> findBySearch(SiteSearchFormBean formBean) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE ";
		String tempo = "";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		// we fill the request with the properties that aren't empty
		
		if (!formBean.getSiteName().isEmpty()) {
			vSQL += NAME + " LIKE '%" + formBean.getSiteName() + "%' AND ";
		}
		
		if (!formBean.getMinHeight().isEmpty()) {
			tempo += LongueurDao.HEIGHT + " > :minHeight AND ";
			
			vParams.addValue("minHeight", Integer.parseInt(formBean.getMinHeight()));
		}
		
		if (!formBean.getMaxHeight().isEmpty()) {
			tempo += LongueurDao.HEIGHT + " < :maxHeight AND ";
			
			vParams.addValue("maxHeight", Integer.parseInt(formBean.getMaxHeight()));
		}
		
		if (!formBean.getMinPointNumber().isEmpty()) {
			tempo += LongueurDao.NOMBRE_POINTS + " > :minPointNumber AND ";
			
			vParams.addValue("minPointNumber", Integer.parseInt(formBean.getMinPointNumber()));
		}
		
		if (!formBean.getMaxPointNumber().isEmpty()) {
			tempo += LongueurDao.NOMBRE_POINTS + " < :maxPointNumber AND ";
			
			vParams.addValue("maxPointNumber", Integer.parseInt(formBean.getMaxPointNumber()));
		}
		
		if (!formBean.getCotation().isEmpty()) {
			tempo += LongueurDao.COTATION + " LIKE '" + formBean.getCotation() + "%' ";
		}
		
		
		// add tempo to vSql or delete unnecessary "AND " at the end of vSQL
		if (!tempo.isEmpty()) {
			tempo = tempo.replaceAll(" AND $", "");
			
			vSQL += ID + " = ANY ( SELECT " + SecteurDao.SITE_ID + " FROM " + SecteurDao.TABLE_NAME + " WHERE "
					+ SecteurDao.ID + " = ANY ( SELECT " + VoieDao.SECTEUR_ID + " FROM " + VoieDao.TABLE_NAME + " WHERE "
					+ VoieDao.ID + " = ANY ( SELECT " + LongueurDao.VOIE_ID + " FROM " + LongueurDao.TABLE_NAME + " WHERE "
					+ tempo + " GROUP BY " + LongueurDao.VOIE_ID + " ) GROUP BY " + VoieDao.SECTEUR_ID + " ) GROUP BY "
					+ SecteurDao.SITE_ID + " )";
		}
		else {
			vSQL = vSQL.replaceAll("AND $", "");
		}
		
		vSQL += ";";
		
		
		return namedJdbcTemplate.query(vSQL, vParams, new BeanPropertyRowMapper<Site>(Site.class));
	}
	
	
	public List<Site> getAllSite() {
		String vSQL = "SELECT * FROM " + TABLE_NAME + ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<Site>(Site.class));
	}
	
	
	public List<Site> getSiteListByTopoId(int topoId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = ANY (SELECT (" + SiteTopoDao.SITE_ID
				+ ") FROM " + SiteTopoDao.TABLE_NAME + " WHERE " + SiteTopoDao.TOPO_ID + " = :topoId);";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("topoId", topoId);
		
		return namedJdbcTemplate.query(vSQL, vParams, new BeanPropertyRowMapper<Site>(Site.class));
	}
	
	
	public void update(Site site) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + NAME + " = :name, " + DATE + " = :date, " + PHOTO_NAME
				+ " = :photoName, " + PLACE + " = :place, " + PATH_INDICATION + " = :pathIndication WHERE " + ID
				+ " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", site.getName());
		vParams.addValue("date", site.getDate());
		vParams.addValue("photoName", site.getPhotoName());
		vParams.addValue("place", site.getPlace());
		vParams.addValue("pathIndication", site.getPathIndication());
		vParams.addValue("id", site.getId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
