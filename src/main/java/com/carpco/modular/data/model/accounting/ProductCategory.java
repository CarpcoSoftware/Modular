package com.carpco.modular.data.model.accounting;

import java.util.HashSet;
import java.util.Set;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * Product category is a model from database table
 * 
 * @author Carlos Rodriguez
 *
 */
public class ProductCategory extends AbstractTableModel {
	
	/**
	 * Percent of tax that will be applied to products in this category
	 */
	private double taxPercent;
	
	/**
	 * Product set linked to the category
	 */
	private Set<Product> productSet;
	
	/**
	 * Product category constructor
	 * 
	 * @param code Product category code
	 * @param name Product category name
	 * @param taxPercent Product category tax percent
	 */
	public ProductCategory(String code, String name, double taxPercent) {
		super();
		this.code = code;
		this.name = name;
		this.taxPercent = taxPercent;
	}

	/**
	 * @return the taxPercent
	 */
	public double getTaxPercent() {
		return taxPercent;
	}

	/**
	 * @param taxPercent the taxPercent to set
	 */
	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}

	/**
	 * @return the productSet
	 */
	public Set<Product> getProductSet() {
		return productSet;
	}

	/**
	 * @param productSet the productSet to set
	 */
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}
	
	/**
	 * Add a new product to the set
	 * 
	 * @param product New product to be added
	 */
	public void addProduct(Product product) {
		if (this.productSet == null) {
			this.productSet = new HashSet<>();
		}
		this.productSet.add(product);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductCategory [taxPercent=" + taxPercent + ", productSet="
				+ productSet + ", identification=" + identifier + ", code="
				+ code + ", name=" + name + ", dtCreation=" + dtCreation
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
				+ ((productSet == null) ? 0 : productSet.hashCode());
		long temp;
		temp = Double.doubleToLongBits(taxPercent);
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
		if (!(obj instanceof ProductCategory))
			return false;
		ProductCategory other = (ProductCategory) obj;
		if (productSet == null) {
			if (other.productSet != null)
				return false;
		} else if (!productSet.equals(other.productSet))
			return false;
		if (Double.doubleToLongBits(taxPercent) != Double
				.doubleToLongBits(other.taxPercent))
			return false;
		return true;
	}

}
