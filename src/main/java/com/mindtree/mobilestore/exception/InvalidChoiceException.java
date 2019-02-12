package com.mindtree.mobilestore.exception;

public class InvalidChoiceException extends Exception{
	public InvalidChoiceException()
	{}
	public String toString()
	{
		return "Invalid Choice. Please enter again.";
	}
}
