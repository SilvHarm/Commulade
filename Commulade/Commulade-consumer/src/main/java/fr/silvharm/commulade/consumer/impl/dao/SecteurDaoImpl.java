package fr.silvharm.commulade.consumer.impl.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.SecteurDao;
import fr.silvharm.commulade.model.pojo.Secteur;


public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {
	
	public void create(Secteur secteur) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + SITE_ID + "," + PHOTO_NAME + ")"
				+ " VALUES ( :name, :siteId, :photoName );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", secteur.getName());
		vParams.addValue("siteId", secteur.getSiteId());
		vParams.addValue("photoName", secteur.getPhotoName());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Secteur findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Secteur>(Secteur.class));
	}
	
	
	public List<Secteur> findByListSiteId(List<Integer> list) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + SITE_ID + " = " + list.get(0);
		
		list.remove(0);
		
		for (Integer i : list) {
			vSQL += " OR " + SITE_ID + " = " + i;
		}
		
		vSQL += ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<Secteur>(Secteur.class));
	}
	
	
	public void update(Secteur secteur) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + NAME + " = :name, " + SITE_ID + " = :siteId, " + PHOTO_NAME
				+ " = :photoName WHERE " + ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", secteur.getName());
		vParams.addValue("siteId", secteur.getSiteId());
		vParams.addValue("photoName", secteur.getPhotoName());
		vParams.addValue("id", secteur.getId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
