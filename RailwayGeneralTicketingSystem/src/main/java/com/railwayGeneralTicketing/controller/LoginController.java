package com.railwayGeneralTicketing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railwayGeneralTicketing.beans.LoginBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.LoginService;

//Servlet implementation class LoginController
@SuppressWarnings("serial")
@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		try
		{
			String userName=request.getParameter("userName");
			String password =request.getParameter("password");
			Character role = 'N';
		
			LoginBean loginCredentials=new LoginBean();
		
			loginCredentials.setUserName(userName);
			loginCredentials.setPassword(password);
		
			LoginService loginService=ServiceFactory.getLoginService();
			
			HttpSession session=request.getSession();
			session.setAttribute("userName", request.getParameter("userName"));
			
			try 
			{
				role=loginService.validateUser(loginCredentials);
			} 
			catch (SQLException sqle) 
			{
				sqle.printStackTrace();
			}
			
			if(role=='A')
			{
				RequestDispatcher rd = request.getRequestDispatcher("AdminHomePage.jsp");
	            rd.forward(request, response);
			}
			else if(role=='C')
			{				
				RequestDispatcher rd = request.getRequestDispatcher("CounterPersonHomePage.jsp");
	            rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("InvalidCredentialsPage.html");
	            rd.forward(request, response);
			}
		}
		finally
		{
			out.close();				
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		processRequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		processRequest(request,response);
	}
	
	
	public String getServletInfo() 
	{
		String Description="Description of LoginController";
		return Description; 
	}	

}
