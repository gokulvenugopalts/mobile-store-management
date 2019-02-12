package com.mindtree.mobilestore.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobilestore.dao.IEnterJdbc;
import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;

public class EnterJdbcImpl extends ConnectionManager implements IEnterJdbc{
	EnterJdbcImpl conObj;
	
	public int enterJdbc(User user, Mobile mobObj) throws ClassNotFoundException, SQLException
	{
		conObj = new EnterJdbcImpl();
		Connection conn =conObj.daoConnect();
		mobObj = conObj.enterJdbc(conn, user, mobObj);
/*		PreparedStatement pr = conn.prepareStatement("insert into userdb (user_name,model_id,cost) "
				+ "values(?,?,?)");
		pr.setString(1, user.getUserName());
		pr.setInt(2, mobObj.getModelId());
		pr.setDouble(3, user.getCost());*/
		CallableStatement cal = conn.prepareCall("{call enterProcedure(?,?,?)}");
		cal.setString(1, user.getUserName());
		cal.setInt(2, mobObj.getModelId());
		cal.setDouble(3, user.getCost());
		cal.addBatch();
		int[] flag = cal.executeBatch();
		//int flag = pr.executeUpdate();
		conObj.daoDisConnect(conn);
		return flag[0];
	}
	public <T> int enterJdbc(T mobileObj) throws ClassNotFoundException, SQLException
	{
		Mobile mobObj = new Mobile();
		mobObj = (Mobile)mobileObj;
		conObj = new EnterJdbcImpl();
		Connection conn =conObj.daoConnect();
		PreparedStatement pr = conn.prepareStatement("insert into mobiledb (oper_id,model_name) "
				+ "values(?,?)");
		pr.setInt(1, mobObj.getOperId());
		pr.setString(2, mobObj.getModelName());
		int flag = pr.executeUpdate();
		conObj.daoDisConnect(conn);
		return flag;
	}
	public Mobile enterJdbc(Connection conn, User user, Mobile mobObj) throws ClassNotFoundException, SQLException
	{
		PreparedStatement pr = conn.prepareStatement("select model_id from mobiledb where model_name=?"
				+ " and oper_id order by model_id desc limit 1");
		pr.setString(1, mobObj.getModelName());
		ResultSet rs = pr.executeQuery();
		while(rs.next())
		{
			mobObj.setModelId(rs.getInt(1));
		}
		return mobObj;
	}
	public ArrayList<Oper> getOperList() throws ClassNotFoundException, SQLException
	{
		conObj = new EnterJdbcImpl();
		Connection conn =conObj.daoConnect();
		CallableStatement ca = conn.prepareCall("{call getOperProcedure}");
		
		PreparedStatement pr = conn.prepareStatement("Select * from operdb");
		ResultSet rs = ca.executeQuery();
		ArrayList<Oper> operArr = new ArrayList<Oper>(); 
		while(rs.next())
		{
			Oper operObj = new Oper();
			operObj.setOperId(rs.getInt(1));
			operObj.setOperName(rs.getString(2));
			operArr.add(operObj);
		}
		return operArr;
	}
}
