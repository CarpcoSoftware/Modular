/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.ICompanyAddressDao;
import com.carpco.modular.dao.impl.ImplCompanyAddressDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplCompanyAddressDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class CompanyAddressBO implements ICompanyAddressDao {
  
  @Autowired
  private ImplCompanyAddressDAO companyAddressDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return companyAddressDAO.select();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    return companyAddressDAO.selectAllActive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    return companyAddressDAO.selectAllInactive();
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    return companyAddressDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    companyAddressDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    companyAddressDAO.update(record);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.ICompanyAddressDao#selectByCompany(int)
   */
  @Override
  public Set<DefaultTableModel> selectByCompany(int idCompany) {
    return companyAddressDAO.selectByCompany(idCompany);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.ICompanyAddressDao#selectDefaultAddressByCompany(int)
   */
  @Override
  public DefaultTableModel selectDefaultAddressByCompany(int idCompany) {
    return companyAddressDAO.selectDefaultAddressByCompany(idCompany);
  }

  @Override
  public Set<DefaultTableModel> selectByCity(int idCity) {
    return companyAddressDAO.selectByCity(idCity);
  }

}
