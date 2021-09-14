package com.ibm.training.spring.boot.jpa.configuration;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.ibm.training.spring.boot.jpa"))
				.build()
				.apiInfo(apiInfo());
	}
	
	@Bean 
	public ApiInfo apiInfo() {
		return new ApiInfo("Spring Boot JPA", "Application demonstrating usage of JPA repository in Spring Boot", "v1", null, null, null, null, Collections.EMPTY_LIST);
	}

}
