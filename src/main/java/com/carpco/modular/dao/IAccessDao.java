/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Access DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 */
public interface IAccessDao extends IDao {
  
  /**
   * Select all access linked to informed role
   * 
   * @param idRole Role identifier
   * @return Access set if role identifier is linked to some access, null otherwise
   */
  public Set<DefaultTableModel> selectByRole(int idRole);

}
