package com.example.customexceptionhandling;

public class CustomDaoException extends CustomBaseException{

	private static final long serialVersionUID = 1L;

	public CustomDaoException() {
		super("BaseDaoException Occured");
	}

	public CustomDaoException(String message) {
		super(message);
	}

	public CustomDaoException(Throwable e) {
		super(e);
	}

	public CustomDaoException(String message, Throwable e) {
		super(message + e);
	}
	
	
}
