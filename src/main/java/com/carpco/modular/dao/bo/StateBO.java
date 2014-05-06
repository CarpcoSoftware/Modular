/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.IStateDao;
import com.carpco.modular.dao.impl.ImplStateDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplStateDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class StateBO implements IStateDao {
  
  @Autowired
  private ImplStateDAO stateDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return stateDAO.select();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return stateDAO.selectAllActive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return stateDAO.selectAllInactive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return stateDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    stateDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    stateDAO.update(record);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IStateDao#selectByCountry(int)
   */
  @Override
  public Set<DefaultTableModel> selectByCountry(int idCountry) {
    return stateDAO.selectByCountry(idCountry);
  }

}
