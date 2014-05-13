/**
 * 
 */
package com.carpco.modular.data.model;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

/**
 * Object type is a model from database table.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class ObjectType extends DefaultTableModel {

  /**
   * Object status set
   */
  private Set<ObjectStatus> objectStatusSet;
  
  /**
   * {@link ObjectType} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   */
  public ObjectType(String code, String name) {
    super(code, name);
  }

  /**
   * {@link ObjectType} constructor with all parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   */
  public ObjectType(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
  }

  /**
   * @return the objectStatusSet
   */
  public Set<ObjectStatus> getObjectStatusSet() {
    return objectStatusSet;
  }

  /**
   * @param objectStatusSet the objectStatusSet to set
   */
  public void setObjectStatusSet(Set<ObjectStatus> objectStatusSet) {
    this.objectStatusSet = objectStatusSet;
  }

  /**
   * Add a new object status to the set
   * 
   * @param objectStatus New object status to be added
   */
  public void addObjectStatus(ObjectStatus objectStatus) {
    if (this.objectStatusSet == null) {
      this.objectStatusSet = new HashSet<>();
    }
    this.objectStatusSet.add(objectStatus);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ObjectType [objectStatusSet=" + objectStatusSet + ", identification=" + identifier
        + ", code=" + code + ", name=" + name + ", dtCreation=" + dtCreation + ", dtLastUpdate="
        + dtLastUpdate + ", enabled=" + enabled + "]";
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
    result = prime * result + ((objectStatusSet == null) ? 0 : objectStatusSet.hashCode());
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
    if (!(obj instanceof ObjectType))
      return false;
    ObjectType other = (ObjectType) obj;
    if (objectStatusSet == null) {
      if (other.objectStatusSet != null)
        return false;
    } else if (!objectStatusSet.equals(other.objectStatusSet))
      return false;
    return true;
  }

}
