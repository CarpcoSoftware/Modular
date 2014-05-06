/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.carpco.modular.data.model.DefaultTableModel;


/**
 * City DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
@Component
public interface ICityDao extends IDao {

  /**
   * Select cities set using the state identifier
   * 
   * @param idState State identifier
   * @return Cities set if state identifier is correct, null otherwise
   */
  public Set<DefaultTableModel> selectByState(int idState);

}
