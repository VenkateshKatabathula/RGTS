package com.railwayGeneralTicketing.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

//Servlet implementation class SaleReturnTicketController
@WebServlet("/SaleReturnTicketController")
public class SaleReturnTicketController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		TicketBean ticket=new TicketBean();
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		String passengerName=request.getParameter("passengerName");
		int ticketNumber=Integer.parseInt(request.getParameter("ticketNumber"));
		
		TicketService ticketService=ServiceFactory.getTicketService();
		System.out.println(passengerName+"returnTicket");
		List<TicketBean> ticketDetails;
		try
		{
			ticketDetails=ticketService.getDetails(ticketNumber);
			
			ticket=ticketDetails.get(0);
		}
		
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		request.setAttribute("ticket",ticket);
		
		RequestDispatcher rd=request.getRequestDispatcher("SaleReturnTicketPage.jsp");
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