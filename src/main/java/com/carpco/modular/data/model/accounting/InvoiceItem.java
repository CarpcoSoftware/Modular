/**
 * 
 */
package com.carpco.modular.data.model.accounting;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * Invoice item is a model from database table.
 * 
 * Every invoice item is related to each product that was sold or bought in the invoice. 
 * 
 * @author Carlos Rodriguez
 *
 */
public class InvoiceItem extends AbstractTableModel {
	
	/**
	 * Product that was sold or bought
	 */
	private Product product;
	
	/**
	 * Price for each unity
	 */
	private double vlPriceUnity;
	
	/**
	 * Quantity of products sold or bought
	 */
	private int vlQuantity;
	
	/**
	 * Tax percent applied in the invoice
	 */
	private double taxPercent;
	
	public InvoiceItem(Product product, double vlPriceUnity, int vlQuantity, double taxPercent) {
		super();
		this.product = product;
		this.vlPriceUnity = vlPriceUnity;
		this.vlQuantity = vlQuantity;
		this.taxPercent = taxPercent;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the vlPriceUnity
	 */
	public double getVlPriceUnity() {
		return vlPriceUnity;
	}

	/**
	 * @param vlPriceUnity the vlPriceUnity to set
	 */
	public void setVlPriceUnity(double vlPriceUnity) {
		this.vlPriceUnity = vlPriceUnity;
	}

	/**
	 * @return the vlQuantity
	 */
	public int getVlQuantity() {
		return vlQuantity;
	}

	/**
	 * @param vlQuantity the vlQuantity to set
	 */
	public void setVlQuantity(int vlQuantity) {
		this.vlQuantity = vlQuantity;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InvoiceItem [product=" + product + ", vlPriceUnity="
				+ vlPriceUnity + ", vlQuantity=" + vlQuantity + ", taxPercent="
				+ taxPercent + ", identification=" + identifier + ", code="
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
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		long temp;
		temp = Double.doubleToLongBits(taxPercent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlPriceUnity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vlQuantity;
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
		if (!(obj instanceof InvoiceItem))
			return false;
		InvoiceItem other = (InvoiceItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (Double.doubleToLongBits(taxPercent) != Double
				.doubleToLongBits(other.taxPercent))
			return false;
		if (Double.doubleToLongBits(vlPriceUnity) != Double
				.doubleToLongBits(other.vlPriceUnity))
			return false;
		if (vlQuantity != other.vlQuantity)
			return false;
		return true;
	}

}
