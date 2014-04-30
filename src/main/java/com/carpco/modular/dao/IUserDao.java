/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * User DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
public interface IUserDao extends IDao {

  /**
   * Select a user using login and password
   * 
   * @param login Login used by user
   * @param password Password used by user
   * @return User if login and password are correct, null otherwise
   */
  public DefaultTableModel selectByLoginPassword(String login, String password);

  /**
   * Select a user using the company identifier
   * 
   * @param idCompany Company identifier
   * @return User if company is correct, null otherwise
   */
  public Set<DefaultTableModel> selectByCompany(int idCompany);

  /**
   * Select a user using the role linked to it
   * 
   * @param idRole Role identifier
   * @return User if role is correct, null otherwise
   */
  public Set<DefaultTableModel> selectByRole(int idRole);

}
