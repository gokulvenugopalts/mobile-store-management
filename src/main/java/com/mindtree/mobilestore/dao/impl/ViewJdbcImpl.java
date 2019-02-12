package com.mindtree.mobilestore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobilestore.dao.IViewJdbc;
import com.mindtree.mobilestore.entity.Display;
import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;


public class ViewJdbcImpl extends ConnectionManager implements IViewJdbc{
	ViewJdbcImpl conObj;

	public int dupicateNameCheck(User user) throws ClassNotFoundException, SQLException
	{
		conObj = new ViewJdbcImpl();
		Connection conn =conObj.daoConnect();
		PreparedStatement pr = conn.prepareStatement("select count(*) from userdb where lower(user_name)=?");
		pr.setString(1, user.getUserName().toLowerCase());
		ResultSet rs = pr.executeQuery();
		int count =1;
		while(rs.next())
		{
			count = rs.getInt(1);
		}
		conObj.daoDisConnect(conn);
		System.out.println();
		return count;
	}
	public int duplicateCostCheck(User user) throws ClassNotFoundException, SQLException
	{
		conObj = new ViewJdbcImpl();
		Connection conn =conObj.daoConnect();
		PreparedStatement pr = conn.prepareStatement("select count(*) from userdb where cost=?");
		pr.setDouble(1, user.getCost());
		ResultSet rs = pr.executeQuery();
		int count =1;
		while(rs.next())
		{
			count = rs.getInt(1);
		}
		conObj.daoDisConnect(conn);
		return count;
	}
	public ArrayList<Display> getUserDetailsUnique(User user) throws ClassNotFoundException, SQLException
	{
		conObj = new ViewJdbcImpl();
		Connection conn =conObj.daoConnect();
		PreparedStatement pr = conn.prepareStatement("select u.user_name,temp.model_name,temp.oper_name,u.cost "
				+"from (select m.model_id,m.model_name,op.oper_name from mobiledb m "
				+"left join operdb op "
				+"on m.oper_id = op.oper_id) temp "
				+"right join userdb u "
				+"on u.model_id = temp.model_id "
				+"where lower(u.user_name)=? and u.cost=?");
		pr.setString(1, user.getUserName().toLowerCase());
		pr.setDouble(2, user.getCost());
		ResultSet rs = pr.executeQuery();
		ArrayList<Display> dispArr = new ArrayList<Display>();
		dispArr=getDispArr(rs);
		conObj.daoDisConnect(conn);
		return dispArr;
	}
	public ArrayList<Display> getUserDetails(User user) throws ClassNotFoundException, SQLException
	{
		conObj = new ViewJdbcImpl();
		Connection conn =conObj.daoConnect();
		PreparedStatement pr = conn.prepareStatement("select u.user_name,temp.model_name,temp.oper_name,u.cost "
				+"from (select m.model_id,m.model_name,op.oper_name from mobiledb m "
				+"left join operdb op "
				+"on m.oper_id = op.oper_id) temp "
				+"right join userdb u "
				+"on u.model_id = temp.model_id "
				+"where lower(u.user_name)=?");
		pr.setString(1, user.getUserName().toLowerCase());
		ResultSet rs = pr.executeQuery();
		ArrayList<Display> dispArr = new ArrayList<Display>();
		dispArr=getDispArr(rs);
		conObj.daoDisConnect(conn);
		return dispArr;
	}
	public ArrayList<Display> getUserDetailsByCost(User user) throws ClassNotFoundException, SQLException
	{
		conObj = new ViewJdbcImpl();
		Connection conn =conObj.daoConnect();
		PreparedStatement pr = conn.prepareStatement("select u.user_name,temp.model_name,temp.oper_name,u.cost "
				+"from (select m.model_id,m.model_name,op.oper_name from mobiledb m "
				+"left join operdb op "
				+"on m.oper_id = op.oper_id) temp "
				+"right join userdb u "
				+"on u.model_id = temp.model_id "
				+"where u.cost=?");
		pr.setDouble(1, user.getCost());
		ResultSet rs = pr.executeQuery();
		ArrayList<Display> dispArr = new ArrayList<Display>();
		dispArr=getDispArr(rs);
		conObj.daoDisConnect(conn);
		return dispArr;
	}
	public ArrayList<Display> getDispArr(ResultSet rs) throws SQLException
	{
		ArrayList<Display> dispArr = new ArrayList<Display>();
		while(rs.next())
		{
			Display dispObj = new Display();
			User userObj = new User();
			Mobile mobObj = new Mobile();
			Oper operObj = new Oper();
			
			userObj.setUserName(rs.getString(1));
			userObj.setCost(rs.getDouble(4));
			mobObj.setModelName(rs.getString(2));
			operObj.setOperName(rs.getString(3));
			
			dispObj.setMobObj(mobObj);
			dispObj.setOperObj(operObj);
			dispObj.setUser(userObj);
			dispArr.add(dispObj);
		}
		return dispArr;
	}
}
