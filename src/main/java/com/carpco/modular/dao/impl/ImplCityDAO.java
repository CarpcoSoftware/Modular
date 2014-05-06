/**
 * 
 */
package com.carpco.modular.dao.impl;

import java.util.Set;

import com.carpco.modular.dao.ICityDao;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * City DAO implementation
 * 
 * @author Carlos Rodriguez
 */
public class ImplCityDAO implements ICityDao {

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.ICityDao#selectByState(int)
   */
  @Override
  public Set<DefaultTableModel> selectByState(int idState) {
    // TODO Auto-generated method stub
    return null;
  }

}
