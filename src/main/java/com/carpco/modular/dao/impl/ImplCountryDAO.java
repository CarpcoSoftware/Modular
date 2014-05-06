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

import com.carpco.modular.dao.IDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.location.Country;

/**
 * Country DAO implementation
 * 
 * @author Carlos Rodriguez
 */
@Repository
public class ImplCountryDAO extends AbstractImplDAO implements IDao {

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM country ");

    List<Country> countryList = jdbcTemplateObject.query(sql.toString(), new CountryMapper());
    return new HashSet<DefaultTableModel>(countryList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM country ");
    sql.append("WHERE enabled = 1 ");

    List<Country> countryList = jdbcTemplateObject.query(sql.toString(), new CountryMapper());
    return new HashSet<DefaultTableModel>(countryList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM country ");
    sql.append("WHERE enabled = 0 ");

    List<Country> countryList = jdbcTemplateObject.query(sql.toString(), new CountryMapper());
    return new HashSet<DefaultTableModel>(countryList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM country ");
    sql.append("WHERE identifier = ? ");

    DefaultTableModel country =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new CountryMapper());
    return country;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO country ");
    sql.append("(code, name) ");
    sql.append("VALUES (?, ?)");

    Country country = (Country) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {country.getCode(), country.getName()});
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE country ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ? ");
    sql.append("WHERE identifier = ? ");

    Country country = (Country) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {country.getCode(), country.getName(),
        new Timestamp(DateTime.now().getMillis()), country.isEnabled(), country.getIdentifier()});
  }
  
  @SuppressWarnings("rawtypes")
  private class CountryMapper implements RowMapper {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("identifier");
      String code = rs.getString("code");
      String name = rs.getString("name");
      DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
      DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
      boolean enabled = rs.getBoolean("enabled");

      return new Country(identifier, code, name, dtCreation, dtLastUpdate, enabled);
    }

  }

}
