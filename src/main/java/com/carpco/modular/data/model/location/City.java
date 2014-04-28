package com.carpco.modular.data.model.location;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * City is a model from database table.
 * 
 * @author Carlos Rodriguez
 *
 */
public class City extends AbstractTableModel {
	
	/**
	 * State that city is linked
	 */
	private State state;
	
	/**
	 * City Constructor
	 * 
	 * @param code City code
	 * @param name City name
	 */
	public City(String code, String name) {
		super();
		this.code = code;
		this.name = name;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "City [identification=" + identifier + ", code=" + code
				+ ", name=" + name + ", dtCreation=" + dtCreation
				+ ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
				+ "]";
	}

}
