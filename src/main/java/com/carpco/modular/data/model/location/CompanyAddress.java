package com.carpco.modular.data.model.location;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * Company address is a model from database table.
 * 
 * It contains all address linked to a company.
 * 
 * @author Carlos Rodriguez
 *
 */
public class CompanyAddress extends AbstractTableModel {
	
	/**
	 * Flag to identify if it is the default client address. 
	 */
	private boolean defaultAddress;
	
	/**
	 * Phone 1 from company address
	 */
	private String phone1;
	
	/**
	 * Phone 2 from company address
	 */
	private String phone2;
	
	/**
	 * City where the company is located
	 */
	private City city;
	
	/**
	 * Company address Constructor
	 * 
	 * @param code Address code
	 * @param name City name
	 */
	public CompanyAddress(String code, String name, City city) {
		super();
		this.code = code;
		this.name = name;
		this.city = city;
	}

	/**
	 * @return the defaultAddress
	 */
	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	/**
	 * @param defaultAddress the defaultAddress to set
	 */
	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyAddress [defaultAddress=" + defaultAddress + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", city=" + city
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (defaultAddress ? 1231 : 1237);
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
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
		if (!(obj instanceof CompanyAddress))
			return false;
		CompanyAddress other = (CompanyAddress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (defaultAddress != other.defaultAddress)
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		return true;
	}

}
