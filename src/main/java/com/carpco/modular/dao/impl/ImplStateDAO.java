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

import com.carpco.modular.dao.IStateDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.location.Country;
import com.carpco.modular.data.model.location.State;

/**
 * State DAO implementation
 * 
 * @author Carlos Rodriguez
 */
@Repository
public class ImplStateDAO extends AbstractImplDAO implements IStateDao {
  
  @Autowired
  private ImplCountryDAO countryDAO;

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#select()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCountry ");
    sql.append("FROM state ");

    List<State> stateList = jdbcTemplateObject.query(sql.toString(), new StateMapper());
    return new HashSet<DefaultTableModel>(stateList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllActive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCountry ");
    sql.append("FROM state ");
    sql.append("WHERE enabled = 1 ");

    List<State> stateList = jdbcTemplateObject.query(sql.toString(), new StateMapper());
    return new HashSet<DefaultTableModel>(stateList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectAllInactive()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCountry ");
    sql.append("FROM state ");
    sql.append("WHERE enabled = 0 ");

    List<State> stateList = jdbcTemplateObject.query(sql.toString(), new StateMapper());
    return new HashSet<DefaultTableModel>(stateList);
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCountry ");
    sql.append("FROM state ");
    sql.append("WHERE identifier = ? ");

    DefaultTableModel state =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new StateMapper());
    return state;
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO state ");
    sql.append("(code, name, idCountry) ");
    sql.append("VALUES (?, ?, ?)");

    State state = (State) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {state.getCode(), state.getName(), state.getCountry().getIdentifier()});
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE state ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ?, idCountry = ? ");
    sql.append("WHERE identifier = ? ");

    State state = (State) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {state.getCode(), state.getName(),
        new Timestamp(DateTime.now().getMillis()), state.isEnabled(), state.getCountry().getIdentifier(), state.getIdentifier()});
  }

  /* (non-Javadoc)
   * @see com.carpco.modular.dao.IStateDao#selectByCountry(int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByCountry(int idCountry) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, idCountry ");
    sql.append("FROM state ");
    sql.append("WHERE idCountry = ? AND enabled = 1 ");

    List<State> stateList = jdbcTemplateObject.query(sql.toString(), new Object[] {idCountry}, new StateMapper());
    return new HashSet<DefaultTableModel>(stateList);
  }
  
  @SuppressWarnings("rawtypes")
  private class StateMapper implements RowMapper {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("identifier");
      String code = rs.getString("code");
      String name = rs.getString("name");
      DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
      DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
      boolean enabled = rs.getBoolean("enabled");
      Country country = (Country) countryDAO.selectByIdentifier(rs.getInt("idCountry"));

      return new State(identifier, code, name, dtCreation, dtLastUpdate, enabled, country);
    }

  }

}
