package com.mindtree.mobilestore.exception;

public class NoDataException extends Exception{
	public NoDataException()
	{}
	public String toString()
	{
		return "No Data Found for search specification. Please try another value.";
	}
}
