package com.Project.Product.Utility;

public class ErrorStructureUser <T>{
	
	private int statusCode;
	private String errorMessage;
	private String errorData;
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorData() {
		return errorData;
	}
	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}
	
	

}
