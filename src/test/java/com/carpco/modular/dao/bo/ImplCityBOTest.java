package com.carpco.modular.dao.bo;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.location.City;
import com.carpco.modular.data.model.location.State;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplCityBOTest extends TestCase {
  
  private final CityBO cityBO;
  
  private final StateBO stateBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplCityBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    cityBO = ServiceLocator.getBean(CityBO.class);
    stateBO = ServiceLocator.getBean(StateBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplCityBOTest.class);
  }

  public void testInsert() {
    try {
      State state = (State) stateBO.selectByIdentifier(2);
      City city = new City("PR", "Prueba", state);
      cityBO.insert(city);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testUpdate() {
    try {
      City city = (City) cityBO.selectByIdentifier(2);
      city.setEnabled(false);
      cityBO.update(city);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> citySet = cityBO.select();
    System.out.println(citySet.toString());
    assertTrue(citySet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> citySet = cityBO.selectAllActive();
    System.out.println(citySet.toString());
    assertTrue(citySet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> citySet = cityBO.selectAllInactive();
    System.out.println(citySet.toString());
    assertTrue(citySet != null);
  }

  public void testSelectByIdentifier() {
    try {
      DefaultTableModel city = cityBO.selectByIdentifier(1);
      System.out.println(city.toString());
      assertTrue(city != null);
    } catch (EmptyResultDataAccessException ex) {
      System.out.println("No data to be displayed");
      assertTrue(true);
    }
  }
  
  public void testSelectByState() {
    Set<DefaultTableModel> citySet = cityBO.selectByState(1);
    System.out.println(citySet.toString());
    assertTrue(citySet != null);
  }
}
