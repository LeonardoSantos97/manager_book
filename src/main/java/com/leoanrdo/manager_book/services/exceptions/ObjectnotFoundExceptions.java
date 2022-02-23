package com.leoanrdo.manager_book.services.exceptions;

public class ObjectnotFoundExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectnotFoundExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectnotFoundExceptions(String message) {
		super(message);
	}

}
