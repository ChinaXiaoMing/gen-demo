package com.person.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.person.gen")
public class GenApplication {

  public static void main(String[] args) {
    SpringApplication.run(GenApplication.class, args);
  }

}
