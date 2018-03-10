package fr.silvharm.commulade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.LongueurDao;
import fr.silvharm.commulade.model.pojo.Longueur;


public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao {
	
	public int create(Longueur longueur) {
		List<Longueur> list = new ArrayList<Longueur>();
		list.add(longueur);
		
		return createList(list).get(0);
	}
	
	
	public List<Integer> createList(List<Longueur> longueurList) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + VOIE_ID + "," + PREVIOUS_LONGUEUR_ID + "," + HEIGHT + ","
				+ NOMBRE_POINTS + "," + COTATION + ") VALUES ";
		
		for (Longueur longueur : longueurList) {
			vSQL += "(" + longueur.getVoieId() + "," + longueur.getPreviousLongueurId() + "," + longueur.getHeight() + ","
					+ longueur.getNombrePoints() + ",'" + longueur.getCotation() + "'),";
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
	
	
	public Longueur findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Longueur>(Longueur.class));
	}
	
	
	public List<Longueur> findByListVoieId(List<Integer> list) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + VOIE_ID + " = " + list.get(0);
		
		list.remove(0);
		
		for (Integer i : list) {
			vSQL += " OR " + VOIE_ID + " = " + i;
		}
		
		vSQL += ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<Longueur>(Longueur.class));
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
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
