package com.Project.Product;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.Project.Product.Entity.Product;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
		
		 
		
//		null --> null pointer exception
//		new product --> prints iNSIDE map
		Product pro = new Product();
		Optional.of(pro).map(product->{System.out.println("Application Started !!! ");
		return product;}).orElseThrow(()->new RuntimeException());
	}

}
