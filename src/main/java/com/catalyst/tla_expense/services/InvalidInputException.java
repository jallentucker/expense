package com.catalyst.tla_expense.services;

public class InvalidInputException extends Exception {

	public InvalidInputException(String message) {
		super(message);
	}
}