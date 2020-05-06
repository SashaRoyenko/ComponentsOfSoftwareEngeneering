package com.robosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CarWashApplication {

  //http://localhost:8090/washme/swagger-ui.html
  public static void main(String[] args) {
    SpringApplication.run(CarWashApplication.class, args);
  }

}
