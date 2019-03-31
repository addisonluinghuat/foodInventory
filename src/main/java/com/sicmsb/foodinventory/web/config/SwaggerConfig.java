package com.sicmsb.foodinventory.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.api.info.title}")
	private String title;

	@Value("${swagger.api.info.description}")
	private String description;

	@Value("${swagger.api.info.version}")
	private String version;

	@Value("${swagger.api.info.termsOfServiceUrl}")
	private String termsOfServiceUrl;

	@Value("${swagger.api.info.contact.name}")
	private String name;

	@Value("${swagger.api.info.contact.url}")
	private String url;

	@Value("${swagger.api.info.contact.email}")
	private String email;

	@Value("${swagger.api.info.license}")
	private String license;

	@Value("${swagger.api.info.licenseUrl}")
	private String licenseUrl;

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// .select().apis(RequestHandlerSelectors.basePackage("com.example.demo.web.controller.ProductController"))
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, new Contact(name, url, email),
				license, licenseUrl);
		return apiInfo;
	}
}