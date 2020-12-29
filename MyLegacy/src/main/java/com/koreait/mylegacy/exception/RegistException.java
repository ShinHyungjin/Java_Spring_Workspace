package com.koreait.mylegacy.exception;

public class RegistException extends RuntimeException{
	public RegistException(String msg) {
		super(msg);
	}
	public RegistException(String msg, Throwable e) {
		super(msg, e);
	}
	
	
	
}
