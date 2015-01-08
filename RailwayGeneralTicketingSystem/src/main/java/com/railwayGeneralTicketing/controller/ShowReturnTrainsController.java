package com.railwayGeneralTicketing.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.beans.TrainBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.TrainService;

//Servlet implementation class ShowReturnTrainsController
@WebServlet("/ShowReturnTrainsController")
public class ShowReturnTrainsController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		TrainBean train=null;
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		
		String passengerName=request.getParameter("passengerName");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		int day=Integer.parseInt(request.getParameter("date"));
		int month=Integer.parseInt(request.getParameter("month"));
		int year=Integer.parseInt(request.getParameter("year"));
		int numberOfTickets=Integer.parseInt(request.getParameter("numberOfTickets"));
		System.out.println(passengerName);
		System.out.println(source+" "+destination);
		
		TicketBean ticket=new TicketBean();
		
		ticket.setPassengerName(passengerName);
		ticket.setSource(source);
		ticket.setDestination(destination);
		ticket.setNumberOfTickets(numberOfTickets);
		ticket.setTicketType("R");
		
		session.setAttribute("ticket", ticket);
		
		Calendar cal = Calendar.getInstance();
		cal.set(year,month,day);	
		
		Date date = cal.getTime();
		
		Date today = new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("H");
		String time="00";
		
		if(date.equals(today))
		{
			time=dateFormat.format(today);
		}
		
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());*/
		
		System.out.println(ticket.getSource());
		System.out.println(date);
		System.out.println(time);
		
		TrainService trainService=ServiceFactory.getTrainService();
		
		/*ResultSet trainDetails;*/
		TreeMap<String, String> trainDetails;
		try 
		{
			trainDetails=trainService.getTrain(ticket.getSource(), ticket.getDestination(), time);
			if(trainDetails!=null)
			{
				System.out.println("No details");
			}
			
			/*TreeMap<String, String> treeDetail = new TreeMap<String,String>(); 
			while(trainDetails.next())
			{
				treeDetail.put(trainDetails.getString("TRAIN_NO"), trainDetails.getString("TRAIN_NAME"));
			}*/
			
			Set set=trainDetails.entrySet();
			Iterator itr=set.iterator();
			
			ArrayList<TrainBean> trains=new ArrayList<TrainBean>();
			
			while(itr.hasNext())
			{
				Map.Entry me=(Map.Entry)itr.next();
				train=new TrainBean();
				
				train.setTrainNumber((String)me.getKey());
				train.setTrainName((String)me.getValue());
				
				int numberOfSeats=trainService.getSeats(ticket.getSource(), ticket.getDestination(), train.getTrainNumber());
				train.setNumberOfSeats(numberOfSeats);
				
				int farePerTicket=trainService.getFare(ticket.getSource(), ticket.getDestination());
				train.setFareOfTicket(farePerTicket);
				
				trains.add(train);
			}
			
			request.setAttribute("trainsList", trains);
			session.setAttribute("dateOfJourney", date);
			
			RequestDispatcher rd=request.getRequestDispatcher("ShowTrainsPage.jsp");
			rd.forward(request, response);
		}
		
		catch (SQLException sqle) 
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
		String description="Description of the ShowReturnTrainsController";
		return description; 
	}

}
