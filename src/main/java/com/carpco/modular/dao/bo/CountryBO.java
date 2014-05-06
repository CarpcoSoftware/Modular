/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.dao.impl.ImplCountryDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplCountryDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class CountryBO implements IDao {
  
  @Autowired
  private ImplCountryDAO countryDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return countryDAO.select();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return countryDAO.selectAllActive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return countryDAO.selectAllInactive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return countryDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    countryDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    countryDAO.update(record);
  }

}
