package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.UserDao;
import fr.silvharm.commulade.model.pojo.User;


public class UserDaoImpl extends AbstractDaoImpl implements UserDao {
	
	public void create(User user) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + USERNAME + "," + PASSWORD + ")"
				+ " VALUES ( :username, :password );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("username", user.getUsername());
		vParams.addValue("password", user.getPassword());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public User findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return jdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<User>(User.class));
	}
	
	
	public void update(User user) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + USERNAME + " = :username, " + PASSWORD + " = :password WHERE "
				+ ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("username", user.getUsername());
		vParams.addValue("password", user.getPassword());
		vParams.addValue("id", user.getId());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
}
