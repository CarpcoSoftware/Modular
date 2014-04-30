package com.carpco.modular.data.model.administration;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Access is a model from database table.
 * 
 * It allows to know what access has the user.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class Access extends DefaultTableModel {

  /**
   * {@link Access} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   */
  public Access(String code, String name) {
    super(code, name);
  }

  /**
   * {@link Access} constructor with all parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   */
  public Access(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Access [identifier=" + identifier + ", code=" + code + ", name=" + name
        + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
        + "]";
  }

}
