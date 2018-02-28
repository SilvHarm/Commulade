package fr.silvharm.commulade.consumer.impl.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.SiteDao;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Site;


public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
	public void create(Site site) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + DATE + "," + PHOTO_NAME + "," + PLACE + ","
				+ PATH_INDICATION + ")" + " VALUES ( :name, :date, :photoName, :place, :pathIndication );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", site.getName());
		vParams.addValue("date", site.getDate());
		vParams.addValue("photoName", site.getPhotoName());
		vParams.addValue("place", site.getPlace());
		vParams.addValue("pathIndication", site.getPathIndication());
		
		namedJdbcTemplate.update(vSQL, vParams);
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
	
	
	public List<Site> findBySearch(SiteSearchFormBean formBean) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE ";
		String tempo = "";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		// we fill the request with the properties that aren't null
		
		if (!formBean.getSiteName().isEmpty()) {
			vSQL += NAME + " LIKE '%" + formBean.getSiteName() + "%' AND ";
		}
		
		if (!formBean.getMinHeight().isEmpty()) {
			tempo += LongueurDaoImpl.HEIGHT + " > :minHeight AND ";
			
			vParams.addValue("minHeight", Integer.parseInt(formBean.getMinHeight()));
		}
		
		if (!formBean.getMaxHeight().isEmpty()) {
			tempo += LongueurDaoImpl.HEIGHT + " < :maxHeight AND ";
			
			vParams.addValue("maxHeight", Integer.parseInt(formBean.getMaxHeight()));
		}
		
		if (!formBean.getMinPointNumber().isEmpty()) {
			tempo += LongueurDaoImpl.NOMBRE_POINTS + " > :minPointNumber AND ";
			
			vParams.addValue("minPointNumber", Integer.parseInt(formBean.getMinPointNumber()));
		}
		
		if (!formBean.getMaxPointNumber().isEmpty()) {
			tempo += LongueurDaoImpl.NOMBRE_POINTS + " < :maxPointNumber AND ";
			
			vParams.addValue("maxPointNumber", Integer.parseInt(formBean.getMaxPointNumber()));
		}
		
		if (!formBean.getCotation().isEmpty()) {
			tempo += LongueurDaoImpl.COTATION + " LIKE '" + formBean.getCotation() + "%' ";
		}
		
		
		// add tempo to vSql or delete unnecessary "AND " at the end of vSQL
		if (!tempo.isEmpty()) {
			tempo = tempo.replaceAll(" AND $", "");
			
			vSQL += ID + " = ANY ( SELECT " + SecteurDaoImpl.SITE_ID + " FROM " + SecteurDaoImpl.TABLE_NAME + " WHERE "
					+ SecteurDaoImpl.ID + " = ANY ( SELECT " + VoieDaoImpl.SECTEUR_ID + " FROM " + VoieDaoImpl.TABLE_NAME
					+ " WHERE " + VoieDaoImpl.ID + " = ANY ( SELECT " + LongueurDaoImpl.VOIE_ID + " FROM "
					+ LongueurDaoImpl.TABLE_NAME + " WHERE " + tempo + " GROUP BY " + LongueurDaoImpl.VOIE_ID
					+ " ) GROUP BY " + VoieDaoImpl.SECTEUR_ID + " ) GROUP BY " + SecteurDaoImpl.SITE_ID + " )";
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
