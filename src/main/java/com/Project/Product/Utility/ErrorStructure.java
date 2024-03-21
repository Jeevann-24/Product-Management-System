package com.Project.Product.Utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure{

		private int statuscode;
		private String errormessage;
		private Object errordata;
		
		
		public int getStatuscode() {
			return statuscode;
		}
		public ErrorStructure setStatuscode(int statuscode) {
			this.statuscode = statuscode;
			return this;
		}
		public String getErrormessage() {
			return errormessage;
		}
		public ErrorStructure setErrormessage(String errormessage) {
			this.errormessage = errormessage;
			return this;
		}
		public Object getErrordata() {
			return errordata;
		}
		public ErrorStructure setErrordata(Object errordata) {
			this.errordata = errordata;
			return this;
		}
}
