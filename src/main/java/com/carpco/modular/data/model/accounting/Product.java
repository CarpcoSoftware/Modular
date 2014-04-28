/**
 * 
 */
package com.carpco.modular.data.model.accounting;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.ObjectStatus;
import com.carpco.modular.data.model.ObjectType;


/**
 * Product is a model from database table
 * 
 * @author Carlos Rodriguez
 *
 */
public class Product extends DefaultTableModel {
	
	/**
	 * Object type, (PROD)
	 */
	private ObjectType objectType;
	
	/**
	 * Object status, (NOR, BON)
	 */
	private ObjectStatus objectStatus;
	
	/**
	 * Product category
	 */
	private ProductCategory productCategory;
	
	/**
	 * Product minimum price
	 */
	private double vlMinPrice;
	
	/**
	 * Product maximum price
	 */
	private double vlMaxPrice;
	
	/**
	 * Product constructor
	 * 
	 * @param code Product code
	 * @param name Product name
	 * @param productCategory Product category linked
	 */
	public Product(String code, String name, ProductCategory productCategory) {
		super();
		this.code = code;
		this.name = name;
		this.productCategory = productCategory;
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
	 * @return the productCategory
	 */
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the vlMinPrice
	 */
	public double getVlMinPrice() {
		return vlMinPrice;
	}

	/**
	 * @param vlMinPrice the vlMinPrice to set
	 */
	public void setVlMinPrice(double vlMinPrice) {
		this.vlMinPrice = vlMinPrice;
	}

	/**
	 * @return the vlMaxPrice
	 */
	public double getVlMaxPrice() {
		return vlMaxPrice;
	}

	/**
	 * @param vlMaxPrice the vlMaxPrice to set
	 */
	public void setVlMaxPrice(double vlMaxPrice) {
		this.vlMaxPrice = vlMaxPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [objectType=" + objectType + ", objectStatus="
				+ objectStatus + ", productCategory=" + productCategory
				+ ", vlMinPrice=" + vlMinPrice + ", vlMaxPrice=" + vlMaxPrice
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
		result = prime * result
				+ ((objectStatus == null) ? 0 : objectStatus.hashCode());
		result = prime * result
				+ ((objectType == null) ? 0 : objectType.hashCode());
		result = prime * result
				+ ((productCategory == null) ? 0 : productCategory.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vlMaxPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlMinPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
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
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (Double.doubleToLongBits(vlMaxPrice) != Double
				.doubleToLongBits(other.vlMaxPrice))
			return false;
		if (Double.doubleToLongBits(vlMinPrice) != Double
				.doubleToLongBits(other.vlMinPrice))
			return false;
		return true;
	}

}
