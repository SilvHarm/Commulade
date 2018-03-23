package fr.silvharm.commulade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.TopoDao;
import fr.silvharm.commulade.model.pojo.Topo;


public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {
	
	private static final Logger logger = LogManager.getLogger();
	
	
	public int create(Topo topo) {
		List<Topo> list = new ArrayList<Topo>();
		list.add(topo);
		
		return createList(list).get(0);
	}
	
	
	public List<Integer> createList(List<Topo> topoList) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + NAME + "," + EDITION_DATE + "," + DESCRIPTION + ") VALUES ";
		
		for (Topo topo : topoList) {
			vSQL += "('" + topo.getName() + "','" + topo.getEditionDate() + "',";
			
			if (topo.getDescription() != null) {
				vSQL += "'" + topo.getDescription() + "'";
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
	
	
	public List<Topo> getByIdList(List<Integer> topoIdList) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = " + topoIdList.get(0);
		
		topoIdList.remove(0);
		
		for (Integer i : topoIdList) {
			vSQL += " OR " + ID + " = " + i;
		}
		
		vSQL += ";";
		
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
