package com.carpco.modular.dao.bo;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplCompanyBOTest extends TestCase {

  private final CompanyBO companyBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplCompanyBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    companyBO = ServiceLocator.getBean(CompanyBO.class);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplCompanyBOTest.class);
  }

  public void testInsert() {
    try {
      Company company = new Company("PR", "Prueba", "Prueba");
      companyBO.insert(company);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testUpdate() {
    try {
      Company company = (Company) companyBO.selectByIdentifier(2);
      company.setEnabled(false);
      companyBO.update(company);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> companySet = companyBO.select();
    System.out.println(companySet.toString());
    assertTrue(companySet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> companySet = companyBO.selectAllActive();
    System.out.println(companySet.toString());
    assertTrue(companySet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> companySet = companyBO.selectAllInactive();
    System.out.println(companySet.toString());
    assertTrue(companySet != null);
  }

  public void testSelectByIdentifier() {
    Company company = (Company) companyBO.selectByIdentifier(1);
    System.out.println(company.toString());
    assertTrue(company != null);
  }

  public void testSelectByName() {
    Company company = (Company) companyBO.selectByName("CARPCO SOFTWARE");
    System.out.println(company.toString());
    assertTrue(company != null);
  }
}
