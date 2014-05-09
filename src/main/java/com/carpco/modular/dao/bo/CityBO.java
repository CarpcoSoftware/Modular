/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.ICityDao;
import com.carpco.modular.dao.impl.ImplCityDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplCityDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class CityBO implements ICityDao {
  
  @Autowired
  private ImplCityDAO cityDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return cityDAO.select();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return cityDAO.selectAllActive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return cityDAO.selectAllInactive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return cityDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    cityDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    cityDAO.update(record);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.ICityDao#selectByState(int)
   */
  @Override
  public Set<DefaultTableModel> selectByState(int idState) {
    return cityDAO.selectByState(idState);
  }

}
