package com.carpco.modular.data.model.location;

import java.util.HashSet;
import java.util.Set;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * State is a model from database table.
 * 
 * @author Carlos Rodriguez
 *
 */
public class State extends AbstractTableModel {
	
	/**
	 * Set of cities that are in the state.
	 */
	private Set<City> citySet;
	
	/**
	 * Country that state is linked
	 */
	private Country country;
	
	/**
	 * State constructor
	 * 
	 * @param code State code
	 * @param name State name
	 */
	public State(String code, String name) {
		super();
		this.code = code;
		this.name = name;
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
		return "State [citySet=" + citySet + ", identification="
				+ identifier + ", code=" + code + ", name=" + name
				+ ", dtCreation=" + dtCreation + ", dtLastUpdate="
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
		return true;
	}
	
}
