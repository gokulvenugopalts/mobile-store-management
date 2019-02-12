package com.mindtree.mobilestore.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.CommunicationException;

import com.mindtree.mobilestore.annotations.ClassDescriptionAnnotation;
import com.mindtree.mobilestore.annotations.MethodDescription;
import com.mindtree.mobilestore.dao.IEnterJdbc;
import com.mindtree.mobilestore.dao.impl.EnterJdbcImpl;
import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;
import com.mindtree.mobilestore.exception.ClassException;
import com.mindtree.mobilestore.exception.InaccessibleDatabaseException;
import com.mindtree.mobilestore.exception.InputNumberException;
import com.mindtree.mobilestore.service.IEnterService;
@ClassDescriptionAnnotation(classDesc="Class to register user details in db")
public class EnterServiceImpl implements IEnterService{
	@MethodDescription(methodDesc="Method used to send input values and check whether it is registered in db or not")
	public String enterService(User user, Mobile mobObj)
	{
		IEnterJdbc enterObj = new EnterJdbcImpl();
		try {
			if(enterObj.enterJdbc(mobObj) == 1)
			{
				if(enterObj.enterJdbc(user, mobObj) == 1)
				{
					return "Registeration of customer("+user.getUserName()+") is successful";
				}
				else
				{
					throw new InaccessibleDatabaseException();
				}
			}
			else
			{
				throw new InaccessibleDatabaseException();
			}
		} catch (ClassNotFoundException classExp) {
			/*classExp.printStackTrace();*/
			return classExp.toString();
		}
		catch(SQLException sqlExp)
		{
			/*sqlExp.printStackTrace();*/
			return sqlExp.toString();
		}
		catch(InaccessibleDatabaseException inDbExp)
		{
			/*inDbExp.printStackTrace();*/
			return inDbExp.toString();
		}
	}
	
	@MethodDescription(methodDesc="Method to get the operating system")
	public String getOperList()
	{
		IEnterJdbc enterObj = new EnterJdbcImpl();
		String operList="0:Select an operating system-";
		ArrayList<Oper> operArr = new ArrayList<Oper>();
		try {
			operArr = enterObj.getOperList();
			for(int i=0;i<operArr.size();i++)
			{
				operList+=operArr.get(i).getOperId()+":"+operArr.get(i).getOperName()+"-";
			}
			
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
			/*sqlExp.printStackTrace();*/
			try
			{
				throw new InaccessibleDatabaseException();
			}
			catch(InaccessibleDatabaseException inExp)
			{
				return inExp.toString();
			}
		}

		return operList;
	}
}
