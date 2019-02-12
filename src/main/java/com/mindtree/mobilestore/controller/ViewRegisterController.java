package com.mindtree.mobilestore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.mobilestore.entity.User;
import com.mindtree.mobilestore.service.IViewService;
import com.mindtree.mobilestore.service.impl.ViewServiceImpl;

/**
 * Servlet implementation class ViewRegisterController
 */
@WebServlet("/ViewRegisterController")
public class ViewRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("search");
		System.out.println(url);
		
		if("Search by name".equals(url))
		{
			String res = searchByName(request,response);
			urlDirect(request, response, res);			
		}
		else if("Search by Cost".equals(url))
		{
			String res = searchByCost(request,response);
			urlDirect(request, response, res);
		}
		else if("Search by unique name and cost".equals(url))
		{
			String res = searchByUnique(request,response);
			urlDirect(request, response, res);
		}
	}
	public String searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("searchname");
		User user = new User();
		user.setUserName(name);
		IViewService iViewObj = new ViewServiceImpl();
		return iViewObj.viewServiceByName(user);
	}
	public String searchByCost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Double cost = Double.parseDouble(request.getParameter("searchcost"));
		User user = new User();
		user.setCost(cost);
		IViewService iViewObj = new ViewServiceImpl();
		return iViewObj.viewServiceByCost(user);
	}
	public String searchByUnique(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("searchname");
		Double cost = Double.parseDouble(request.getParameter("searchcost"));
		User user = new User();
		user.setCost(cost);
		user.setUserName(name);
		IViewService iViewObj = new ViewServiceImpl();
		return iViewObj.viewService(user);
	}
	public void urlDirect(HttpServletRequest request, HttpServletResponse response, String res) throws ServletException, IOException
	{
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		if(res.contains("-") && res.contains(":"))
		{
			res="User Name:Model Name:Operating System:Cost-"+res;
			session.setAttribute("registerList",res);
			System.out.println(res);
			rd = request.getRequestDispatcher("RegisterDisplay.jsp");
		}
		else
		{
			session.setAttribute("message", res);
			System.out.println(res);
			rd = request.getRequestDispatcher("Message.jsp");
		}
		rd.forward(request, response);
	}

}
