/**
 * 
 */
package com.carpco.modular.data.model.administration;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.AbstractCompanyModel;
import com.carpco.modular.data.model.location.CompanyAddress;

/**
 * Modular company table model.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class Company extends AbstractCompanyModel {

  /**
   * Database connection string that will be used when a user from this company tries to connect
   */
  private String dbConnection;

  /**
   * Set of users linked to company
   */
  private Set<User> userSet;
  
  /**
   * Set of company addresses
   */
  private Set<CompanyAddress> companyAddressSet;

  /**
   * ModularCompany constructor
   * 
   * @param code Modular company code
   * @param name Modular company name
   * @param dbConnection Modular company database connection
   */
  public Company(String code, String name, String dbConnection) {
    super(code, name);
    this.dbConnection = dbConnection;
  }

  /**
   * ModularCompany constructor with parameters
   * 
   * @param identifier Identifier from database
   * @param code Code from database
   * @param name Name from database
   * @param dtCreation Record's creation date and time
   * @param dtLastUpdate Record's last update date and time
   * @param enabled Flag to identify if record is enabled or disabled
   * @param dbConnection Database string to be used in order to get connection with database
   */
  public Company(int identifier, String code, String name, DateTime dtCreation,
      DateTime dtLastUpdate, boolean enabled, String dbConnection) {
    super(identifier, code, name, dtCreation, dtLastUpdate, enabled);
    this.dbConnection = dbConnection;
  }

  /**
   * @return the dbConnection
   */
  public String getDbConnection() {
    return dbConnection;
  }

  /**
   * @param dbConnection the dbConnection to set
   */
  public void setDbConnection(String dbConnection) {
    this.dbConnection = dbConnection;
  }

  /**
   * @return the userSet
   */
  public Set<User> getUserSet() {
    return userSet;
  }

  /**
   * @param userSet the userSet to set
   */
  public void setUserSet(Set<User> userSet) {
    this.userSet = userSet;
  }
  
  /**
   * Add a new user to the set
   * 
   * @param user New user to be added
   */
  public void addUser(User user) {
    if (this.userSet == null) {
      this.userSet = new HashSet<>();
    }
    this.userSet.add(user);
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
   * Add a new address to the set
   * 
   * @param address New address to be added
   */
  public void addCompanyAddress(CompanyAddress address) {
    if (this.companyAddressSet == null) {
      this.companyAddressSet = new HashSet<>();
    }
    this.companyAddressSet.add(address);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Company [dbConnection=" + dbConnection + ", userSet=" + userSet
        + ", companyAddressSet=" + companyAddressSet + ", identifier=" + identifier + ", code="
        + code + ", name=" + name + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate
        + ", enabled=" + enabled + "]";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((companyAddressSet == null) ? 0 : companyAddressSet.hashCode());
    result = prime * result + ((dbConnection == null) ? 0 : dbConnection.hashCode());
    result = prime * result + ((userSet == null) ? 0 : userSet.hashCode());
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
    if (companyAddressSet == null) {
      if (other.companyAddressSet != null)
        return false;
    } else if (!companyAddressSet.equals(other.companyAddressSet))
      return false;
    if (dbConnection == null) {
      if (other.dbConnection != null)
        return false;
    } else if (!dbConnection.equals(other.dbConnection))
      return false;
    if (userSet == null) {
      if (other.userSet != null)
        return false;
    } else if (!userSet.equals(other.userSet))
      return false;
    return true;
  }

}
