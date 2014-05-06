/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Abstract DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
@Component
public interface IDao {

  /**
   * Selects all records from database
   * 
   * @return User set
   */
  public Set<DefaultTableModel> select();

  /**
   * Selects all active records from database
   * 
   * @return User set
   */
  public Set<DefaultTableModel> selectAllActive();

  /**
   * Selects all inactive records from database
   * 
   * @return User set
   */
  public Set<DefaultTableModel> selectAllInactive();

  /**
   * Select a record using identifier
   * 
   * @param identifier The identifier from database
   * @return {@link DefaultTableModel} if identifier is found in database, null otherwise
   */
  public DefaultTableModel selectByIdentifier(int identifier);

  /**
   * Insert a new record in database
   * 
   * @param newRecord {@link DefaultTableModel} to be inserted
   */
  public void insert(DefaultTableModel newRecord);

  /**
   * Update a record in database
   * 
   * @param record {@link DefaultTableModel} to be inserted
   */
  public void update(DefaultTableModel record);

}
