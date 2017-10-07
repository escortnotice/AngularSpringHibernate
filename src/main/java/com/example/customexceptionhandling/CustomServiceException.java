package com.example.customexceptionhandling;

public class CustomServiceException extends CustomBaseException{

	private static final long serialVersionUID = 1L;

	public CustomServiceException() {
		super("BaseServiceException Occured");
	}

	public CustomServiceException(String message) {
		super(message);
	}

	public CustomServiceException(Throwable e) {
		super(e);
	}

	public CustomServiceException(String message, Throwable e) {
		super(message + e);
	}
}
