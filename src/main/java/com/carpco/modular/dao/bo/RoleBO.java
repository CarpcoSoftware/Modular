/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.dao.impl.ImplRoleDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplRoleDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class RoleBO implements IDao {

  @Autowired
  private ImplRoleDAO roleDAO;

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return roleDAO.select();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return roleDAO.selectAllActive();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return roleDAO.selectAllInactive();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return roleDAO.selectByIdentifier(identifier);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    roleDAO.insert(newRecord);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    roleDAO.update(record);
  }

}
