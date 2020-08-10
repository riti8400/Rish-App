package com.virtusa.springapi.controller;

public class HttpResponseErrorException extends RuntimeException{

	public HttpResponseErrorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpResponseErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HttpResponseErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HttpResponseErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HttpResponseErrorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
