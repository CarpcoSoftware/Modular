/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.IUserDao;
import com.carpco.modular.dao.impl.ImplUserDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplUserDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class UserBO implements IUserDao {
  
  @Autowired
  private ImplUserDAO userDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return userDAO.select();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return userDAO.selectAllActive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return userDAO.selectAllInactive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return userDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    userDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    userDAO.update(record);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IUserDao#selectByLoginPassword(java.lang.String, java.lang.String)
   */
  @Override
  public DefaultTableModel selectByLoginPassword(String login, String password) {
    return userDAO.selectByLoginPassword(login, password);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IUserDao#selectByCompany(int)
   */
  @Override
  public Set<DefaultTableModel> selectByCompany(int idCompany) {
    return userDAO.selectByCompany(idCompany);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IUserDao#selectByRole(int)
   */
  @Override
  public Set<DefaultTableModel> selectByRole(int idRole) {
    return userDAO.selectByRole(idRole);
  }

}
