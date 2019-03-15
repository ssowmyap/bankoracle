package com.capg.Banking.userdefinedexceptions;

public class InvalidToAccountException extends Exception {
	public InvalidToAccountException() {
		System.out.println("ToAccountNo is invalid ");
	}
}
