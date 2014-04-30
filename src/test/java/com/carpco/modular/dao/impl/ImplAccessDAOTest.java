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
import com.carpco.modular.data.model.administration.Access;

/**
 * Unit test for simple App.
 */
public class ImplAccessDAOTest extends TestCase {

  private final ApplicationContext context;

  private final IDao accessDAO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplAccessDAOTest(String testName) {
    super(testName);
    context = new ClassPathXmlApplicationContext("spring-bean/Spring-Module.xml");
    accessDAO = (IDao) context.getBean("accessDAO");
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplAccessDAOTest.class);
  }

  // public void testInsert() {
  // try {
  // Access access = new Access("PR", "Prueba");
  // accessDAO.insert(access);
  // assertTrue(true);
  // } catch (DataIntegrityViolationException ex) {
  // System.out.println(ex);
  // assertTrue(false);
  // }
  // }

  public void testUpdate() {
    try {
      Access access = new Access(2, "PR", "Prueba", DateTime.now(), DateTime.now(), false);;
      accessDAO.update(access);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> accessSet = accessDAO.select();
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> accessSet = accessDAO.selectAllActive();
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> accessSet = accessDAO.selectAllInactive();
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }

  public void testSelectByIdentifier() {
    DefaultTableModel access = accessDAO.selectByIdentifier(1);
    System.out.println(access.toString());
    assertTrue(access != null);
  }
}
