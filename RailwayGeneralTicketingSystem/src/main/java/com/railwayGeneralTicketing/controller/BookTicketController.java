package com.railwayGeneralTicketing.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railwayGeneralTicketing.beans.GeneratedTicketBean;
import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.BookService;

//Servlet implementation class BookTicketController
@WebServlet("/BookTicketController")
public class BookTicketController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		TicketBean ticket=(TicketBean)session.getAttribute("ticket");
		String trainNumber=(String)request.getParameter("trainNumber");
		Date date=(Date)session.getAttribute("dateOfJourney");
		
		System.out.println(trainNumber);
		System.out.println(date);
		
		BookService bookService=ServiceFactory.getBookService();
		
		try
		{
			int trip=bookService.getTrip(trainNumber);
			System.out.println(ticket.getNumberOfTickets()+" "+trainNumber+" in book controller");
			int seats=bookService.getSeats(ticket, trainNumber);
			int fare=bookService.getFare(ticket);
			int totalFare=fare*ticket.getNumberOfTickets();
			Boolean update=bookService.updateTicket(ticket, trainNumber,trip,seats,date);
			System.out.println(update+" in ticketController");
			Boolean available=bookService.updateAvailable(trainNumber, seats);
			List<GeneratedTicketBean> getTicketDetails=bookService.retrieveTicket(ticket, trainNumber);
			
			System.out.println(trip+" "+seats+" "+fare+" "+update+" "+available);
			if(update && available)
			{
				GeneratedTicketBean generatedTicket=new GeneratedTicketBean();
				
				generatedTicket=getTicketDetails.get(0);
				generatedTicket.setFarePerPerson(fare);
				generatedTicket.setTotalFare(totalFare);
				
			/*ArrayList<String> ticketDetails=new ArrayList<String>();
			System.out.println(getTicketDetails.next());
			while(getTicketDetails.next())
			{
				ticketDetails.add(getTicketDetails.getString(1));
				ticketDetails.add(getTicketDetails.getString(2));
				ticketDetails.add(ticket.getSource());
				ticketDetails.add(ticket.getDestination());
				ticketDetails.add(getTicketDetails.getString(4));
				ticketDetails.add(getTicketDetails.getString(5));
				ticketDetails.add(getTicketDetails.getString(6));
				ticketDetails.add(getTicketDetails.getString(7));
				ticketDetails.add(fare+"");
				ticketDetails.add(totalFare+"");
			}
			
*/			
			/*for(String str:ticketDetails)
			{
				System.out.println(str);
			}*/
			
			request.setAttribute("generatedTicket", generatedTicket);
		/*	request.setAttribute("update",update);
			request.setAttribute("available", available);*/
			
			RequestDispatcher rd=request.getRequestDispatcher("GenerateTicketPage.jsp");
			rd.forward(request,response);
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("GenerateTicketErrorPage.html");
			rd.forward(request, response);
		}
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}		
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
		String description="Description of BookTicketController";
		return description; 
	}
}
