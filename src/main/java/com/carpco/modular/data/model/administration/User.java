/**
 * 
 */
package com.carpco.modular.data.model.administration;

import org.joda.time.DateTime;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * User is a model from database table.
 * 
 * User has roles linked to it, that roles allows it to do some actions
 * 
 * @author Carlos Rodriguez
 * 
 */
public class User extends DefaultTableModel {

  /**
   * User's login
   */
  private String login;

  /**
   * User's password, it's kept encrypted
   */
  private String password;

  /**
   * Role linked to user
   */
  private Role role;

  /**
   * Company linked to user
   */
  private Company company;

  /**
   * User constructor
   * 
   * @param code User code
   * @param name User name
   * @param login User login
   * @param password User password
   * @param company Company linked to user
   * @param role Role linked to user
   */
  public User(String code, String name, String login, String password, Company company, Role role) {
    super();
    this.code = code;
    this.name = name;
    this.login = login;
    this.password = password;
    this.company = company;
    this.role = role;
  }

  /**
   * User constructor
   * 
   * @param identifier User identifier from database
   * @param code User code
   * @param name User name
   * @param dtCreation User creation date
   * @param dtLastUpdate User last update date
   * @param login User login
   * @param password User password
   */
  public User(int identifier, String code, String name, DateTime dtCreation, DateTime dtLastUpdate,
      boolean enabled, String login, String password) {
    super();
    this.identifier = identifier;
    this.code = code;
    this.name = name;
    this.dtCreation = dtCreation;
    this.dtLastUpdate = dtLastUpdate;
    this.enabled = enabled;
    this.login = login;
    this.password = password;
  }

  /**
   * @return the login
   */
  public String getLogin() {
    return login;
  }

  /**
   * @param login the login to set
   */
  public void setLogin(String login) {
    this.login = login;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(Role role) {
    this.role = role;
  }

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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "User [login=" + login + ", password=" + password + ", role=" + role + ", company="
        + company + ", identification=" + identifier + ", code=" + code + ", name=" + name
        + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate + ", enabled=" + enabled
        + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((company == null) ? 0 : company.hashCode());
    result = prime * result + ((login == null) ? 0 : login.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((role == null) ? 0 : role.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (!(obj instanceof User))
      return false;
    User other = (User) obj;
    if (company == null) {
      if (other.company != null)
        return false;
    } else if (!company.equals(other.company))
      return false;
    if (login == null) {
      if (other.login != null)
        return false;
    } else if (!login.equals(other.login))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (role == null) {
      if (other.role != null)
        return false;
    } else if (!role.equals(other.role))
      return false;
    return true;
  }
}
