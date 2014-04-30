/**
 * 
 */
package com.carpco.modular.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.carpco.modular.dao.ICompanyDao;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.data.model.administration.User;

/**
 * User mapper provides a wrapper from result set from database to {@link User} object
 * 
 * @author Carlos Rodriguez
 */
public class UserMapper implements RowMapper {

  /**
   * Load context bean that have info about all implementation beans
   */
  private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext(
      "spring-bean/Spring-Module.xml");

  /*
   * (non-Javadoc)
   * 
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
    String login = rs.getString("login");
    String password = rs.getString("password");
    int idCompany = rs.getInt("idCompany");

    User user =
        new User(identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password);
    ICompanyDao companyDAO = (ICompanyDao) CONTEXT.getBean("companyDAO");
    user.setCompany((Company) companyDAO.selectByIdentifier(idCompany));

    return user;
  }

}
