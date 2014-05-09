package com.carpco.modular.dao.bo;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.data.model.administration.Role;
import com.carpco.modular.data.model.administration.User;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplUserBOTest extends TestCase {

  private final UserBO userBO;
  
  private final CompanyBO companyBO;
  
  private final RoleBO roleBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplUserBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    userBO = ServiceLocator.getBean(UserBO.class);
    companyBO = ServiceLocator.getBean(CompanyBO.class);
    roleBO = ServiceLocator.getBean(RoleBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplUserBOTest.class);
  }

  public void testInsert() {
    try {
      Company company = (Company) companyBO.selectByIdentifier(1);
      Role role = (Role) roleBO.selectByIdentifier(1);
      User user = new User("CARP", "Prueba", "prueba", "prueba", company, role);
      userBO.insert(user);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testUpdate() {
    try {
      User user = (User) userBO.selectByIdentifier(2);
      user.setEnabled(false);
      userBO.update(user);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> userSet = userBO.select();
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> userSet = userBO.selectAllActive();
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> userSet = userBO.selectAllInactive();
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }

  public void testSelectByIdentifier() {
    User user = (User) userBO.selectByIdentifier(1);
    System.out.println(user.toString());
    assertTrue(user != null);
  }

  public void testSelectByLoginPassword() {
    DefaultTableModel user = userBO.selectByLoginPassword("cpatino", "Modular020486");
    System.out.println(user.toString());
    assertTrue(user != null);
  }

  public void testSelectByCompany() {
    Set<DefaultTableModel> userSet = userBO.selectByCompany(1);
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }

  public void testSelectByRole() {
    Set<DefaultTableModel> userSet = userBO.selectByRole(1);
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }
}
