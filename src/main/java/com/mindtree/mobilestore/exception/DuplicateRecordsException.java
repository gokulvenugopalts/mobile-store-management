package com.mindtree.mobilestore.exception;

public class DuplicateRecordsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DuplicateRecordsException()
	{}
	public String toString()
	{
		return "There are duplicate entries with same user name and cost.";
	}
}
