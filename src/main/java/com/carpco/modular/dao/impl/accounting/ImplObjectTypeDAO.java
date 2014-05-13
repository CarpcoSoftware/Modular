/**
 * 
 */
package com.carpco.modular.dao.impl.accounting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.dao.impl.AbstractImplDAO;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.ObjectType;
import com.carpco.modular.data.model.administration.Access;

/**
 * Object type DAO implementation
 * 
 * @author Carlos Rodriguez
 */
@Repository
public class ImplObjectTypeDAO extends AbstractImplDAO implements IDao {

  @SuppressWarnings("unchecked")
  @Override
  public Set<DefaultTableModel> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled ");
    sql.append("FROM object_type ");

    List<Access> objectTypeList = jdbcTemplateObject.query(sql.toString(), new ObjectTypeMapper());
    return new HashSet<DefaultTableModel>(objectTypeList);
  }

  @Override
  public Set<DefaultTableModel> selectAllActive() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<DefaultTableModel> selectAllInactive() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public DefaultTableModel selectByIdentifier(int identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insert(DefaultTableModel newRecord) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void update(DefaultTableModel record) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("rawtypes")
  private class ObjectTypeMapper implements RowMapper {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public ObjectType mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("identifier");
      String code = rs.getString("code");
      String name = rs.getString("name");
      DateTime dtCreation = new DateTime(rs.getTimestamp("dtCreation"));
      DateTime dtLastUpdate = new DateTime(rs.getTimestamp("dtLastUpdate"));
      boolean enabled = rs.getBoolean("enabled");

      return new ObjectType(identifier, code, name, dtCreation, dtLastUpdate, enabled);
    }

  }
}
