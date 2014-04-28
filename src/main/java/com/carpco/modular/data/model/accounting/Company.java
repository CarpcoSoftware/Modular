/**
 * 
 */
package com.carpco.modular.data.model.accounting;

import com.carpco.modular.data.model.AbstractCompanyModel;
import com.carpco.modular.data.model.ObjectStatus;
import com.carpco.modular.data.model.ObjectType;


/**
 * Company is a model from database table.
 * 
 * It will contains all companies (Natural and legal firms) the type associated to this will help to identify it.
 * 
 * @author Carlos Rodriguez
 *
 */
public class Company extends AbstractCompanyModel {
	
	/**
	 * Object type, it must be company
	 */
	private ObjectType objectType;
	
	/**
	 * Object status, it can be client or provider
	 */
	private ObjectStatus objectStatus;
	
	/**
	 * @return the objectType
	 */
	public ObjectType getObjectType() {
		return objectType;
	}

	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	/**
	 * @return the objectStatus
	 */
	public ObjectStatus getObjectStatus() {
		return objectStatus;
	}

	/**
	 * @param objectStatus the objectStatus to set
	 */
	public void setObjectStatus(ObjectStatus objectStatus) {
		this.objectStatus = objectStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [objectType=" + objectType + ", objectStatus="
				+ objectStatus + ", identification=" + identifier
				+ ", code=" + code + ", name=" + name + ", dtCreation="
				+ dtCreation + ", dtLastUpdate=" + dtLastUpdate + ", enabled="
				+ enabled + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((objectStatus == null) ? 0 : objectStatus.hashCode());
		result = prime * result
				+ ((objectType == null) ? 0 : objectType.hashCode());
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
		if (!(obj instanceof Company))
			return false;
		Company other = (Company) obj;
		if (objectStatus == null) {
			if (other.objectStatus != null)
				return false;
		} else if (!objectStatus.equals(other.objectStatus))
			return false;
		if (objectType == null) {
			if (other.objectType != null)
				return false;
		} else if (!objectType.equals(other.objectType))
			return false;
		return true;
	}

}
