package fr.silvharm.commulade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.SecteurDao;
import fr.silvharm.commulade.model.pojo.Secteur;


public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {
	
	public int create(Secteur secteur) {
		List<Secteur> list = new ArrayList<Secteur>();
		list.add(secteur);
		
		return createList(list).get(0);
	}
	
	
	public List<Integer> createList(List<Secteur> secteurList) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + SITE_ID + "," + PHOTO_NAME + ") VALUES ";
		
		for (Secteur secteur : secteurList) {
			vSQL += "('" + secteur.getName() + "'," + secteur.getSiteId() + ",";
			
			if (secteur.getPhotoName() != null) {
				vSQL += "'" + secteur.getPhotoName() + "'";
			}
			else {
				vSQL += "null";
			}
			
			vSQL += "),";
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
