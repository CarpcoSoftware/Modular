/**
 * 
 */
package com.carpco.modular.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.carpco.modular.dao.IAccessDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Access;
import com.carpco.modular.data.model.administration.Role;

/**
 * Role mapper provides a wrapper from result set from database to {@link Role} object
 * 
 * @author Carlos Rodriguez
 */
public class RoleMapper implements RowMapper {
  
  /**
   * Load context bean that have info about all implementation beans
   */
  private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext(
      "spring-bean/Spring-Module.xml");

  /* (non-Javadoc)
   * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
   */
  @Override
  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    int identifier = rs.getInt("identifier");
    String code = rs.getString("code");
    String name = rs.getString("name");
    DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
    DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
    boolean enabled = rs.getBoolean("enabled");
    
    Role role = new Role(identifier, code, name, dtCreation, dtLastUpdate, enabled);
    IAccessDao accessDao = (IAccessDao) CONTEXT.getBean("accessDAO");
    Set<DefaultTableModel> defaultModelSet = accessDao.selectByRole(identifier);
    
    for(DefaultTableModel defaultModel : defaultModelSet) {
      role.addRolePermission((Access) defaultModel);
    }
    
    return role;
  }

}
