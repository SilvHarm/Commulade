package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.LendingTopoDao;
import fr.silvharm.commulade.model.pojo.LendingTopo;


public class LendingTopoDaoImpl extends AbstractDaoImpl implements LendingTopoDao {
	
	public void create(LendingTopo lendingTopo) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + TOPO_OWNED_ID + "," + BORROWER_ID + "," + LENDING_START + ","
				+ LENDING_END + ")" + " VALUES ( :topoOwnerId, :borrowerId, :lendingStart, :lendingEnd );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("topoOwnerId", lendingTopo.getTopoOwnedId());
		vParams.addValue("borrowerId", lendingTopo.getBorrowerId());
		vParams.addValue("lendingStart", lendingTopo.getLendingStart());
		vParams.addValue("lendingEnd", lendingTopo.getLendingEnd());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public LendingTopo findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return jdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<LendingTopo>(LendingTopo.class));
	}
	
	
	public void update(LendingTopo lendingTopo) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + TOPO_OWNED_ID + " = :topoOwnerId, " + BORROWER_ID
				+ " = :borrowerId, " + LENDING_START + " = :lendingStart, " + LENDING_END + " = :lendingEnd WHERE " + ID
				+ " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("topoOwnerId", lendingTopo.getTopoOwnedId());
		vParams.addValue("borrowerId", lendingTopo.getBorrowerId());
		vParams.addValue("lendingStart", lendingTopo.getLendingStart());
		vParams.addValue("lendingEnd", lendingTopo.getLendingEnd());
		vParams.addValue("id", lendingTopo.getId());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
}
