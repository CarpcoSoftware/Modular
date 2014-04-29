package com.carpco.modular.dao.impl;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.dao.IUserDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.data.model.administration.Role;
import com.carpco.modular.data.model.administration.User;

/**
 * Unit test for simple App.
 */
public class ImplUserDAOTest extends TestCase {
  
  private final ApplicationContext context;
  
  private final IUserDao userDAO;
  
  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplUserDAOTest(String testName) {
    super(testName);
    context = new ClassPathXmlApplicationContext("spring-bean/Spring-Module.xml");
    userDAO = (IUserDao) context.getBean("userDAO");;
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplUserDAOTest.class);
  }
  
//  public void testInsert() {
//    try {
//      Company company = new Company(1, "", "", DateTime.now(), DateTime.now(), true, ""); 
//      Role role = new Role(1, "SUPER", "Super user", DateTime.now(), DateTime.now(), true);
//      User user = new User("CARP", "Prueba", "prueba", "prueba", company, role);
//      userDAO.insert(user);
//      assertTrue(true);
//    } catch (UncategorizedSQLException ex) {
//      System.out.println(ex);
//      assertTrue(false);
//    }
//  }
  
  public void testUpdate() {
    try {
      Company company = new Company(1, "", "", DateTime.now(), DateTime.now(), true, ""); 
      Role role = new Role(1, "SUPER", "Super user", DateTime.now(), DateTime.now(), true);
      User user = new User("CARP", "Prueba", "prueba", "prueba", company, role);
      user.setIdentifier(2);
      user.setEnabled(false);
      userDAO.update(user);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> userSet = userDAO.select();
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }
  
  public void testSelectAllActive() {
    Set<DefaultTableModel> userSet = userDAO.selectAllActive();
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }
  
  public void testSelectAllInactive() {
    Set<DefaultTableModel> userSet = userDAO.selectAllInactive();
    System.out.println(userSet.toString());
    assertTrue(userSet != null);
  }
  
  public void testSelectByIdentifier() {
    User user = (User) userDAO.selectByIdentifier(1);
    System.out.println(user.toString());
    assertTrue(user != null);
  }
  
  public void testSelectByLoginPassword() {
    User user = userDAO.selectByLoginPassword("cpatino", "Modular020486");
    System.out.println(user.toString());
    assertTrue(user != null);
  }
}
