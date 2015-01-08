package com.railwayGeneralTicketing.daoImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.daoInterfaces.TicketDao;
import com.railwayGeneralTicketing.util.DBUtility;

public class TicketDaoImplementation implements TicketDao 
{
	@Override
	public List<TicketBean> getDetails(String passengerName) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getTicketDetails=null;
		ResultSet details=null;
		
		List<TicketBean> returnTicket;
		
		try
		{
			connection=DBUtility.getConnection();
				
			getTicketDetails=connection.prepareStatement("SELECT * FROM TICKET WHERE PASSENGER_NAME='"+passengerName+"'");			
			details=getTicketDetails.executeQuery();
			
			returnTicket=new ArrayList<TicketBean>();
			
			while(details.next())
			{
				TicketBean ticket=new TicketBean();
				
				PreparedStatement getSourceDestination=connection.prepareStatement("SELECT SOURCE_ID, DESTINATION_ID FROM FARE WHERE SD_CODE ='"+details.getString("SD_CODE")+"'");
				ResultSet sourceDestination=getSourceDestination.executeQuery();
				String source=null;
				String destination=null;
				
				if(sourceDestination.next())
				{
					source=sourceDestination.getString("SOURCE_ID");
					destination=sourceDestination.getString("DESTINATION_ID");
				}
				
				ticket.setPassengerName(passengerName);
				ticket.setSource(source);
				ticket.setDestination(destination);
				
				returnTicket.add(ticket);	
				
				sourceDestination.close();
				getSourceDestination.close();
			}
		}
		
		finally
		{
			details.close();
			getTicketDetails.close();
			DBUtility.closeConnection(connection);
		}
		
		return returnTicket;
	}

	@Override
	public List<TicketBean> getDetails(int ticketNumber) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getTicketDetails=null;
		ResultSet details=null;
		
		List<TicketBean> returnTicket;
		
		try
		{
			connection=DBUtility.getConnection();
				
			getTicketDetails=connection.prepareStatement("SELECT * FROM TICKET WHERE TICKET_NO='"+ticketNumber+"'");			
			details=getTicketDetails.executeQuery();
			
			returnTicket=new ArrayList<TicketBean>();
			
			while(details.next())
			{
				TicketBean ticket=new TicketBean();
				
				PreparedStatement getSourceDestination=connection.prepareStatement("SELECT SOURCE_ID, DESTINATION_ID FROM FARE WHERE SD_CODE ='"+details.getString("SD_CODE")+"'");
				ResultSet sourceDestination=getSourceDestination.executeQuery();
				String source=null;
				String destination=null;
				
				if(sourceDestination.next())
				{
					source=sourceDestination.getString("SOURCE_ID");
					destination=sourceDestination.getString("DESTINATION_ID");
				}
				
				ticket.setTicketNumber(ticketNumber);
				ticket.setPassengerName(details.getString("PASSENGER_NAME"));
				ticket.setSource(source);
				ticket.setDestination(destination);
				
				returnTicket.add(ticket);	
				
				sourceDestination.close();
				getSourceDestination.close();
			}
		}
		
		finally
		{
			details.close();
			getTicketDetails.close();
			DBUtility.closeConnection(connection);
		}
		
		return returnTicket;
	}
}