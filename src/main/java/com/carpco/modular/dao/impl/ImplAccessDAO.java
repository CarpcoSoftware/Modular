/**
 * 
 */
package com.carpco.modular.dao.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.dao.impl.mapper.DefaultTableMapper;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Access;

/**
 * Access DAO implementation
 * 
 * @author Carlos Rodriguez *
 */
public class ImplAccessDAO extends AbstractImplDAO implements IDao {

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

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new DefaultTableMapper());
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

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new DefaultTableMapper());
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

    List<Access> accessList = jdbcTemplateObject.query(sql.toString(), new DefaultTableMapper());
    return new HashSet<DefaultTableModel>(accessList);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.carpco.modular.dao.IDao#selectByIdentifier(int)
   */
  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM access ");
    sql.append("WHERE identifier = ? AND enabled = 1 ");

    DefaultTableModel access =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new DefaultTableMapper());
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

}
