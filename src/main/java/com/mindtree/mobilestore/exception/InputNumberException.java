package com.mindtree.mobilestore.exception;

public class InputNumberException extends Exception{
	public InputNumberException()
	{}
	@Override
	public String toString()
	{
		return "Please enter a number value in the input field";
	}
}
