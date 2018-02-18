package fr.silvharm.commulade.consumer.impl.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDaoImpl {
	
	private DataSource dataSource;
	
	
	/**
	 * @param dataSource
	 *           the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	/**
	 * Get a JdbcTemplate to make query to the database
	 * 
	 * @return a new JdbcTemplate
	 */
	protected JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	
	/**
	 * Get a NamedParameterJdbcTemplate to make query to the database
	 * 
	 * @return a new NamedParameterJdbcTemplate
	 */
	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
}
