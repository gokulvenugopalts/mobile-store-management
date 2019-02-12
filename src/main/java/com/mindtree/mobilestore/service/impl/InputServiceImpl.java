package com.mindtree.mobilestore.service.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindtree.mobilestore.annotations.MethodDescription;
import com.mindtree.mobilestore.exception.InputNumberException;
import com.mindtree.mobilestore.exception.InputStringException;
import com.mindtree.mobilestore.service.IInputService;

public class InputServiceImpl implements IInputService{
	@MethodDescription(methodDesc="Method to check whether the input value is a number or not")
	public int checkIntValue(String s)
	{
		Scanner scn= new Scanner(System.in);
		int numb;
		System.out.println(s);
		try
		{
			numb=scn.nextInt();			
		}
		catch(InputMismatchException e)
		{
			try
			{
				throw new InputNumberException();
			}
			catch(InputNumberException inExp)
			{
				System.out.println(inExp.toString());
			}
			numb = checkIntValue(s);
		}
		return numb;
	}
	@MethodDescription(methodDesc="Method to check whether the input value is a decimal or not")
	public Double checkDoubleValue(String s)
	{
		Scanner scn= new Scanner(System.in);
		double numb;
		System.out.println(s);
		try
		{
			numb=scn.nextDouble();			
		}
		catch(InputMismatchException e)
		{
			try
			{
				throw new InputNumberException();
			}
			catch(InputNumberException inExp)
			{
				System.out.println(inExp.toString());
			}
			numb = checkIntValue(s);
		}
		return numb;
	}
	public String checkStringValue(String s)
	{
		Scanner scn= new Scanner(System.in);
		String value;
		System.out.println(s);
		try
		{
			value = scn.nextLine();	
			if(value.equals("") || value.length()==0)
				throw new InputStringException();
		}
			catch(InputStringException inExp)
			{
				System.out.println(inExp.toString());
				value = checkStringValue(s);
			}
		return value;
	}
	@MethodDescription(methodDesc="Method to check whether the input string matches an expression or not")
	public String checkStringValue(String s, String regex)
	{
		Scanner scn= new Scanner(System.in);
		String value;
		System.out.println(s);
		try
		{
			value = scn.nextLine();	
				if(!value.matches(regex))
					throw new InputStringException();
		}
			catch(InputStringException inExp)
			{
				System.out.println(inExp.toString());
				value = checkStringValue(s);
			}
		return value;
	} 
}
