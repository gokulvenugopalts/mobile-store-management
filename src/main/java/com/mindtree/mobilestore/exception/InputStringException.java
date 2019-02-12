package com.mindtree.mobilestore.exception;

public class InputStringException extends Exception{
	public InputStringException()
	{}
	@Override
	public String toString()
	{
		return "Please enter characters in the input field";
	}
}
