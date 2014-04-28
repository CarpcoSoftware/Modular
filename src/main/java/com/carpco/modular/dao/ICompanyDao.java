/**
 * 
 */
package com.carpco.modular.dao;

import com.carpco.modular.data.model.administration.Company;


/**
 * Company DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 *
 */
public interface ICompanyDao extends IDao {
	
	public Company selectByName(String name);

}
