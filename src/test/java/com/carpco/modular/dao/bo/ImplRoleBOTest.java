package com.carpco.modular.dao.bo;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Role;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplRoleBOTest extends TestCase {

  private final RoleBO roleBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplRoleBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    roleBO = ServiceLocator.getBean(RoleBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplRoleBOTest.class);
  }

  public void testInsert() {
    try {
      Role role = new Role("PR", "Prueba");
      roleBO.insert(role);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testUpdate() {
    try {
      Role role = (Role) roleBO.selectByIdentifier(2);
      role.setEnabled(false);
      roleBO.update(role);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> roleSet = roleBO.select();
    System.out.println(roleSet.toString());
    assertTrue(roleSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> roleSet = roleBO.selectAllActive();
    System.out.println(roleSet.toString());
    assertTrue(roleSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> roleSet = roleBO.selectAllInactive();
    System.out.println(roleSet.toString());
    assertTrue(roleSet != null);
  }

  public void testSelectByIdentifier() {
    DefaultTableModel role = roleBO.selectByIdentifier(1);
    System.out.println(role.toString());
    assertTrue(role != null);
  }
}
