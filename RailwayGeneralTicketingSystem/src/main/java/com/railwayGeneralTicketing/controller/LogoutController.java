package com.railwayGeneralTicketing.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Servlet implementation class LogoutController
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		
		session.removeAttribute("userName");
        
		RequestDispatcher rd = request.getRequestDispatcher("LogoutPage.jsp");
        rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		processRequest(request, response);
	}
	
	public String getServletInfo() 
	{
		String description="Description of Logout Controller";
		return null; 
	}

}
