package com.carpco.modular.dao.impl;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.dao.IDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Role;

/**
 * Unit test for simple App.
 */
public class ImplRoleDAOTest extends TestCase {

  private final ApplicationContext context;

  private final IDao roleDAO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplRoleDAOTest(String testName) {
    super(testName);
    context = new ClassPathXmlApplicationContext("spring-bean/Spring-Module.xml");
    roleDAO = (IDao) context.getBean("roleDAO");
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplRoleDAOTest.class);
  }

//  public void testInsert() {
//    try {
//      Role role = new Role("PR", "Prueba");
//      roleDAO.insert(role);
//      assertTrue(true);
//    } catch (DataIntegrityViolationException ex) {
//      System.out.println(ex);
//      assertTrue(false);
//    }
//  }

  public void testUpdate() {
    try {
      Role role = new Role(2, "PR", "Prueba", DateTime.now(), DateTime.now(), false);;
      roleDAO.update(role);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> roleSet = roleDAO.select();
    System.out.println(roleSet.toString());
    assertTrue(roleSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> roleSet = roleDAO.selectAllActive();
    System.out.println(roleSet.toString());
    assertTrue(roleSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> roleSet = roleDAO.selectAllInactive();
    System.out.println(roleSet.toString());
    assertTrue(roleSet != null);
  }

  public void testSelectByIdentifier() {
    DefaultTableModel role = roleDAO.selectByIdentifier(1);
    System.out.println(role.toString());
    assertTrue(role != null);
  }
}
