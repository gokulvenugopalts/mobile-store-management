package com.mindtree.mobilestore.dao.impl;

import java.sql.Connection;
import java.util.concurrent.Callable;

public class ThreadEnter implements Callable<Connection>{
	ConnectionManager cm;
	public ThreadEnter(ConnectionManager cm)
	{
		this.cm = cm;
	}
	@Override
	public Connection call() throws Exception {
		return cm.daoConnect();
	}
	
}