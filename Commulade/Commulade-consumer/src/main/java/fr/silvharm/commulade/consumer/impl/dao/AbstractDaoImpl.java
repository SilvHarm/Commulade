package fr.silvharm.commulade.consumer.impl.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDaoImpl {
	
	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedJdbcTemplate;
	
	
	/**
	 * Create the JdbcTemplate that will be used to make query to the database
	 * 
	 * @param dataSource
	 *           the dataSource used to create the JdbcTemplate
	 */
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/**
	 * Create the NamedParameterJdbcTemplate that will be used to make query to the
	 * database
	 * 
	 * @param dataSource
	 *           the dataSource used to create the NamedParameterJdbcTemplate
	 */
	public void setNamedJdbcTemplate(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
}
