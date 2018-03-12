package fr.silvharm.commulade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.UserDao;
import fr.silvharm.commulade.model.pojo.User;


public class UserDaoImpl extends AbstractDaoImpl implements UserDao {
	
	public Integer create(User user) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + USERNAME + "," + PASSWORD + ")"
				+ " VALUES ( :username, :password ) RETURNING id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("username", user.getUsername());
		vParams.addValue("password", user.getPassword());
		
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
	
	
	public User findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<User>(User.class));
	}
	
	
	public User findByName(String username) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + USERNAME + " = :username ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("username", username);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<User>(User.class));
	}
	
	
	public void update(User user) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + USERNAME + " = :username, " + PASSWORD + " = :password WHERE "
				+ ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("username", user.getUsername());
		vParams.addValue("password", user.getPassword());
		vParams.addValue("id", user.getId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
