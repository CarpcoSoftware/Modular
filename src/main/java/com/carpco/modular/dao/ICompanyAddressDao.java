/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.carpco.modular.data.model.DefaultTableModel;


/**
 * Company address DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
@Component
public interface ICompanyAddressDao extends IDao {

  /**
   * Select address set using the company identifier
   * 
   * @param idCompany Company identifier
   * @return Address set if company is correct, null otherwise
   */
  public Set<DefaultTableModel> selectByCompany(int idCompany);
  
  /**
   * Select default address using the company identifier
   * 
   * @param idCompany Company identifier
   * @return Default address if company is correct, null otherwise
   */
  public DefaultTableModel selectDefaultAddressByCompany(int idCompany);

}
