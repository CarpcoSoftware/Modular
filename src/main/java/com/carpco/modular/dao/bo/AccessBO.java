/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.IAccessDao;
import com.carpco.modular.dao.impl.ImplAccessDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplAccessDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class AccessBO implements IAccessDao {
  
  @Autowired
  private ImplAccessDAO accessDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return accessDAO.select();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return accessDAO.selectAllActive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return accessDAO.selectAllInactive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return accessDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    accessDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    accessDAO.update(record);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IAccessDao#selectByRole(int)
   */
  @Override
  public Set<DefaultTableModel> selectByRole(int idRole) {
    return accessDAO.selectByRole(idRole);
  }

}
