package com.form3.payments.config;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(SWAGGER_2)
        .apiInfo(
            new ApiInfo(
                "Demo Payments API",
                "Sample API to create, update and delete payments",
                "latest",
                "",
                new Contact("Darren O'Connor", "", "darrenoc3@gmail.com"),
                "",
                "",
                Lists.newArrayList())
        )
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.form3.payments"))
        .paths(PathSelectors.any())
        .build();
  }

}