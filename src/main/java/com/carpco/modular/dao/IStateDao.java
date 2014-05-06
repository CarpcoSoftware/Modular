/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.carpco.modular.data.model.DefaultTableModel;


/**
 * State DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
@Component
public interface IStateDao extends IDao {

  /**
   * Select states set using the country identifier
   * 
   * @param idCountry Country identifier
   * @return States set if country identifier is correct, null otherwise
   */
  public Set<DefaultTableModel> selectByCountry(int idCountry);

}
