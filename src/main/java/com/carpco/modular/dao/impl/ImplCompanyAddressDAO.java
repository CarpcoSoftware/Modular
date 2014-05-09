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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.carpco.modular.dao.ICompanyAddressDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.data.model.location.City;
import com.carpco.modular.data.model.location.CompanyAddress;

/**
 * Company address DAO implementation
 * 
 * @author Carlos Rodriguez
 */
@Repository
public class ImplCompanyAddressDAO extends AbstractImplDAO implements ICompanyAddressDao {

  @Autowired
  private ImplCompanyDAO companyDAO;

  @Autowired
  private ImplCityDAO cityDAO;

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#select()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");

    List<CompanyAddress> comAddressList =
        jdbcTemplateObject.query(sql.toString(), new CompanyAddressMapper());
    return new HashSet<DefaultTableModel>(comAddressList);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");
    sql.append("WHERE enabled = 1 ");

    List<CompanyAddress> comAddressList =
        jdbcTemplateObject.query(sql.toString(), new CompanyAddressMapper());
    return new HashSet<DefaultTableModel>(comAddressList);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");
    sql.append("WHERE enabled = 0 ");

    List<CompanyAddress> comAddressList =
        jdbcTemplateObject.query(sql.toString(), new CompanyAddressMapper());
    return new HashSet<DefaultTableModel>(comAddressList);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");
    sql.append("WHERE identifier = ? ");

    DefaultTableModel companyAddress =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new CompanyAddressMapper());
    return companyAddress;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO company_address ");
    sql.append("(name, phone1, defaultAddress, idCompany, idCity) ");
    sql.append("VALUES (?, ?, ?, ?, ?)");

    CompanyAddress address = (CompanyAddress) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {address.getName(), address.getPhone1(),
        address.isDefaultAddress(), address.getCompany().getIdentifier(),
        address.getCity().getIdentifier()});
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE company_address ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ?, idCompany = ?, defaultAddress = ?, phone1 = ?, phone2 = ?, idCity = ? ");
    sql.append("WHERE identifier = ? ");

    CompanyAddress address = (CompanyAddress) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {address.getCode(), address.getName(),
        new Timestamp(DateTime.now().getMillis()), address.isEnabled(),
        address.getCompany().getIdentifier(), address.isDefaultAddress(), address.getPhone1(),
        address.getPhone2(), address.getCity().getIdentifier(), address.getIdentifier()});
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.ICompanyAddressDao#selectByCompany(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByCompany(int idCompany) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");
    sql.append("WHERE idCompany = ? AND enabled = 1 ");

    List<CompanyAddress> comAddressList =
        jdbcTemplateObject.query(sql.toString(), new Object[] {idCompany},
            new CompanyAddressMapper());
    return new HashSet<DefaultTableModel>(comAddressList);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.ICompanyAddressDao#selectDefaultAddressByCompany(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectDefaultAddressByCompany(int idCompany) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");
    sql.append("WHERE idCompany = ? AND enabled = 1 AND defaultAddress = 1 ");

    DefaultTableModel companyAddress =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {idCompany}, new CompanyAddressMapper());
    return companyAddress;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByCity(int idCity) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCompany, defaultAddress, phone1, phone2, idCity ");
    sql.append("FROM company_address ");
    sql.append("WHERE idCity = ? AND enabled = 1 ");

    List<CompanyAddress> comAddressList =
        jdbcTemplateObject.query(sql.toString(), new Object[] {idCity}, new CompanyAddressMapper());
    return new HashSet<DefaultTableModel>(comAddressList);
  }

  @SuppressWarnings("rawtypes")
  private class CompanyAddressMapper implements RowMapper {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public CompanyAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("identifier");
      String code = rs.getString("code");
      String name = rs.getString("name");
      DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
      DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
      boolean enabled = rs.getBoolean("enabled");
      Company company = (Company) companyDAO.selectByIdentifier(rs.getInt("idCompany"));
      boolean defaultAddress = rs.getBoolean("defaultAddress");
      String phone1 = rs.getString("phone1");
      String phone2 = rs.getString("phone2");
      City city = (City) cityDAO.selectByIdentifier(rs.getInt("idCity"));

      return new CompanyAddress(identifier, code, name, dtCreation, dtLastUpdate, enabled, company,
          defaultAddress, phone1, phone2, city);
    }

  }
}
