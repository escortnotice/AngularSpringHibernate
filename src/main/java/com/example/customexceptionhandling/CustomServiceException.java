package com.example.customexceptionhandling;

public class CustomServiceException extends CustomBaseException{

	private static final long serialVersionUID = 1L;

	public CustomServiceException() {
		super();
	}

	public CustomServiceException(String message) {
		super(message);
	}

	public CustomServiceException(Throwable cause) {
		super(cause);
	}

	public CustomServiceException(String message, Throwable cause) {
		super(message , cause);
	}
}
