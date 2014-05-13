/**
 * 
 */
package com.carpco.modular.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.carpco.modular.dao.impl.AbstractImplDAO;

/**
 * @author Carlos Rodriguez
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

  /* (non-Javadoc)
   * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
   */
  @Override
  protected Object determineCurrentLookupKey() {
    return AbstractImplDAO.getDataSourceName();
  }

}
