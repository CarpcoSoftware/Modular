/**
 * 
 */
package com.carpco.modular.data.model;

import java.util.HashSet;
import java.util.Set;

import com.carpco.modular.data.model.location.CompanyAddress;

/**
 * Company table model
 * 
 * It is intended to be an entry point to different kind of company: <br/> 
 * 1- Modular client company that use the software
 * 2- Clients and providers from modular client company.
 * 
 * @author Carlos Rodriguez
 *
 */
public class AbstractCompanyModel extends AbstractTableModel {

	/**
	 * Company address set
	 */
	private Set<CompanyAddress> companyAddressSet;
	
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
