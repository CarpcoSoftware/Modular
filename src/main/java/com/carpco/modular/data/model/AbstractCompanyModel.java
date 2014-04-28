/**
 * 
 */
package com.carpco.modular.data.model;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.location.CompanyAddress;

/**
 * Company table model
 * 
 * It is intended to be an entry point to different kind of company: <br/> 
 * 1- Modular client company that use the software <br/>
 * 2- Clients and providers from modular client company.
 * 
 * @author Carlos Rodriguez
 *
 */
public abstract class AbstractCompanyModel extends DefaultTableModel {

	/**
	 * Company address set
	 */
	private Set<CompanyAddress> companyAddressSet;
	
	/**
         * {@link AbstractCompanyModel} constructor without parameters
         */
        public AbstractCompanyModel() {
            super();
        }
        
        /**
         * {@link AbstractCompanyModel} constructor with parameters code and name
         * @param code Code that will be used for record
         * @param name Name that will be used for record
         */
        public AbstractCompanyModel(String code, String name) {
            super();
            this.code = code;
            this.name = name;
        }
        
        /**
         * {@link AbstractCompanyModel} constructor with all parameters
         * @param identifier Identifier from database
         * @param code Code from database
         * @param name Name from database
         * @param dtCreation Record's creation date and time
         * @param dtLastUpdate Record's last update date and time
         * @param enabled Flag to identify if record is enabled or disabled
         */
        public AbstractCompanyModel(int identifier, String code, String name, DateTime dtCreation, DateTime dtLastUpdate, boolean enabled) {
            super();
            this.identifier = identifier;
            this.code = code;
            this.name = name;
            this.dtCreation = dtCreation;
            this.dtLastUpdate = dtLastUpdate;
            this.enabled = enabled;
        }
	
	/**
	 * @return the companyAddressSet
	 */
	public Set<CompanyAddress> getCompanyAddressSet() {
		return companyAddressSet;
	}

	/**
	 * @param companyAddressSet the companyAddressSet to set
	 */
	public void setCompanyAddressSet(Set<CompanyAddress> companyAddressSet) {
		this.companyAddressSet = companyAddressSet;
	}

	/**
	 * Add a new company address to the set
	 * 
	 * @param companyAddress New company address to be added
	 */
	public void addCompanyAddress(CompanyAddress companyAddress) {
		if (this.companyAddressSet == null) {
			this.companyAddressSet = new HashSet<>();
		}
		this.companyAddressSet.add(companyAddress);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractCompanyModel [companyAddressSet=" + companyAddressSet
				+ ", identification=" + identifier + ", code=" + code
				+ ", name=" + name + ", dtCreation=" + dtCreation
				+ ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((companyAddressSet == null) ? 0 : companyAddressSet
						.hashCode());
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
		if (!(obj instanceof AbstractCompanyModel))
			return false;
		AbstractCompanyModel other = (AbstractCompanyModel) obj;
		if (companyAddressSet == null) {
			if (other.companyAddressSet != null)
				return false;
		} else if (!companyAddressSet.equals(other.companyAddressSet))
			return false;
		return true;
	}
}
