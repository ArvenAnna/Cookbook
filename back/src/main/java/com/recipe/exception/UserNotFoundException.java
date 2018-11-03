package com.recipe.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Errors error) {
		super(error.getCause());
	}
}
