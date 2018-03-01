package fr.silvharm.commulade.consumer.impl.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.TopoDao;
import fr.silvharm.commulade.model.pojo.Topo;


public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {
	
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
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Topo>(Topo.class));
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
