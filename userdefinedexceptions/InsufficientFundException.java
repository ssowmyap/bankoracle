package com.capg.Banking.userdefinedexceptions;

public class InsufficientFundException extends Exception {
	public InsufficientFundException() {
		System.out.println("insufficient funds");
	}
}
