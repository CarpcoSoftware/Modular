package com.carpco.modular.dao.bo;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.data.model.location.City;
import com.carpco.modular.data.model.location.CompanyAddress;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplCompanyAddressBOTest extends TestCase {
  
  private final CompanyAddressBO comAddressBO;
  
  private final CompanyBO companyBO;
  
  private final CityBO cityBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplCompanyAddressBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    comAddressBO = ServiceLocator.getBean(CompanyAddressBO.class);
    companyBO = ServiceLocator.getBean(CompanyBO.class);
    cityBO = ServiceLocator.getBean(CityBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplCompanyAddressBOTest.class);
  }

  public void testInsert() {
    try {
      Company company = (Company) companyBO.selectByIdentifier(2);
      City city = (City) cityBO.selectByIdentifier(2);
      CompanyAddress address = new CompanyAddress("Prueba", "123456", company, city);
      comAddressBO.insert(address);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testUpdate() {
    try {
      CompanyAddress address = (CompanyAddress) comAddressBO.selectByIdentifier(2);
      address.setEnabled(false);
      comAddressBO.update(address);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> addressSet = comAddressBO.select();
    System.out.println(addressSet.toString());
    assertTrue(addressSet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> addressSet = comAddressBO.selectAllActive();
    System.out.println(addressSet.toString());
    assertTrue(addressSet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> addressSet = comAddressBO.selectAllInactive();
    System.out.println(addressSet.toString());
    assertTrue(addressSet != null);
  }

  public void testSelectByIdentifier() {
    try {
      DefaultTableModel address = comAddressBO.selectByIdentifier(1);
      System.out.println(address.toString());
      assertTrue(address != null);
    } catch (EmptyResultDataAccessException ex) {
      System.out.println("No data to be displayed");
      assertTrue(true);
    }
  }
  
  public void testSelectByCity() {
    Set<DefaultTableModel> addressSet = comAddressBO.selectByCity(1);
    System.out.println(addressSet.toString());
    assertTrue(addressSet != null);
  }
  
  public void testSelectByCompany() {
    Set<DefaultTableModel> addressSet = comAddressBO.selectByCompany(1);
    System.out.println(addressSet.toString());
    assertTrue(addressSet != null);
  }
  
  public void testSelectDefaultAddressByCompany() {
    try {
      DefaultTableModel address = comAddressBO.selectDefaultAddressByCompany(1);
      System.out.println(address.toString());
      assertTrue(address != null);
    } catch (EmptyResultDataAccessException ex) {
      System.out.println("No data to be displayed");
      assertTrue(true);
    }
  }
}
