package com.mindtree.mobilestore.dao.impl;

import java.sql.Connection;
import java.util.concurrent.Callable;

public class ThreadView implements Callable<Connection>{
	ConnectionManager cm;
	public ThreadView(ConnectionManager cm)
	{
		this.cm = cm;
	}
	@Override
	public Connection call() throws Exception {
		return cm.daoConnect();
	}
}
