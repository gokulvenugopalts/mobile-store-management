package com.mindtree.mobilestore.exception;

public class InaccessibleDatabaseException extends Exception{
	public InaccessibleDatabaseException()
	{}
	@Override
	public String toString()
	{
		return "Something went wrong. Please contact system developer.";
	}
}
