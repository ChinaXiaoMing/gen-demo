package com.person.gen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置
 *
 * @author fu.yuanming
 * @since 2021-01-06
 */
@Configuration
public class SwaggerConfig {

  @Bean
  public Docket swaggerDocket() {
    ApiInfo apiInfo = new ApiInfoBuilder().title("自动代码生成接口文档").description("用于个人代码生成")
            .version("1.0.0").build();
    return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo).useDefaultResponseMessages(false)
            .select().apis(RequestHandlerSelectors.basePackage("com.person.gen")).build();
  }

}
