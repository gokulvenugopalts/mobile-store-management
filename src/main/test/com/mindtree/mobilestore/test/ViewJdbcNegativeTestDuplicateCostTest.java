package com.mindtree.mobilestore.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mindtree.mobilestore.dao.impl.ViewJdbcImpl;
import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;

public class ViewJdbcNegativeTestDuplicateCostTest {

	User userMockObj;
	Mobile modelMockObj;
	Oper operMockObj;
	ViewJdbcImpl viewObj;
	Connection conn;
	//test case to find the duplicate cost value in db
	@Before
	public void setUp() throws Exception {
		userMockObj = Mockito.mock(User.class);
		modelMockObj = Mockito.mock(Mobile.class);
		operMockObj = Mockito.mock(Oper.class);
		userMockObj.setUserName("abc");
		userMockObj.setCost(500000);
		modelMockObj.setModelName("Samsung");
		operMockObj.setOperId(1);
		modelMockObj.setOperId(operMockObj);
		viewObj = Mockito.mock(ViewJdbcImpl.class);
		conn = viewObj.daoConnect();
		Mockito.when(viewObj.duplicateCostCheck(userMockObj)).thenReturn(1);
	}

	@Test
	public void test() {
		try {
			assertEquals(viewObj.duplicateCostCheck(userMockObj),2);
			System.out.println("Test Case: Finding duplicate cost value for the user in database is successful");
		} catch (ClassNotFoundException e) {
			System.out.println("Test Case: Failed - due to improper/missing library files");
			fail();
		}
		catch (SQLException e) {
			System.out.println("Test Case: Failed - connection to database failed");
			fail();
		}
		catch(AssertionError asser)
		{
			System.out.println("Finding duplicate cost value for the user in database failed");
			fail();
		}
	}


}
