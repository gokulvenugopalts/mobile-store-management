package com.mindtree.mobilestore.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobilestore.annotations.MethodDescription;
import com.mindtree.mobilestore.dao.IViewJdbc;
import com.mindtree.mobilestore.dao.impl.ViewJdbcImpl;
import com.mindtree.mobilestore.entity.Display;
import com.mindtree.mobilestore.entity.User;
import com.mindtree.mobilestore.exception.ClassException;
import com.mindtree.mobilestore.exception.DuplicateRecordsException;
import com.mindtree.mobilestore.exception.InaccessibleDatabaseException;
import com.mindtree.mobilestore.exception.NoDataException;
import com.mindtree.mobilestore.service.IViewService;

public class ViewServiceImpl implements IViewService{
	ArrayList<Display> dispArr;
	@MethodDescription(methodDesc="Method to fetch the unique register list and if there is not then exception is thrown")
	public String viewService(User user)
	{
		System.out.println(user.getCost());
		System.out.println(user.getUserName());
		String res="";
		dispArr = new ArrayList<Display>();
		IViewJdbc viewObj = new ViewJdbcImpl();
		try {
/*			if(viewObj.dupicateNameCheck(user) == 1)
			{
				if(viewObj.duplicateCostCheck(user) == 1)
				{*/
					dispArr = viewObj.getUserDetailsUnique(user);
					if (dispArr.isEmpty()) 
					{
						throw new NoDataException();
					} 
					else
					{
						if(dispArr.size()>1)
						{
							throw new DuplicateRecordsException();
						}
						else
						{
							for(int i =0;i<dispArr.size();i++)
							{
								res+=dispArr.get(i).getUser().getUserName()+":"+
										dispArr.get(i).getMobObj().getModelName()+":"+
										dispArr.get(i).getOperObj().getOperName()+":"+
										dispArr.get(i).getUser().getCost()+"-";
							}
							return res;
						}
					}
/*				}
				else
					throw new DuplicateCostException();
			}
			else
			{
				throw new DuplicateNameException();
			}*/
		}	
		catch (ClassNotFoundException classExp) {
			try
			{
				throw new ClassException();
			}
			catch(ClassException inExp)
			{
				return (inExp.toString());
			}
		}
		catch(SQLException sqlExp)
		{
			try
			{
				throw new InaccessibleDatabaseException();
			}
			catch(InaccessibleDatabaseException inExp)
			{
				return (inExp.toString());
			}
		}
		catch(NoDataException noObj)
		{
			return noObj.toString();
		}
		catch(DuplicateRecordsException e)
		{
			return e.toString();
		}
/*		catch(DuplicateNameException dupExp)
		{
			dupExp.printStackTrace();
			return (dupExp.toString());
		}
		catch(DuplicateCostException dupCostExp)
		{
			dupCostExp.printStackTrace();
			return (dupCostExp.toString());
		}*/
	}
	@MethodDescription(methodDesc="Method to retrieve register list according to the input name")
	public String viewServiceByName(User user)
	{
		String res="";
		dispArr = new ArrayList<Display>();
		IViewJdbc viewObj = new ViewJdbcImpl();
		try {
/*			if(viewObj.dupicateNameCheck(user) == 1)
			{*/
				dispArr = viewObj.getUserDetails(user);
				if (dispArr.isEmpty()) 
				{
					throw new NoDataException();
				} 
				else
				{
						for(int i =0;i<dispArr.size();i++)
						{
							res+=dispArr.get(i).getUser().getUserName()+":"+
									dispArr.get(i).getMobObj().getModelName()+":"+
									dispArr.get(i).getOperObj().getOperName()+":"+
									dispArr.get(i).getUser().getCost()+"-";
						}
						return res;
				}
/*			}
			else
			{
				throw new DuplicateNameException();
			}*/
		}	
		catch (ClassNotFoundException classExp) {
			try
			{
				throw new ClassException();
			}
			catch(ClassException inExp)
			{
				return (inExp.toString());
			}
		}
		catch(SQLException sqlExp)
		{
			try
			{
				throw new InaccessibleDatabaseException();
			}
			catch(InaccessibleDatabaseException inExp)
			{
				return (inExp.toString());
			}
		}
		catch(NoDataException inDbExp)
		{
			/*inDbExp.printStackTrace();*/
			return inDbExp.toString();
		}
/*		catch(DuplicateNameException dupExp)
		{
			dupExp.printStackTrace();
			System.out.println(dupExp.toString());
		}*/
	}
	@MethodDescription(methodDesc="Method to retrieve register list according to the input cost")
	public String viewServiceByCost(User user)
	{
		String res="";
		dispArr = new ArrayList<Display>();
		IViewJdbc viewObj = new ViewJdbcImpl();
		try {
/*			if(viewObj.duplicateCostCheck(user) == 1)
			{*/
				dispArr = viewObj.getUserDetailsByCost(user);
				if (dispArr.isEmpty()) 
				{
					throw new NoDataException();
				} 
				else
				{
						for(int i =0;i<dispArr.size();i++)
						{
							res+=dispArr.get(i).getUser().getUserName()+":"+
									dispArr.get(i).getMobObj().getModelName()+":"+
									dispArr.get(i).getOperObj().getOperName()+":"+
									dispArr.get(i).getUser().getCost()+"-";
						}
						return res;
				}
/*			}
			else
				throw new DuplicateCostException();*/
		}	
		catch (ClassNotFoundException classExp) {
			try
			{
				throw new ClassException();
			}
			catch(ClassException inExp)
			{
				return inExp.toString();
			}
		}
		catch(SQLException sqlExp)
		{
			try
			{
				throw new InaccessibleDatabaseException();
			}
			catch(InaccessibleDatabaseException inExp)
			{
				return inExp.toString();
			}
		}
		catch(NoDataException inDbExp)
		{
			/*inDbExp.printStackTrace();*/
			return inDbExp.toString();
		}
/*		catch(DuplicateCostException dupCostExp)
		{
			dupCostExp.printStackTrace();
			System.out.println(dupCostExp.toString());
		}*/
	}
}
