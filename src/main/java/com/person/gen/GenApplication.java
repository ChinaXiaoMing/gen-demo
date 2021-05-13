package com.person.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动类
 *
 * @author xiaoming
 * @date 2021/05/14
 */
@SpringBootApplication(scanBasePackages = "com.person.gen")
public class GenApplication {

  public static void main(String[] args) {
    SpringApplication.run(GenApplication.class, args);
  }

}
