package com.rafwedz.ems.swagger;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

/*@Configuration
@EnableSwagger2*/
public class SwaggerConfiguration {
   /* @Bean
    public Docket emsCloneApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("EMS API")
                .version("1.0")
                .description("API for Employee Management System")
                .contact(new Contact("Rafal Wedzony", "no option", "rafal.wedzony@rafsoftrw.pl"))
                .license("Apache License Version 2.0")
                .build();
    }*/
}
