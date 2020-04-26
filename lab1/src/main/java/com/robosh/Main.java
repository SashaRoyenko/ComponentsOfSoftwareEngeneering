package com.robosh;

import com.robosh.view.SmartphoneView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    // Xiaomi 8 2.0 4 6.1 64 167 true
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
    SmartphoneView view = ctx.getBean("smartphoneView", SmartphoneView.class);
    view.render();
  }
}
