/**
 * 
 */
package com.carpco.modular.data.model.accounting;

import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.AbstractTableModel;
import com.carpco.modular.data.model.ObjectStatus;
import com.carpco.modular.data.model.ObjectType;
import com.carpco.modular.data.model.administration.User;

/**
 * Invoice is a model from database table.
 * 
 * This is the header from the invoice.
 * 
 * @author Carlos Rodriguez
 *
 */
public class Invoice extends AbstractTableModel {
	
	/**
	 * Company that receive or expedite the invoice
	 */
	private Company company;
	
	/**
	 * User that created the invoice
	 */
	private User user;
	
	/**
	 * Date from invoice creation, it's different to record creation date.
	 */
	private DateTime dtInvCreation;
	
	/**
	 * Invoice expiration date
	 */
	private DateTime dtInvExpiration;
	
	/**
	 * Object type, (INVO)
	 */
	private ObjectType objectType;
	
	/**
	 * Object status, (SAL, BUY, DEV)
	 */
	private ObjectStatus objectStatus;
	
	/**
	 * Invoice items that where sold or bought
	 */
	private Set<InvoiceItem> invoiceItemSet;

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the dtInvCreation
	 */
	public DateTime getDtInvCreation() {
		return dtInvCreation;
	}

	/**
	 * @param dtInvCreation the dtInvCreation to set
	 */
	public void setDtInvCreation(DateTime dtInvCreation) {
		this.dtInvCreation = dtInvCreation;
	}

	/**
	 * @return the dtInvExpiration
	 */
	public DateTime getDtInvExpiration() {
		return dtInvExpiration;
	}

	/**
	 * @param dtInvExpiration the dtInvExpiration to set
	 */
	public void setDtInvExpiration(DateTime dtInvExpiration) {
		this.dtInvExpiration = dtInvExpiration;
	}

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

	/**
	 * @return the invoiceItemSet
	 */
	public Set<InvoiceItem> getInvoiceItemSet() {
		return invoiceItemSet;
	}

	/**
	 * @param invoiceItemSet the invoiceItemSet to set
	 */
	public void setInvoiceItemSet(Set<InvoiceItem> invoiceItemSet) {
		this.invoiceItemSet = invoiceItemSet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Invoice [company=" + company + ", user=" + user
				+ ", dtInvCreation=" + dtInvCreation + ", dtInvExpiration="
				+ dtInvExpiration + ", objectType=" + objectType
				+ ", objectStatus=" + objectStatus + ", invoiceItemSet="
				+ invoiceItemSet + ", identification=" + identifier
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
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((dtInvCreation == null) ? 0 : dtInvCreation.hashCode());
		result = prime * result
				+ ((dtInvExpiration == null) ? 0 : dtInvExpiration.hashCode());
		result = prime * result
				+ ((invoiceItemSet == null) ? 0 : invoiceItemSet.hashCode());
		result = prime * result
				+ ((objectStatus == null) ? 0 : objectStatus.hashCode());
		result = prime * result
				+ ((objectType == null) ? 0 : objectType.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (!(obj instanceof Invoice))
			return false;
		Invoice other = (Invoice) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (dtInvCreation == null) {
			if (other.dtInvCreation != null)
				return false;
		} else if (!dtInvCreation.equals(other.dtInvCreation))
			return false;
		if (dtInvExpiration == null) {
			if (other.dtInvExpiration != null)
				return false;
		} else if (!dtInvExpiration.equals(other.dtInvExpiration))
			return false;
		if (invoiceItemSet == null) {
			if (other.invoiceItemSet != null)
				return false;
		} else if (!invoiceItemSet.equals(other.invoiceItemSet))
			return false;
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
