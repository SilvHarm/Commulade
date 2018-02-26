package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.VoieDao;
import fr.silvharm.commulade.model.pojo.Voie;


public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {
	
	public void create(Voie voie) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + SECTEUR_ID + ")"
				+ " VALUES ( :name, :secteurId );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", voie.getName());
		vParams.addValue("secteurId", voie.getSecteurId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Voie findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Voie>(Voie.class));
	}
	
	
	public void update(Voie voie) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + NAME + " = :name, " + SECTEUR_ID + " = :secteurId WHERE " + ID
				+ " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", voie.getName());
		vParams.addValue("secteurId", voie.getSecteurId());
		vParams.addValue("id", voie.getId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
