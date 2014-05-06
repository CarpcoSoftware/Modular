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

import com.carpco.modular.dao.IDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Access;
import com.carpco.modular.data.model.administration.Role;

/**
 * Role DAO implementation
 * 
 * @author Carlos Rodriguez
 * 
 */
@Repository
public class ImplRoleDAO extends AbstractImplDAO implements IDao {
  
  @Autowired
  private ImplAccessDAO accessDao;

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

  @SuppressWarnings("unchecked")
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
  
  @SuppressWarnings("rawtypes")
  private class RoleMapper implements RowMapper {

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

      Role role = new Role(identifier, code, name, dtCreation, dtLastUpdate, enabled);
      Set<DefaultTableModel> defaultModelSet = accessDao.selectByRole(identifier);

      for (DefaultTableModel defaultModel : defaultModelSet) {
        role.addRolePermission((Access) defaultModel);
      }

      return role;
    }
  }

}
