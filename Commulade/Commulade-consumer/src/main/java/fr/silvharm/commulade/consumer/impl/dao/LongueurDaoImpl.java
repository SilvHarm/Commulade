package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.LongueurDao;
import fr.silvharm.commulade.model.pojo.Longueur;


public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao {
	
	public void create(Longueur longueur) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + VOIE_ID + "," + PREVIOUS_LONGUEUR_ID + "," + HEIGHT + ","
				+ NOMBRE_POINTS + "," + COTATION + ")"
				+ " VALUES ( :voieId, :previousLongueurId, :height, :nombrePoints, :cotation );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("voieId", longueur.getVoieId());
		vParams.addValue("previousLongueurId", longueur.getPreviousLongueurId());
		vParams.addValue("height", longueur.getHeight());
		vParams.addValue("nombrePoints", longueur.getNombrePoints());
		vParams.addValue("cotation", longueur.getCotation());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Longueur findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return jdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Longueur>(Longueur.class));
	}
	
	
	public void update(Longueur longueur) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + VOIE_ID + " = :voieId, " + PREVIOUS_LONGUEUR_ID
				+ " = :previousLongueurId, " + HEIGHT + " = :height, " + NOMBRE_POINTS + " = :nombrePoints, " + COTATION
				+ " = :cotation WHERE " + ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("voieId", longueur.getVoieId());
		vParams.addValue("previousLongueurId", longueur.getPreviousLongueurId());
		vParams.addValue("height", longueur.getHeight());
		vParams.addValue("nombrePoints", longueur.getNombrePoints());
		vParams.addValue("cotation", longueur.getCotation());
		vParams.addValue("id", longueur.getId());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
}
