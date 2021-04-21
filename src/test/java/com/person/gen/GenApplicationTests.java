package com.person.gen;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

@SpringBootTest
class GenApplicationTests {

  @Test
  void contextLoads() throws FileNotFoundException {
    System.out.println(ResourceUtils.getFile("classpath:templates").getName());
  }

}
