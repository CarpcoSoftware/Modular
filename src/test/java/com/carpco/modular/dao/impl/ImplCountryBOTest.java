package com.carpco.modular.dao.impl;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.carpco.modular.dao.bo.CountryBO;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.location.Country;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplCountryBOTest extends TestCase {
  
  private static CountryBO countryBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplCountryBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    countryBO = ServiceLocator.getBean(CountryBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplCountryBOTest.class);
  }

//  public void testInsert() {
//    try {
//      Country country = new Country("PR", "Prueba");
//      countryBO.insert(country);
//      assertTrue(true);
//    } catch (DataIntegrityViolationException ex) {
//      System.out.println(ex);
//      assertTrue(false);
//    }
//  }

  public void testUpdate() {
    try {
      Country country = new Country(1, "PR", "Prueba", DateTime.now(), DateTime.now(), false);;
      countryBO.update(country);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> countrySet = countryBO.select();
    System.out.println(countrySet.toString());
    assertTrue(countrySet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> countrySet = countryBO.selectAllActive();
    System.out.println(countrySet.toString());
    assertTrue(countrySet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> countrySet = countryBO.selectAllInactive();
    System.out.println(countrySet.toString());
    assertTrue(countrySet != null);
  }

  public void testSelectByIdentifier() {
    try {
      DefaultTableModel country = countryBO.selectByIdentifier(2);
      System.out.println(country.toString());
      assertTrue(country != null);
    } catch (EmptyResultDataAccessException ex) {
      System.out.println("No data to be displayed");
      assertTrue(true);
    }
  }
}
