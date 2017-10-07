package com.example.customexceptionhandling;

public class CustomBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String exceptionMessage = "BaseException Occurred";

	public CustomBaseException() {
	}

	public CustomBaseException(String message) {
		super(message);
		this.exceptionMessage = message;
	}

	public CustomBaseException(Throwable e) {
		super(e);
	}

	public CustomBaseException(String message, Throwable e) {
		super(message + e);
		this.exceptionMessage = message;
	}

	public String toString() {
		return getClass().getName() + ": " + exceptionMessage;
	}

	public String getMessage() {
		return exceptionMessage;
	}
}
