package com.robosh.config;

import com.robosh.dao.SmartphoneDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public SmartphoneDao getSmartphoneDao() {
    return new SmartphoneDao();
  }
}
