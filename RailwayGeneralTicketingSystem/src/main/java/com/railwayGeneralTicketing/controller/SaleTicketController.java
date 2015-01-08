package com.railwayGeneralTicketing.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.TicketService;

//Servlet implementation class SaleTicketController
@WebServlet("/SaleTicketController")
public class SaleTicketController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		TicketBean ticket=new TicketBean();
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		
		TicketService ticketService=ServiceFactory.getTicketService();
		
		ResultSet source=null;
		try
		{
			/*source=ticketService.getStation(userName);*/
			while(source.next())
			{
				ticket.setSource(source.getString("SOURCE_ID"));
			}
		}
		
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		request.setAttribute("ticket",ticket);
		
		RequestDispatcher rd=request.getRequestDispatcher("SaleTicketPage.jsp");
		rd.forward(request,response);
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
		String description="Description of SaleTicketController";
		return description; 
	}


}
