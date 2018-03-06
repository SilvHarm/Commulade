package fr.silvharm.commulade.consumer.impl.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.TopoDao;
import fr.silvharm.commulade.model.pojo.Topo;


public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {
	
	private static final Logger logger = LogManager.getLogger();
	
	
	public void create(Topo topo) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + EDITION_DATE + "," + DESCRIPTION + ")"
				+ " VALUES ( :name, :editionDate, :description );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", topo.getName());
		vParams.addValue("editionDate", topo.getEditionDate());
		vParams.addValue("description", topo.getDescription());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Topo findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		try {
			return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Topo>(Topo.class));
		}
		catch (DataAccessException e) {
			logger.info("The Topo researched doesn't exist in the database");
			
			return null;
		}
	}
	
	
	public List<Topo> getAllTopo() {
		String vSQL = "SELECT * FROM " + TABLE_NAME + ";";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<Topo>(Topo.class));
	}
	
	
	public List<Topo> getByName(String name) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + NAME + " LIKE '%" + name + "%';";
		
		return jdbcTemplate.query(vSQL, new BeanPropertyRowMapper<Topo>(Topo.class));
	}
	
	
	public void update(Topo topo) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + NAME + " = :name, " + EDITION_DATE + " = :editionDate, "
				+ DESCRIPTION + " = :description WHERE " + ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", topo.getName());
		vParams.addValue("editionDate", topo.getEditionDate());
		vParams.addValue("description", topo.getDescription());
		vParams.addValue("id", topo.getId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
