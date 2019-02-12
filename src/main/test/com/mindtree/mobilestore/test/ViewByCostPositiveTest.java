package com.mindtree.mobilestore.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;
import com.mindtree.mobilestore.service.impl.ViewServiceImpl;

public class ViewByCostPositiveTest {

	User userMockObj;
	Mobile modelMockObj;
	Oper operMockObj;
	ViewServiceImpl viewObj;
	Connection conn;
	String res;
	//test case to find the duplicate cost value in db
	@Before
	public void setUp() throws Exception {
		userMockObj = Mockito.mock(User.class);
		modelMockObj = Mockito.mock(Mobile.class);
		operMockObj = Mockito.mock(Oper.class);
		userMockObj.setUserName("abc");
		userMockObj.setCost(5000);
		modelMockObj.setModelName("Samsung");
		operMockObj.setOperId(1);
		modelMockObj.setOperId(operMockObj);
		viewObj = Mockito.mock(ViewServiceImpl.class);
		res="abc:5000:Android:Samsung-";
		Mockito.when(viewObj.viewServiceByCost(userMockObj)).thenReturn(res);
	}

	@Test
	public void test() {
		try {
			assertEquals(viewObj.viewServiceByCost(userMockObj),res);
			System.out.println("Test Case: Finding duplicate cost value for the user in database is successful");
		} catch(AssertionError asser)
		{
			System.out.println("Finding duplicate cost value for the user in database failed");
			fail();
		}
	}

}
