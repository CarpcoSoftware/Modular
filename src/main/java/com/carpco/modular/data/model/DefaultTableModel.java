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
public abstract class AbstractTableModel implements Comparable<AbstractTableModel> {
	
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
	public int compareTo(AbstractTableModel other) {
		return this.name.compareToIgnoreCase(other.getName());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((dtCreation == null) ? 0 : dtCreation.hashCode());
		result = prime * result
				+ ((dtLastUpdate == null) ? 0 : dtLastUpdate.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + identifier;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractTableModel))
			return false;
		AbstractTableModel other = (AbstractTableModel) obj;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractTableModel [identification=" + identifier
				+ ", code=" + code + ", name=" + name + ", dtCreation="
				+ dtCreation + ", dtLastUpdate=" + dtLastUpdate + ", enabled="
				+ enabled + "]";
	}
}
