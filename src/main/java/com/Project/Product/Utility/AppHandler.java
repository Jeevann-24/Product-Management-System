package com.Project.Product.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.Product.Exception.ProductNotFoundById;

@ControllerAdvice
@ResponseBody
public class AppHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructureUser> errorStructure (ProductNotFoundById es){

		ErrorStructureUser<String> errorStructure=new  ErrorStructureUser<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorData(es.getMessage());
		errorStructure.setErrorData("Product With This Id Is Out Of Stock !!!");
		return new ResponseEntity< ErrorStructureUser>(errorStructure,HttpStatus.NOT_FOUND) ;
	}
}
