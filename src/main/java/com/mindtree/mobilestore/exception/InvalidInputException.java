package com.mindtree.mobilestore.exception;

public class InvalidInputException extends Exception{
	public InvalidInputException(){}
	@Override
	public String toString()
	{
		return "There is some error in input. Please provide try again.";
	}
}
