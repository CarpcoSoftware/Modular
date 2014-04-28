/**
 * 
 */
package com.carpco.modular.dao.impl;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Abstract DAO implementation
 * 
 * All DAO implementations must extend this class
 * 
 * @author Carlos Rodriguez
 *
 */
public abstract class AbstractImplDAO {
	
	/**
	 * Load context bean that have info about all implementation beans
	 */
	protected static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("spring-bean/Spring-Module.xml");
	
	/**
	 * Data source to allow access to database
	 */
	protected DataSource dataSource;
	 
	/**
	 * Sets a new data source
	 * 
	 * @param dataSource Data source to be set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
