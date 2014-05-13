package com.carpco.modular.dao.bo.accounting;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.carpco.modular.dao.bo.CompanyBO;
import com.carpco.modular.dao.bo.ObjectTypeBO;
import com.carpco.modular.dao.impl.AbstractImplDAO;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Unit test for simple App.
 */
public class ImplObjectTypeBOTest extends TestCase {
  
  private final ObjectTypeBO objectTypeBO;
  
  private final CompanyBO companyBO;

  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public ImplObjectTypeBOTest(String testName) {
    super(testName);
    ServiceLocator.init();
    objectTypeBO = ServiceLocator.getBean(ObjectTypeBO.class);
    companyBO = ServiceLocator.getBean(CompanyBO.class);
    
    Company company = (Company) companyBO.selectByName("CARPCO SOFTWARE");
    AbstractImplDAO.setDataSourceName(company.getDbConnection());
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ImplObjectTypeBOTest.class);
  }

  public void testSelect() {
    Set<DefaultTableModel> objectTypeSet = objectTypeBO.select();
    System.out.println(objectTypeSet.toString());
    assertTrue(objectTypeSet != null);
  }
}
