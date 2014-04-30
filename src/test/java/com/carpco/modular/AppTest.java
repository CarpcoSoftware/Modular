package com.carpco.modular;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.carpco.modular.dao.IUserDao;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.User;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
  /**
   * Create the test case
   * 
   * @param testName name of the test case
   */
  public AppTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AppTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void testApp() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("spring-bean/Spring-Module.xml");
    IUserDao userDAO = (IUserDao) context.getBean("userDAO");
    DefaultTableModel user = userDAO.selectByLoginPassword("cpatino", "Modular020486");
    if (user != null) {
      System.out.println(user.toString());
      System.out.println(((User) user).getCompany().toString());
    }
    assertTrue(user != null);
  }
}
