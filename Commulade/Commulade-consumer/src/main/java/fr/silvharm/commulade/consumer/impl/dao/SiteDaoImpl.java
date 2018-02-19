package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.SiteDao;
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
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Site findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return jdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Site>(Site.class));
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
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
}
