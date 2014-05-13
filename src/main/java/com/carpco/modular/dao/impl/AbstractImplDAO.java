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
   * Data source name from spring, it must be used to connect to correct database
   */
  private static String dataSourceName;
  
  /**
   * Data source used to get data from main database
   */
  protected static final String MAIN_DATA_SOURCE = "main";

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

  /**
   * @return the dataSourceName
   */
  public static String getDataSourceName() {
    return dataSourceName;
  }

  /**
   * @param dsName the dataSourceName to set
   */
  public static void setDataSourceName(final String dsName) {
    dataSourceName = dsName;
  }
}
