package com.carpco.modular.dao.impl;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.carpco.modular.dao.ICompanyDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;

/**
 * Unit test for simple App.
 */
public class ImplCompanyDAOTest extends TestCase {

  private final ApplicationContext context;

  private final ICompanyDao companyDAO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplCompanyDAOTest(String testName) {
    super(testName);
    context = new ClassPathXmlApplicationContext("spring-bean/Spring-Module.xml");
    companyDAO = (ICompanyDao) context.getBean("companyDAO");;
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplCompanyDAOTest.class);
  }

  // public void testInsert() {
  // try {
  // Company company = new Company("PR", "Prueba", "Prueba");
  // companyDAO.insert(company);
  // assertTrue(true);
  // } catch (DataIntegrityViolationException ex) {
  // System.out.println(ex);
  // assertTrue(false);
  // }
  // }

  public void testUpdate() {
    try {
      Company company =
          new Company(2, "PR", "Prueba", DateTime.now(), DateTime.now(), false, "Prueba");;
      companyDAO.update(company);
      assertTrue(true);
    } catch (DataIntegrityViolationException ex) {
      System.out.println(ex);
      assertTrue(false);
    }
  }

  public void testSelect() {
    Set<DefaultTableModel> companySet = companyDAO.select();
    System.out.println(companySet.toString());
    assertTrue(companySet != null);
  }

  public void testSelectAllActive() {
    Set<DefaultTableModel> companySet = companyDAO.selectAllActive();
    System.out.println(companySet.toString());
    assertTrue(companySet != null);
  }

  public void testSelectAllInactive() {
    Set<DefaultTableModel> companySet = companyDAO.selectAllInactive();
    System.out.println(companySet.toString());
    assertTrue(companySet != null);
  }

  public void testSelectByIdentifier() {
    Company company = (Company) companyDAO.selectByIdentifier(1);
    System.out.println(company.toString());
    assertTrue(company != null);
  }

  public void testSelectByName() {
    Company company = (Company) companyDAO.selectByName("CARPCO SOFTWARE");
    System.out.println(company.toString());
    assertTrue(company != null);
  }
}
