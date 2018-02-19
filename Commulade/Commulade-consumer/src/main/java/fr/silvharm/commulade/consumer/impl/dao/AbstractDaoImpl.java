package fr.silvharm.commulade.consumer.impl.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDaoImpl {
	
	protected NamedParameterJdbcTemplate jdbcTemplate;
	
	
	/**
	 * Create the NamedParameterJdbcTemplate that will be used to make query to the
	 * database
	 * 
	 * @param dataSource
	 *           the dataSource used to create jdbcTemplate
	 */
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
}
