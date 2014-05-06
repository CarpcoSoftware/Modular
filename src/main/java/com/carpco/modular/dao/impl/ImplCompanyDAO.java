/**
 * 
 */
package com.carpco.modular.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.carpco.modular.dao.ICompanyDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;

/**
 * Company DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
@Repository
public class ImplCompanyDAO extends AbstractImplDAO implements ICompanyDao {

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection ");
    sql.append("FROM company ");

    List<Company> companyList = jdbcTemplateObject.query(sql.toString(), new CompanyMapper());
    return new HashSet<DefaultTableModel>(companyList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection ");
    sql.append("FROM company ");
    sql.append("WHERE enabled = 1 ");

    List<Company> companyList = jdbcTemplateObject.query(sql.toString(), new CompanyMapper());
    return new HashSet<DefaultTableModel>(companyList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection ");
    sql.append("FROM company ");
    sql.append("WHERE enabled = 0 ");

    List<Company> companyList = jdbcTemplateObject.query(sql.toString(), new CompanyMapper());
    return new HashSet<DefaultTableModel>(companyList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection ");
    sql.append("FROM company ");
    sql.append("WHERE identifier = ? AND enabled = 1 ");

    Company company =
        (Company) jdbcTemplateObject.queryForObject(sql.toString(), new Object[] {identifier},
            new CompanyMapper());
    return company;
  }

  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO company ");
    sql.append("(code, name, dbConnection) ");
    sql.append("VALUES (?, ?, ?)");

    Company company = (Company) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {company.getCode(), company.getName(),
        company.getDbConnection()});
  }

  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE company ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ?, dbConnection = ? ");
    sql.append("WHERE identifier = ? ");

    Company company = (Company) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {company.getCode(), company.getName(),
        new Timestamp(DateTime.now().getMillis()), company.isEnabled(), company.getDbConnection(),
        company.getIdentifier()});
  }

  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectByName(String name) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection ");
    sql.append("FROM company ");
    sql.append("WHERE name = ? AND enabled = 1 ");

    Company company =
        (Company) jdbcTemplateObject.queryForObject(sql.toString(), new Object[] {name},
            new CompanyMapper());
    return company;
  }
  
  @SuppressWarnings("rawtypes")
  private class CompanyMapper implements RowMapper {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("identifier");
      String code = rs.getString("code");
      String name = rs.getString("name");
      DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
      DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
      boolean enabled = rs.getBoolean("enabled");
      String dbConnection = rs.getString("dbConnection");

      return new Company(identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection);
    }

  }

}
