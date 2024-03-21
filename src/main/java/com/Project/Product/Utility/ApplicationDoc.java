package com.Project.Product.Utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {

	@Bean
	io.swagger.v3.oas.models.info.Info info(){
		return new io.swagger.v3.oas.models.info.Info().title("Product Management System")
				.description("RESTfull API with basic CRUD Operation")
				.version("v1")
				.contact(contact());
	}
	 @Bean
	OpenAPI openapi() {
		return new OpenAPI().info(info());
		
	}
	 
//	 CONTACT
	 Contact contact() {
		return new Contact().email("jeevangowda2410@gmail.com")
				.name("Jeevan Gowda")
				.url("https://www.instagram.com/jeevann_24?igsh=eXppN280bjJ3MXJ1&utm_source=qr");
		 
	 }
	
}
