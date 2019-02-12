package com.mindtree.mobilestore.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;

public interface IEnterJdbc {
	public int enterJdbc(User user, Mobile mobObj) throws ClassNotFoundException, SQLException;
	public <T> int enterJdbc(T mobObj) throws ClassNotFoundException, SQLException;
	public Mobile enterJdbc(Connection conn, User user, Mobile mobObj) throws ClassNotFoundException, SQLException;
	public ArrayList<Oper> getOperList() throws ClassNotFoundException, SQLException;
}
