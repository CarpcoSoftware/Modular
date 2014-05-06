/**
 * 
 */
package com.carpco.modular.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Abstract DAO implementation <br/>
 * All DAO implementations must extend this class *
 * 
 * @author Carlos Rodriguez
 */
public abstract class AbstractImplDAO {

  /**
   * {@link JdbcTemplate} object used to execute statements
   */
  protected JdbcTemplate jdbcTemplateObject;

  /**
   * Sets a new data source
   * 
   * @param dataSource Data source to be set
   */
  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }
}
