package com.mindtree.mobilestore.exception;

public class ClassException extends Exception{
	public ClassException()
	{}
	@Override
	public String toString()
	{
		return "Some error occured due to incorrect/missing library files. Please contact system developer.";
	}
}
