package com.example.customexceptionhandling;

public class CustomBaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomBaseException() {
		super();
	}

	public CustomBaseException(String message) {
		super(message);
	}

	public CustomBaseException(Throwable cause) {
		super(cause);
	}

	public CustomBaseException(String message, Throwable cause) {
		super(message , cause);
	}
}
