package com.carpco.modular.data.model.location;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * City is a model from database table.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class City extends DefaultTableModel {

  /**
   * State that city is linked
   */
  private State state;
  
  /**
   * {@link City} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   * @param state State linked to city
   */
  public City(String code, String name, State state) {
    super(code, name);
    this.state = state;
  }

  /**
   * {@link State} constructor with all parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   * @param state State linked to city
   */
  public City(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled, State state) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
    this.state = state;
  }

  /**
   * @return the state
   */
  public State getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(State state) {
    this.state = state;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "City [identification=" + identifier + ", code=" + code + ", name=" + name
        + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
        + "]";
  }

}
