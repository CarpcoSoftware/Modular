/**
 * 
 */
package com.carpco.modular.dao.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.dao.IUserDao;
import com.carpco.modular.dao.impl.mapper.UserMapper;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.User;

/**
 * User DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
public class ImplUserDAO extends AbstractImplDAO implements IUserDao {

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");

    List<User> userList = jdbcTemplateObject.query(sql.toString(), new UserMapper());
    return new HashSet<DefaultTableModel>(userList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllActive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");
    sql.append("WHERE enabled = 1 ");

    List<User> userList = jdbcTemplateObject.query(sql.toString(), new UserMapper());
    return new HashSet<DefaultTableModel>(userList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");
    sql.append("WHERE enabled = 0 ");

    List<User> userList = jdbcTemplateObject.query(sql.toString(), new UserMapper());
    return new HashSet<DefaultTableModel>(userList);
  }

  @Override
  public void insert(DefaultTableModel newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO user ");
    sql.append("(code, name, login, password, idCompany, idRole) ");
    sql.append("VALUES (?, ?, ?, ?, ?, ?)");

    User user = (User) newRecord;
    jdbcTemplateObject.update(sql.toString(),
        new Object[] {user.getCode(), user.getName(), user.getLogin(), user.getPassword(),
            user.getCompany().getIdentifier(), user.getRole().getIdentifier()});
  }

  @Override
  public void update(DefaultTableModel record) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE user ");
    sql.append("SET code = ?, name = ?, dtLastUpdate = ?, enabled = ?, login = ?, password = ?, idCompany = ?, idRole = ? ");
    sql.append("WHERE identifier = ? ");

    User user = (User) record;
    jdbcTemplateObject
        .update(
            sql.toString(),
            new Object[] {user.getCode(), user.getName(),
                new Timestamp(DateTime.now().getMillis()), user.isEnabled(), user.getLogin(),
                user.getPassword(), user.getCompany().getIdentifier(),
                user.getRole().getIdentifier(), user.getIdentifier()});
  }

  @Override
  public User selectByLoginPassword(String login, String password) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");
    sql.append("WHERE login = ? AND password = ? AND enabled = 1 ");

    User user =
        (User) jdbcTemplateObject.queryForObject(sql.toString(), new Object[] {login, password},
            new UserMapper());
    return user;
  }

  @Override
  public User selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");
    sql.append("WHERE identifier = ? AND enabled = 1 ");

    User user =
        (User) jdbcTemplateObject.queryForObject(sql.toString(), new Object[] {identifier},
            new UserMapper());
    return user;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByCompany(int idCompany) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");
    sql.append("WHERE idCompany = ? AND enabled = 1 ");

    List<User> userList = jdbcTemplateObject.query(sql.toString(), new Object[] {idCompany}, new UserMapper());
    return new HashSet<DefaultTableModel>(userList);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> selectByRole(int idRole) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, login, password, idCompany ");
    sql.append("FROM user ");
    sql.append("WHERE idRole = ? AND enabled = 1 ");

    List<User> userList = jdbcTemplateObject.query(sql.toString(), new Object[] {idRole}, new UserMapper());
    return new HashSet<DefaultTableModel>(userList);
  }
}
