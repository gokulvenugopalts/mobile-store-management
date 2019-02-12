package com.mindtree.mobilestore.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobilestore.entity.Display;
import com.mindtree.mobilestore.entity.User;

public interface IViewJdbc {
	public ArrayList<Display> getUserDetails(User user) throws ClassNotFoundException, SQLException;
	public ArrayList<Display> getUserDetailsByCost(User user) throws ClassNotFoundException, SQLException;
	public ArrayList<Display> getUserDetailsUnique(User user) throws ClassNotFoundException, SQLException;
}
