/**
 * 
 */
package com.carpco.modular.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Abstract DAO implementation <br/>
 * All DAO implementations must extend this class *
 * 
 * @author Carlos Rodriguez
 */
public abstract class AbstractImplDAO {

  /**
   * Data source to allow access to database
   */
  protected DataSource dataSource;

  /**
   * {@link JdbcTemplate} object used to execute statements
   */
  protected JdbcTemplate jdbcTemplateObject;

  /**
   * Sets a new data source
   * 
   * @param dataSource Data source to be set
   */
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }
}
