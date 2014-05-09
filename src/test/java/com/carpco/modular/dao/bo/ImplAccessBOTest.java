package com.carpco.modular.dao.bo;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Access;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplAccessBOTest extends TestCase {
  
  private final AccessBO accessBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplAccessBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    accessBO = ServiceLocator.getBean(AccessBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplAccessBOTest.class);
  }

  public void testInsert() {
    try {
      Access access = new Access("PR", "Prueba");
      accessBO.insert(access);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testUpdate() {
    try {
      Access access = (Access) accessBO.selectByIdentifier(2);
      accessBO.update(access);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> accessSet = accessBO.select();
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> accessSet = accessBO.selectAllActive();
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> accessSet = accessBO.selectAllInactive();
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }

  public void testSelectByIdentifier() {
    DefaultTableModel access = accessBO.selectByIdentifier(1);
    System.out.println(access.toString());
    assertTrue(access != null);
  }
  
  public void testSelectByRole() {
    Set<DefaultTableModel> accessSet = accessBO.selectByRole(1);
    System.out.println(accessSet.toString());
    assertTrue(accessSet != null);
  }
}
