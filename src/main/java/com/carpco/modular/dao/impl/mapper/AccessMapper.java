/**
 * 
 */
package com.carpco.modular.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import com.carpco.modular.data.model.administration.Access;

/**
 * Access mapper provides a wrapper from result set from database to {@link Access} object
 * 
 * @author Carlos Rodriguez
 */
public class AccessMapper implements RowMapper {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
   */
  @Override
  public Access mapRow(ResultSet rs, int rowNum) throws SQLException {
    int identifier = rs.getInt("identifier");
    String code = rs.getString("code");
    String name = rs.getString("name");
    DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
    DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
    boolean enabled = rs.getBoolean("enabled");

    return new Access(identifier, code, name, dtCreation, dtLastUpdate, enabled);
  }

}
