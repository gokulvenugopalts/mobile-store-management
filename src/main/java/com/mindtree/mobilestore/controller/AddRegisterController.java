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



import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.Oper;
import com.mindtree.mobilestore.entity.User;
import com.mindtree.mobilestore.service.IEnterService;
import com.mindtree.mobilestore.service.impl.EnterServiceImpl;

/**
 * Servlet implementation class AddRegisterController
 */
@WebServlet("/AddRegisterController")
public class AddRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("registersubmit");
		if(url == null)
		{
			PrintWriter out= response.getWriter();
			out.println(getOperList());
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("message", getDetails(request,response));
			RequestDispatcher rd = request.getRequestDispatcher("Message.jsp");
			rd.forward(request, response);
		}
	}
	public String getOperList()
	{
		IEnterService iEnterObj = new EnterServiceImpl();
		return iEnterObj.getOperList();
	}
	public String getDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
		String modelName = request.getParameter("modelname");
		int operId = Integer.parseInt(request.getParameter("opersystem"));
		Double modelCost = Double.parseDouble(request.getParameter("modelcost"));
		IEnterService iEnterObj = new EnterServiceImpl();
		
		User user = new User();
		Mobile mobObj = new Mobile(); 
		Oper operObj = new Oper();
		
		user.setUserName(name);
		user.setCost(modelCost);
		operObj.setOperId(operId);
		mobObj.setModelName(modelName);
		mobObj.setOperId(operObj);
		return iEnterObj.enterService(user, mobObj);
	}

}
