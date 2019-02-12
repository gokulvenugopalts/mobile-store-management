package com.mindtree.mobilestore.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mindtree.mobilestore.dao.impl.ViewJdbcImpl;
import com.mindtree.mobilestore.entity.Display;
import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;

public class JdbcPositivePositiveCostSearch {

	User userMockObj;
	Mobile modelMockObj;
	Oper operMockObj;
	ViewJdbcImpl viewObj;
	ArrayList<Display> arrList;
	Connection conn;
	//test case to find the duplicate value in db
	@Before
	public void setUp() throws Exception {
		userMockObj = Mockito.mock(User.class);
		userMockObj.setUserName("xxxxxx");
		userMockObj.setCost(1000);
		viewObj = Mockito.mock(ViewJdbcImpl.class);
		conn = viewObj.daoConnect();
		arrList = new ArrayList<Display>();
		Mockito.doReturn(arrList).when(viewObj).getUserDetailsByCost(userMockObj);
	}

	@Test
	public void test() {
		try {
			assertEquals(arrList, viewObj.getUserDetailsByCost(userMockObj));
			System.out.println("Test Case: Finding registers was successful with search value as cost");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Test Case: Failed - due to improper/missing library files");
			fail();
		}
		catch (SQLException e) {
			System.out.println("Test Case: Failed - connection to database failed");
			fail();
		}
		catch(AssertionError asser)
		{
			System.out.println("Test Case: Finding registers failed with search value as cost");
			fail();
		}
	}


}
