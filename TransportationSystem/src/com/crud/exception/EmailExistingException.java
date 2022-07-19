package com.crud.exception;

@SuppressWarnings("serial")
public class EmailExistingException extends Exception {
	String errorMsg;
	public EmailExistingException()
	{
		this.errorMsg = "Email already taken";
	}
	public String getErrorMsg()
	{
		return this.errorMsg;
	}
}
