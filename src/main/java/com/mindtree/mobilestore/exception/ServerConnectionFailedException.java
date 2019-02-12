package com.mindtree.mobilestore.exception;

public class ServerConnectionFailedException extends Exception{
	public ServerConnectionFailedException()
	{}
	public String toString()
	{
		return "Something went wrong while connecting to the Server. Please Try After Sometime.";
	}
}
