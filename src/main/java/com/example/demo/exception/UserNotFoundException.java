package com.example.demo.exception;

public class UserNotFoundException extends UserException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
