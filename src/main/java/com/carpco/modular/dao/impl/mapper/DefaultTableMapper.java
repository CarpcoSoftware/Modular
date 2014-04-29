/**
 * 
 */
package com.carpco.modular.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Default table mapper provides a common implementation to return an object that can be used for
 * all those who extends from {@link DefaultTableModel}
 * 
 * @author Carlos Rodriguez
 */
public class DefaultTableMapper implements RowMapper {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
   */
  @Override
  public DefaultTableModel mapRow(ResultSet rs, int rowNum) throws SQLException {
    int identifier = rs.getInt("identifier");
    String code = rs.getString("code");
    String name = rs.getString("name");
    DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
    DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
    boolean enabled = rs.getBoolean("enabled");

    return new DefaultTableModel(identifier, code, name, dtCreation, dtLastUpdate, enabled);
  }

}
