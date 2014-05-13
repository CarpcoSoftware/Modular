/**
 * 
 */
package com.carpco.modular.dao.bo;

/**
 * This interface must be implemented for all tables that are not in administration database
 * @author Carlos Rodriguez
 */
public interface IModularTableBO {
  
  /**
   * Sets data source name that will be used to connect to database
   * @param datasourceName Data source name that must be used to get data
   */
  public void setDatasourceName(String datasourceName);

}
