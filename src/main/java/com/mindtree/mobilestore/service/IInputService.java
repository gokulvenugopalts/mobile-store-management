package com.mindtree.mobilestore.service;

public interface IInputService {
	public int checkIntValue(String s);
	public Double checkDoubleValue(String s);
	public String checkStringValue(String s);
	public String checkStringValue(String s, String regex);
}
