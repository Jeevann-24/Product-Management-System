package com.Project.Product.Exception;

public class ProductNotFoundById extends RuntimeException {

	private String message;

	public ProductNotFoundById(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
