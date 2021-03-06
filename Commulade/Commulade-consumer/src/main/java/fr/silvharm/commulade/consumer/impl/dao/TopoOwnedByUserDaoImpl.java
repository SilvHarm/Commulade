package fr.silvharm.commulade.consumer.impl.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.LendingTopoDao;
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
	
	
	public void deleteByUserTopoId(int ownerId, int topoId) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + OWNER_ID + " = :ownerId AND " + TOPO_ID + " = :topoId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("ownerId", ownerId);
		vParams.addValue("topoId", topoId);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public List<TopoOwnedByUser> findByBorrowerIdAfterToday(int borrowerId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = ANY ( SELECT " + LendingTopoDao.TOPO_OWNED_ID
				+ " FROM " + LendingTopoDao.TABLE_NAME + " WHERE " + LendingTopoDao.BORROWER_ID + " = :borrowerId AND "
				+ LendingTopoDao.LENDING_END + " > '" + LocalDate.now() + "' GROUP BY " + LendingTopoDao.TOPO_OWNED_ID
				+ " );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("borrowerId", borrowerId);
		
		return namedJdbcTemplate.query(vSQL, vParams, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public TopoOwnedByUser findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		try {
			return namedJdbcTemplate.queryForObject(vSQL, vParams,
					new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
		}
		catch (EmptyResultDataAccessException e) {
			// just mean there is no TopoOwnedByUser with the id provided
			
			return null;
		}
	}
	
	
	public List<TopoOwnedByUser> findByOwnerId(int ownerId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + OWNER_ID + " = :ownerId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("ownerId", ownerId);
		
		return namedJdbcTemplate.query(vSQL, vParams, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public List<TopoOwnedByUser> findByTopoId(int topoId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + TOPO_ID + " = :topoId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("topoId", topoId);
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public TopoOwnedByUser findByTopoOwnerId(int ownerId, int topoId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + OWNER_ID + " = :ownerId AND " + TOPO_ID
				+ " = :topoId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("ownerId", ownerId);
		vParams.addValue("topoId", topoId);
		try {
			return namedJdbcTemplate.queryForObject(vSQL, vParams,
					new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
		}
		catch (DataAccessException e) {
			// We do not care much about the Exception itself
			return null;
		}
	}
	
	
	public List<TopoOwnedByUser> getAll() {
		String vSQL = "SELECT * FROM " + TABLE_NAME + ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
	
	public List<TopoOwnedByUser> getAllExceptOwnerId(int ownerId) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + OWNER_ID + " != :ownerId ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("ownerId", ownerId);
		
		return namedJdbcTemplate.query(vSQL, vParams, new BeanPropertyRowMapper<TopoOwnedByUser>(TopoOwnedByUser.class));
	}
	
}
