package com.carpco.modular.data.model.location;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * State is a model from database table.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class State extends DefaultTableModel {

  /**
   * Set of cities that are in the state.
   */
  private Set<City> citySet;

  /**
   * Country that state is linked
   */
  private Country country;
  
  /**
   * {@link State} constructor with parameters code and name
   * 
   * @param code Code that will be used for record
   * @param name Name that will be used for record
   * @param country Country linked to state
   */
  public State(String code, String name, Country country) {
    super(code, name);
    this.country = country;
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
   * @param country Country linked to state
   */
  public State(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled, Country country) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
    this.country = country;
  }

  /**
   * @return the citySet
   */
  public Set<City> getCitySet() {
    return citySet;
  }

  /**
   * @param citySet the citySet to set
   */
  public void setCitySet(Set<City> citySet) {
    this.citySet = citySet;
  }

  /**
   * Add a new city to the set
   * 
   * @param city New city to be added
   */
  public void addCity(City city) {
    if (this.citySet == null) {
      this.citySet = new HashSet<>();
    }
    this.citySet.add(city);
  }

  /**
   * @return the country
   */
  public Country getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(Country country) {
    this.country = country;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "State [citySet=" + citySet + ", country=" + country + ", identifier=" + identifier
        + ", code=" + code + ", name=" + name + ", dtCreation=" + dtCreation + ", dtLastUpdate="
        + dtLastUpdate + ", enabled=" + enabled + "]";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((citySet == null) ? 0 : citySet.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (!(obj instanceof State))
      return false;
    State other = (State) obj;
    if (citySet == null) {
      if (other.citySet != null)
        return false;
    } else if (!citySet.equals(other.citySet))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    return true;
  }

}
