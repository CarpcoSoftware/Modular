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

import com.carpco.modular.dao.ICityDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Access;
import com.carpco.modular.data.model.location.City;
import com.carpco.modular.data.model.location.State;

/**
 * City DAO implementation
 * 
 * @author Carlos Rodriguez
 */
@Repository
public class ImplCityDAO extends AbstractImplDAO implements ICityDao {
  
  @Autowired
  private ImplStateDAO stateDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idState ");
    sql.append("FROM city ");

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new CityMapper());
    return new HashSet<DefaultTableModel>(accessList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idState ");
    sql.append("FROM city ");
    sql.append("WHERE enabled = 1 ");

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new CityMapper());
    return new HashSet<DefaultTableModel>(accessList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idState ");
    sql.append("FROM city ");
    sql.append("WHERE enabled = 0 ");

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new CityMapper());
    return new HashSet<DefaultTableModel>(accessList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idState ");
    sql.append("FROM city ");
    sql.append("WHERE identifier = ? ");

    DefaultTableModel city =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new CityMapper());
    return city;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO city ");
    sql.append("(code, name, idState) ");
    sql.append("VALUES (?, ?, ?)");

    City city = (City) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {city.getCode(), city.getName(), city.getState().getIdentifier()});
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE city ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ?, idState = ? ");
    sql.append("WHERE identifier = ? ");

    City city = (City) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {city.getCode(), city.getName(),
        new Timestamp(DateTime.now().getMillis()), city.isEnabled(), city.getState().getIdentifier(), city.getIdentifier()});
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.ICityDao#selectByState(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByState(int idState) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idState ");
    sql.append("FROM city ");
    sql.append("WHERE idState = ? AND enabled = 1 ");

    List<State> stateList = jdbcTemplateObject.query(sql.toString(), new Object[] {idState}, new CityMapper());
    return new HashSet<DefaultTableModel>(stateList);
  }

  @SuppressWarnings("rawtypes")
  private class CityMapper implements RowMapper {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("identifier");
      String code = rs.getString("code");
      String name = rs.getString("name");
      DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
      DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
      boolean enabled = rs.getBoolean("enabled");
      State state = (State) stateDAO.selectByIdentifier(rs.getInt("idState"));

      return new City(identifier, code, name, dtCreation, dtLastUpdate, enabled, state);
    }

  }
}
