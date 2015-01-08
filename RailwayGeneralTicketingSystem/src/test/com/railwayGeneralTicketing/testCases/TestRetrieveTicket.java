package com.railwayGeneralTicketing.testCases;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.railwayGeneralTicketing.beans.GeneratedTicketBean;
import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.BookService;

public class TestRetrieveTicket 
{
	GeneratedTicketBean generatedTicket=new GeneratedTicketBean();
	BookService bookService=ServiceFactory.getBookService();
	
	@Test
	public void testRetrieveTicket() throws SQLException
	{
		TicketBean ticket=new TicketBean();
		
		ticket.setTicketNumber(1);
		ticket.setPassengerName("Shravya");
		ticket.setSource("SV");
		ticket.setDestination("WL");
		ticket.setNumberOfTickets(1);
		
		String trainNumber="TVSR01";
		int fare=bookService.getFare(ticket);
		int totalFare=fare*ticket.getNumberOfTickets();
		
		List<GeneratedTicketBean> getTicketDetails=bookService.retrieveTicket(ticket, trainNumber);
		generatedTicket=getTicketDetails.get(0);
		generatedTicket.setFarePerPerson(fare);
		generatedTicket.setTotalFare(totalFare);
		
		Assert.assertNotNull(generatedTicket);
		System.out.println(generatedTicket.getTicketNumber());
	}
}
