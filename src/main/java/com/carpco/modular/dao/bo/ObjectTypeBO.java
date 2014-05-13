/**
 * 
 */
package com.carpco.modular.dao.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.dao.impl.AbstractImplDAO;
import com.carpco.modular.dao.impl.accounting.ImplObjectTypeDAO;
import com.carpco.modular.data.model.DefaultTableModel;

/**
 * This class is attempt to provide an entry point to {@link ImplObjectTypeDAO} object
 * 
 * @author Carlos Rodriguez
 */
@Service
public class ObjectTypeBO implements IDao, IModularTableBO {
  
  @Autowired
  private ImplObjectTypeDAO objectTypeDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @Override
  public Set<DefaultTableModel> select() {
    return  objectTypeDAO.select();
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

  @Override
  public void setDatasourceName(String datasourceName) {
    AbstractImplDAO.setDataSourceName(datasourceName);
  }

}
