package com.bridgelabz.Bookstore.exception;

public class UserDataException extends RuntimeException{
	
	public enum ExceptionTypes {
	   	 EMAIL_NOT_FOUND,
	   	 PASSWORD_NOT_FOUND,
	   	 EMAIL_INVALID,
	   	 USER_NOT_FOUND,
	   	USER_ALREADY_PRESENT
	   }
		
		public ExceptionTypes exceptionTypes;

	    public UserDataException(ExceptionTypes exceptionTypes) {
	        this.exceptionTypes = exceptionTypes;
	    }
	    
		public UserDataException(String message,UserDataException.ExceptionTypes exceptionTypes ) {
			super(message);
	    	this.exceptionTypes = exceptionTypes;
		}
}
