/**
 * 
 */
package com.carpco.modular.data.model.administration;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Role is a model from database table.
 * 
 * Role allows to know permissions that will be granted to users linked to it.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class Role extends DefaultTableModel {

  /**
   * Role access set linked to the role
   */
  private Set<Access> accessSet;

  /**
   * {@link Role} constructor without parameters
   */
  public Role() {
    super();
  }

  /**
   * {@link Role} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   */
  public Role(String code, String name) {
    super(code, name);
  }

  /**
   * {@link Role} constructor with all parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   */
  public Role(int identifier, String code, String name, DateTime dtCreation, DateTime dtLastUpdate,
      boolean enabled) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
  }

  /**
   * @return the rolePermissionSet
   */
  public Set<Access> getRoleAccessSet() {
    return accessSet;
  }

  /**
   * @param accessSet the accessSet to set
   */
  public void setRoleAccessSet(Set<Access> accessSet) {
    this.accessSet = accessSet;
  }

  /**
   * Add a new role access to the set
   * 
   * @param access New role access to be added
   */
  public void addRolePermission(Access access) {
    if (this.accessSet == null) {
      this.accessSet = new HashSet<>();
    }
    this.accessSet.add(access);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Role [rolePermissionSet=" + accessSet + ", identification=" + identifier + ", code="
        + code + ", name=" + name + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate
        + ", enabled=" + enabled + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((accessSet == null) ? 0 : accessSet.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (!(obj instanceof Role))
      return false;
    Role other = (Role) obj;
    if (accessSet == null) {
      if (other.accessSet != null)
        return false;
    } else if (!accessSet.equals(other.accessSet))
      return false;
    return true;
  }

}
