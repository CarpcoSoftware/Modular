package com.carpco.modular.dao.impl;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.carpco.modular.dao.bo.StateBO;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.location.Country;
import com.carpco.modular.data.model.location.State;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplStateBOTest extends TestCase {
  
  private static StateBO stateBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplStateBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    stateBO = ServiceLocator.getBean(StateBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplStateBOTest.class);
  }

//  public void testInsert() {
//    try {
//      Country country = new Country(1, "PR", "Prueba", DateTime.now(), DateTime.now(), false);
//      State state = new State("PR", "Prueba", country);
//      stateBO.insert(state);
//      assertTrue(true);
//    } catch (DataIntegrityViolationException ex) {
//      System.out.println(ex);
//      assertTrue(false);
//    }
//  }

  public void testUpdate() {
    try {
      Country country = new Country(1, "PR", "Prueba", DateTime.now(), DateTime.now(), false);
      State state = new State(2, "PR", "Prueba", DateTime.now(), DateTime.now(), false, country);
      stateBO.update(state);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> stateSet = stateBO.select();
    System.out.println(stateSet.toString());
    assertTrue(stateSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> stateSet = stateBO.selectAllActive();
    System.out.println(stateSet.toString());
    assertTrue(stateSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> stateSet = stateBO.selectAllInactive();
    System.out.println(stateSet.toString());
    assertTrue(stateSet != null);
  }

  public void testSelectByIdentifier() {
    try {
      DefaultTableModel state = stateBO.selectByIdentifier(1);
      System.out.println(state.toString());
      assertTrue(state != null);
    } catch (EmptyResultDataAccessException ex) {
      System.out.println("No data to be displayed");
      assertTrue(true);
    }
  }
  
  public void testSelectByCountry() {
    Set<DefaultTableModel> stateSet = stateBO.selectByCountry(1);
    System.out.println(stateSet.toString());
    assertTrue(stateSet != null);
  }
}
