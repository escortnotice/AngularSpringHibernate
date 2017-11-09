package com.example.customexceptionhandling;

public class CustomDaoException extends CustomBaseException{

	private static final long serialVersionUID = 1L;

	public CustomDaoException() {
		super();
	}

	public CustomDaoException(String message) {
		super(message);
	}

	public CustomDaoException(Throwable cause) {
		super(cause);
	}

	public CustomDaoException(String message, Throwable cause) {
		super(message , cause);
	}
	
	
}
