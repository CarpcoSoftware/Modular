package com.carpco.modular.data.model;

/**
 * Object status is a model from database table.
 * 
 * @author Carlos Rodriguez
 *
 */
public class ObjectStatus extends AbstractTableModel {
	
	/**
	 * Object status constructor
	 * 
	 * @param code Object status code
	 * @param name Object status name
	 */
	public ObjectStatus(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectStatus [identification=" + identifier + ", code="
				+ code + ", name=" + name + ", dtCreation=" + dtCreation
				+ ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
				+ "]";
	}

}
