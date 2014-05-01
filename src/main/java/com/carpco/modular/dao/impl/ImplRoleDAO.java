package com.carpco.modular.dao.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.dao.impl.mapper.RoleMapper;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Role;

public class ImplRoleDAO extends AbstractImplDAO implements IDao {

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM role ");

    List<Role> roleList = jdbcTemplateObject.query(sql.toString(), new RoleMapper());
    return new HashSet<DefaultTableModel>(roleList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM role ");
    sql.append("WHERE enabled = 1 ");

    List<Role> roleList = jdbcTemplateObject.query(sql.toString(), new RoleMapper());
    return new HashSet<DefaultTableModel>(roleList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM role ");
    sql.append("WHERE enabled = 0 ");

    List<Role> roleList = jdbcTemplateObject.query(sql.toString(), new RoleMapper());
    return new HashSet<DefaultTableModel>(roleList);
  }

  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM role ");
    sql.append("WHERE identifier = ? AND enabled = 1 ");

    DefaultTableModel access =
        (DefaultTableModel) jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new RoleMapper());
    return access;
  }

  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO role ");
    sql.append("(code, name) ");
    sql.append("VALUES (?, ?)");

    Role role = (Role) newRecord;
    jdbcTemplateObject.update(sql.toString(), new Object[] {role.getCode(), role.getName()});
  }

  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE access ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ? ");
    sql.append("WHERE identifier = ? ");

    Role role = (Role) record;
    jdbcTemplateObject.update(sql.toString(), new Object[] {role.getCode(), role.getName(),
        new Timestamp(DateTime.now().getMillis()), role.isEnabled(), role.getIdentifier()});
  }

}
