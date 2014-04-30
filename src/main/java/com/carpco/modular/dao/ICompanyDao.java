/**
 * 
 */
package com.carpco.modular.dao;

import com.carpco.modular.data.model.DefaultTableModel;


/**
 * Company DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
public interface ICompanyDao extends IDao {

  /**
   * Select a company using the company name
   * 
   * @param name Company name
   * @return Company if name is correct, null otherwise
   */
  public DefaultTableModel selectByName(String name);

}
