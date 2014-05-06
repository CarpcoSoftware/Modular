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

import com.carpco.modular.dao.IAccessDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Access;

/**
 * Access DAO implementation
 * 
 * @author Carlos Rodriguez
 */
@Repository
public class ImplAccessDAO extends AbstractImplDAO implements IAccessDao {

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#select()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM access ");

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new AccessMapper());
    return new HashSet<DefaultTableModel>(accessList);
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
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM access ");
    sql.append("WHERE enabled = 1 ");

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new AccessMapper());
    return new HashSet<DefaultTableModel>(accessList);
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
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM access ");
    sql.append("WHERE enabled = 0 ");

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new AccessMapper());
    return new HashSet<DefaultTableModel>(accessList);
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
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM access ");
    sql.append("WHERE identifier = ? AND enabled = 1 ");

    DefaultTableModel access =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new AccessMapper());
    return access;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#insert(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO access ");
    sql.append("(code, name) ");
    sql.append("VALUES (?, ?)");

    Access access = (Access) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {access.getCode(), access.getName()});
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#update(com.carpco.modular.data.model.DefaultTableModel)
   */
  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE access ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ? ");
    sql.append("WHERE identifier = ? ");

    Access access = (Access) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {access.getCode(), access.getName(),
        new Timestamp(DateTime.now().getMillis()), access.isEnabled(), access.getIdentifier()});
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByRole(int idRole) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT a.identifier, a.code, a.name, a.dtCreation, a.dtLastUpdate, a.enabled ");
    sql.append("FROM access a ");
    sql.append("JOIN modular.role_access ra ON a.identifier = ra.idAccess AND ra.idRole = ? ");
    sql.append("WHERE a.enabled = 1 ");

    List<Access> accessList =
        jdbcTemplateObject.query(sql.toString(), new Object[] {idRole}, new AccessMapper());
    return new HashSet<DefaultTableModel>(accessList);
  }
  
  @SuppressWarnings("rawtypes")
  private class AccessMapper implements RowMapper {

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

}
