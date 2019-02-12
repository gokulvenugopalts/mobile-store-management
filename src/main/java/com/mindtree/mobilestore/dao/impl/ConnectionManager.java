package com.mindtree.mobilestore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	String db_url = "jdbc:mysql://localhost/mobilestore";
	public Connection daoConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(db_url,"root", "Welcome123");
		return conn;
	}
	public void daoDisConnect(Connection conn) throws SQLException
	{
		conn.close();
	}
	
}
