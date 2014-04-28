/**
 * 
 */
package com.carpco.modular.dao;

import com.carpco.modular.data.model.administration.User;

/**
 * User DAO interface
 * 
 * Add here all methods that must be provided to DAO implementation
 * 
 * @author Carlos Rodriguez
 *
 */
public interface IUserDao extends IDao {
	
	/**
	 * Select a user using login and password
	 * 
	 * @param login Login used by user
	 * @param password Password used by user
	 * @return User if login and password are correct, null otherwise
	 */
	public User selectByLoginPassword(String login, String password);

}
