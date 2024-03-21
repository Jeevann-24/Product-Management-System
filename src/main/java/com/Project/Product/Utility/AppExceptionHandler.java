package com.Project.Product.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Project.Product.Entity.User;




@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	private ErrorStructure structure;
	
	public AppExceptionHandler(ErrorStructure structure) {
		super();
		this.structure = structure;
	}


    @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatusCode status, WebRequest request) {
		// super.handleMethodArgumentNotValid(ex, headers, status, request);
		
		List<ObjectError> errors = ex.getAllErrors();
//		List<String> messages= new ArrayList<String>(); LIST
		Map<String, String>messages=new HashMap<String, String>(); //MAP
		
		errors.forEach(error-> {
			messages.put(((FieldError) error).getField(),error.getDefaultMessage());
		});
	return ResponseEntity.badRequest().body(structure.setStatuscode(HttpStatus.BAD_REQUEST.value())
					.setErrormessage("Invalid / Error")
					.setErrordata(messages));
	}
	
}
