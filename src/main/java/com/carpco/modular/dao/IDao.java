/**
 * 
 */
package com.carpco.modular.dao;

import java.util.Set;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * Abstract DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 *
 */
public interface IDao {
	
	/**
	 * Selects all records from database
	 * 
	 * @return User set
	 */
	public Set<AbstractTableModel> select();
	
	/**
	 * Selects all active records from database
	 * 
	 * @return User set
	 */
	public Set<AbstractTableModel> selectAllActive();
	
	/**
	 * Selects all inactive records from database
	 * 
	 * @return User set
	 */
	public Set<AbstractTableModel> selectAllInactive();
	
	/**
	 * Select a record using identifier
	 * 
	 * @param identifier The identifier from database
	 * @return {@link AbstractTableModel} if identifier is found in database, null otherwise
	 */
	public AbstractTableModel selectByIdentifier(int identifier);
	
	/**
	 * Insert a new record in database
	 * 
	 * @param newRecord {@link AbstractTableModel} to be inserted
	 */
	public void insert(AbstractTableModel newRecord);
	
	/**
	 * Update a record in database
	 * 
	 * @param record {@link AbstractTableModel} to be inserted
	 */
	public void update(AbstractTableModel record);

}
