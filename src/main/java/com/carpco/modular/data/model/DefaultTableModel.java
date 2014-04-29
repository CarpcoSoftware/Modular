package com.carpco.modular.data.model;

import org.joda.time.DateTime;

/**
 * Database table model.
 * 
 * It contains all common columns that are in all tables.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class DefaultTableModel implements Comparable<DefaultTableModel> {

  /**
   * Incremental identification from database.
   */
  protected int identifier;

  /**
   * Code that client uses to identify record.
   */
  protected String code;

  /**
   * Name that client set to record
   */
  protected String name;

  /**
   * Record creation date
   */
  protected DateTime dtCreation;

  /**
   * Record last update date
   */
  protected DateTime dtLastUpdate;

  /**
   * Flag used to identify is record is enable or disable.
   */
  protected boolean enabled;

  /**
   * @return the identification
   */
  public int getIdentifier() {
    return identifier;
  }

  /**
   * @param identifier the identification to set
   */
  public void setIdentifier(int identifier) {
    this.identifier = identifier;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the dtCreation
   */
  public DateTime getDtCreation() {
    return dtCreation;
  }

  /**
   * @param dtCreation the dtCreation to set
   */
  public void setDtCreation(DateTime dtCreation) {
    this.dtCreation = dtCreation;
  }

  /**
   * @return the dtLastUpdate
   */
  public DateTime getDtLastUpdate() {
    return dtLastUpdate;
  }

  /**
   * @param dtLastUpdate the dtLastUpdate to set
   */
  public void setDtLastUpdate(DateTime dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  /**
   * @return the enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public int compareTo(DefaultTableModel other) {
    return this.name.compareToIgnoreCase(other.getName());
  }

  /**
   * {@link DefaultTableModel} constructor without parameters
   */
  public DefaultTableModel() {
    super();
  }

  /**
   * {@link DefaultTableModel} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   */
  public DefaultTableModel(String code, String name) {
    super();
    this.code = code;
    this.name = name;
  }

  /**
   * {@link DefaultTableModel} constructor with all parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   */
  public DefaultTableModel(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled) {
    super();
    this.identifier = identifier;
    this.code = code;
    this.name = name;
    this.dtCreation = dtCreation;
    this.dtLastUpdate = dtLastUpdate;
    this.enabled = enabled;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    result = prime * result + ((dtCreation == null) ? 0 : dtCreation.hashCode());
    result = prime * result + ((dtLastUpdate == null) ? 0 : dtLastUpdate.hashCode());
    result = prime * result + (enabled ? 1231 : 1237);
    result = prime * result + identifier;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    if (obj == null)
      return false;
    if (!(obj instanceof DefaultTableModel))
      return false;
    DefaultTableModel other = (DefaultTableModel) obj;
    if (code == null) {
      if (other.code != null)
        return false;
    } else if (!code.equals(other.code))
      return false;
    if (dtCreation == null) {
      if (other.dtCreation != null)
        return false;
    } else if (!dtCreation.equals(other.dtCreation))
      return false;
    if (dtLastUpdate == null) {
      if (other.dtLastUpdate != null)
        return false;
    } else if (!dtLastUpdate.equals(other.dtLastUpdate))
      return false;
    if (enabled != other.enabled)
      return false;
    if (identifier != other.identifier)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "DefaultTableModel [identification=" + identifier + ", code=" + code + ", name=" + name
        + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
        + "]";
  }
}
