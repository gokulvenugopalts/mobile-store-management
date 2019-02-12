package com.mindtree.mobilestore.exception;

public class SqlMissingException extends Exception{
	public SqlMissingException()
	{}
	@Override
	public String toString()
	{
		return "There has been an error while accessing database."
				+ " Please verify the operational status of Sql Command Line";
	}
}
