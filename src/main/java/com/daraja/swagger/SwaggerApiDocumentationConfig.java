package com.daraja.swagger;

import javax.print.Doc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerApiDocumentationConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("M-Pesa Daraja API")
        .description("M-Pesa Daraja API")
        .build();
  }

  @Bean
  public Docket configurationController() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.daraja"))
        .build()
        .apiInfo(apiInfo());
  }

}
