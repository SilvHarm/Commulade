package fr.silvharm.commulade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.TopoOwnedByUserDao;
import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;


public class TopoOwnedByUserDaoImpl extends AbstractDaoImpl implements TopoOwnedByUserDao {
	
	public int create(int userId, int topoId) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + OWNER_ID + "," + TOPO_ID + ")"
				+ " VALUES ( :userId, :topoId ) RETURNING id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("userId", userId);
		vParams.addValue("topoId", topoId);
		
		Iterable<Map<String, Object>> iter = namedJdbcTemplate.queryForList(vSQL, vParams);
		
		List<Integer> list = new ArrayList<Integer>();
		for (Map<String, Object> map : iter) {
			list.add((Integer) map.get("id"));
		}
		
		return list.get(0);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public TopoOwnedByUser findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams,
				new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public List<TopoOwnedByUser> findByOwnerId(int topoId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + TOPO_ID + " = :topoId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("topoId", topoId);
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public List<TopoOwnedByUser> findByTopoId(int ownerId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + OWNER_ID + " = :ownerId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("ownerId", ownerId);
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public List<TopoOwnedByUser> getAll() {
		String vSQL = "SELECT * FROM " + TABLE_NAME + ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
}
