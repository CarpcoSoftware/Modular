package com.carpco.modular.data.model.location;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Country is a model from database table.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class Country extends DefaultTableModel {

  /**
   * Set of states(departments) that are in the country.
   */
  private Set<State> stateSet;
  
  /**
   * {@link Country} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   */
  public Country(String code, String name) {
    super(code, name);
  }

  /**
   * {@link Country} constructor with all parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   */
  public Country(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
  }

  /**
   * @return the stateSet
   */
  public Set<State> getStateSet() {
    return stateSet;
  }

  /**
   * @param stateSet the stateSet to set
   */
  public void setStateSet(Set<State> stateSet) {
    this.stateSet = stateSet;
  }

  /**
   * Add a new state to the set
   * 
   * @param state New state to be added
   */
  public void addState(State state) {
    if (this.stateSet == null) {
      this.stateSet = new HashSet<>();
    }
    this.stateSet.add(state);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Country [stateSet=" + stateSet + ", identification=" + identifier + ", code=" + code
        + ", name=" + name + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate
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
    result = prime * result + ((stateSet == null) ? 0 : stateSet.hashCode());
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
    if (!(obj instanceof Country))
      return false;
    Country other = (Country) obj;
    if (stateSet == null) {
      if (other.stateSet != null)
        return false;
    } else if (!stateSet.equals(other.stateSet))
      return false;
    return true;
  }

}
