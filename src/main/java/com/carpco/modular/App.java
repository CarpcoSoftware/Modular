package com.carpco.modular;

import java.util.Set;

import com.carpco.modular.dao.bo.AccessBO;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.spring.ServiceLocator;

/**
 * Hello world!
 * 
 */
public class App {
  public static void main(String[] args) {
    ServiceLocator.init();
    AccessBO accessBO = ServiceLocator.getBean(AccessBO.class);
    Set<DefaultTableModel> accessSet = accessBO.selectByRole(1);
    System.out.print(accessSet);
    System.exit(0);
  }
}
