package com.railwayGeneralTicketing.daoImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.railwayGeneralTicketing.beans.GeneratedTicketBean;
import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.daoInterfaces.BookDao;
import com.railwayGeneralTicketing.util.DBUtility;

public class BookDaoImplementation implements BookDao
{
	@Override
	public Boolean updateTicket(TicketBean ticket, String trainNumber, int trip,int seats,Date date) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getSDCode=null;
		ResultSet SDCode=null;
		PreparedStatement setTicketDetails=null;
		int updated=0;
		Boolean updatedTicket=null;
		
		try
		{
			connection=DBUtility.getConnection();
		
			getSDCode=connection.prepareStatement("SELECT SD_CODE FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=? AND SD_CODE IN (SELECT SD_CODE FROM AVAILABLE WHERE TRAIN_NO=?)");
			getSDCode.setString(1, ticket.getSource());
			getSDCode.setString(2, ticket.getDestination());
			getSDCode.setString(3, trainNumber);
		
			SDCode=getSDCode.executeQuery();
			String sdCode=null;
			while(SDCode.next())
			{
				sdCode=SDCode.getString("SD_CODE");
			}
			System.out.println(sdCode+"updateticket");
		
			if(seats>=0)
			{
			
				java.sql.Date dateOfJourney = new java.sql.Date(date.getTime());
				/*setTicketDetails=connection.prepareStatement("INSERT INTO TICKET(PASSENGER_NAME,SD_CODE,DATE_OF_JOURNEY,TRIP,TRAIN_NO,NUMBER_OF_TICKETS,TICKET_TYPE) VALUES(?,?,SYSDATE,?,?,?,?)");
				setTicketDetails.setString(1, ticket.getPassengerName());
				setTicketDetails.setString(2, sdCode);
				setTicketDetails.setInt(3, trip);
				setTicketDetails.setString(4, trainNumber);
				setTicketDetails.setInt(5, ticket.getNumberOfTickets());
				setTicketDetails.setString(6, ticket.getTicketType());*/
				
				setTicketDetails=connection.prepareStatement("INSERT INTO TICKET(PASSENGER_NAME,SD_CODE,DATE_OF_JOURNEY,TRIP,TRAIN_NO,NUMBER_OF_TICKETS,TICKET_TYPE) VALUES(?,?,?,?,?,?,?)");
				setTicketDetails.setString(1, ticket.getPassengerName());
				setTicketDetails.setString(2, sdCode);
				setTicketDetails.setDate(3, dateOfJourney);
				setTicketDetails.setInt(4, trip);
				setTicketDetails.setString(5, trainNumber);
				setTicketDetails.setInt(6, ticket.getNumberOfTickets());
				setTicketDetails.setString(7, ticket.getTicketType());
	
				updated=setTicketDetails.executeUpdate();
				if(updated==1)
				{
					updatedTicket=true;
				}
				else
				{
					System.out.println("false in if");
					updatedTicket=false;
				}
			}
			else 
			{
				System.out.println("false out if");
				updatedTicket=false;
			}
		}
		finally
		{
			if(setTicketDetails!=null)
			{
				setTicketDetails.close();
			}
			SDCode.close();
			getSDCode.close();
			DBUtility.closeConnection(connection);
			
		}
		return updatedTicket;
	}

	@Override
	public Boolean updateAvailable(String trainNumber,int seats) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement setAvailable=null;
		Boolean updatedAvailable=null;
		
		try
		{			
			connection=DBUtility.getConnection();
			System.out.println(seats+" updateAvailable");
			if(seats>=0)
			{
				setAvailable=connection.prepareStatement("UPDATE AVAILABLE SET NUMBER_OF_SEATS=? WHERE TRAIN_NO=?");
			
				setAvailable.setInt(1, seats);
				setAvailable.setString(2, trainNumber);
		
				int updated=setAvailable.executeUpdate();
				if(updated>1)
				{
					updatedAvailable=true;
				}
				else
				{
					updatedAvailable=false;
				}
			}
			else
			{
				updatedAvailable=false;
			}
		}
		finally
		{
			if(setAvailable!=null)
			{
				setAvailable.close();
			}
			DBUtility.closeConnection(connection);
		}
		return updatedAvailable;
	}

	@Override
	public int getTrip(String trainNumber) throws SQLException 
	{
		Connection connection =null;
		int trip = 0;
		PreparedStatement getNumberOfTrips = null;
		ResultSet numberOfTrip =null;
		try
		{
			connection = DBUtility.getConnection();
			getNumberOfTrips = connection.prepareStatement("SELECT TRIP FROM TIMINGS where (TO_CHAR(systimestamp,'HH') < DEST_ARRIVAL_TIME) AND SD_CODE =(SELECT SD_CODE FROM TRAIN WHERE TRAIN_NO=?)");
			getNumberOfTrips.setString(1, trainNumber);

			numberOfTrip = getNumberOfTrips.executeQuery();
			
			while (numberOfTrip.next()) 
			{
				trip = numberOfTrip.getInt("TRIP");
			}
			System.out.println(trip);
		}
		finally
		{
			numberOfTrip.close();
			getNumberOfTrips.close();
			DBUtility.closeConnection(connection);
		}

		return trip;
	}

	@Override
	public int getSeats(TicketBean ticket, String trainNumber) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getSDCode=null;
		ResultSet SDCode=null;
		PreparedStatement getNumberOfSeats=null;
		ResultSet numberOfSeats=null;
		int seats=0;

		try
		{
			connection=DBUtility.getConnection();
				
			getSDCode=connection.prepareStatement("SELECT SD_CODE FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=? AND SD_CODE IN (SELECT SD_CODE FROM AVAILABLE WHERE TRAIN_NO=?)");
			getSDCode.setString(1, ticket.getSource());
			getSDCode.setString(2, ticket.getDestination());
			getSDCode.setString(3, trainNumber);
		
			SDCode=getSDCode.executeQuery();
			String sdCode=null;
			
			if(SDCode.next())
			{
				sdCode=SDCode.getString("SD_CODE");
			}
			
			System.out.println(sdCode);
		
			getNumberOfSeats=connection.prepareStatement("SELECT NUMBER_OF_SEATS FROM AVAILABLE WHERE SD_CODE=? AND TRAIN_NO=?");
			getNumberOfSeats.setString(1, sdCode);
			getNumberOfSeats.setString(2, trainNumber);
		
			numberOfSeats=getNumberOfSeats.executeQuery();
		//	System.out.println(numberOfSeats.next()+" retrive seats");
					
			while(numberOfSeats.next())
			{
				seats=numberOfSeats.getInt("NUMBER_OF_SEATS");
				System.out.println(seats + "in if");
			}
		
			System.out.println(ticket.getNumberOfTickets()+" numberOfTickets");
			if(seats>=0)
			{
				seats=seats-ticket.getNumberOfTickets();
			}
			System.out.println(seats+"after minus");
		}
		finally
		{
			numberOfSeats.close();
			getNumberOfSeats.close();
			SDCode.close();
			getSDCode.close();
			DBUtility.closeConnection(connection);			
		}
		
		return seats;
	}

	@Override
	public List<GeneratedTicketBean> retrieveTicket(TicketBean ticket,String trainNumber) throws SQLException 
	{
		Connection connection = null;
		PreparedStatement getSDCode=null;
		ResultSet SDCode=null;
		PreparedStatement getTrainName=null;
		ResultSet trainName=null;
		PreparedStatement getDepartureTime=null;
		ResultSet departure=null;
		PreparedStatement getTicketDetails=null;
		
		ResultSet ticketDetails = null;
		List<GeneratedTicketBean> printTicket;
		
		try
		{
			connection = DBUtility.getConnection();

			getSDCode=connection.prepareStatement("SELECT SD_CODE FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=? AND SD_CODE IN (SELECT SD_CODE FROM AVAILABLE WHERE TRAIN_NO=?)");
			getSDCode.setString(1, ticket.getSource());
			getSDCode.setString(2, ticket.getDestination());
			getSDCode.setString(3, trainNumber);
		
			SDCode=getSDCode.executeQuery();
			String sdCode=null;
			if(SDCode.next())
			{
				sdCode=SDCode.getString("SD_CODE");
			}
			System.out.println(sdCode+"reterieve Ticket");
			
			getTrainName=connection.prepareStatement("SELECT TRAIN_NAME FROM TRAIN WHERE TRAIN_NO='"+trainNumber+"'");
			trainName=getTrainName.executeQuery();
			String trainname=null;
			if(trainName.next())
			{
				trainname=trainName.getString("TRAIN_NAME");
			}
			System.out.println(trainname+"reterieve Ticket");
		
			getDepartureTime=connection.prepareStatement("SELECT SOURCE_DEPARTURE_TIME FROM TIMINGS WHERE SD_CODE='"+sdCode+"'");
			departure=getDepartureTime.executeQuery();
			int departureTime=0;
			if(departure.next())
			{
				departureTime=departure.getInt("SOURCE_DEPARTURE_TIME");
			}
			System.out.println(departure.getInt("SOURCE_DEPARTURE_TIME"));
			System.out.println(ticket.getTicketNumber()+"retrieveTicket");
			getTicketDetails = connection.prepareStatement("SELECT * FROM TICKET WHERE SD_CODE=? AND PASSENGER_NAME =?");
			getTicketDetails.setString(1, sdCode);
			getTicketDetails.setString(2, ticket.getPassengerName());
			
			ticketDetails = getTicketDetails.executeQuery();
			/*System.out.println(ticketDetails.next()+"retrieve ticket");*/
			
			printTicket=new ArrayList<GeneratedTicketBean>();
			while(ticketDetails.next())
			{
				GeneratedTicketBean generateTicket=new GeneratedTicketBean();
				
				generateTicket.setTicketNumber(ticketDetails.getInt("TICKET_NO"));
				generateTicket.setPassengerName(ticketDetails.getString("PASSENGER_NAME"));
				generateTicket.setSource(ticket.getSource());
				generateTicket.setDestination(ticket.getDestination());
				generateTicket.setNumberOfTickets(ticket.getNumberOfTickets());
				generateTicket.setDateOfJourney(ticketDetails.getDate("DATE_OF_JOURNEY"));
				generateTicket.setTrainNumber(trainNumber);
				generateTicket.setTrainName(trainname);
				generateTicket.setDepartureTime(departureTime);	
				
				printTicket.add(generateTicket);
			}
		}
		finally
		{
			ticketDetails.close();
			getTicketDetails.close();
			departure.close();
			getDepartureTime.close();
			trainName.close();
			getTrainName.close();
			SDCode.close();
			getSDCode.close();
			DBUtility.closeConnection(connection);
		}

		return printTicket;
	}

	@Override
	public int getFare(TicketBean ticket) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getCost=null;
		ResultSet farePerTicket=null;
		int fare=0;
		
		try
		{
			connection=DBUtility.getConnection();
		
			getCost=connection.prepareStatement("SELECT FARE_SD FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=?");
			getCost.setString(1, ticket.getSource());
			getCost.setString(2, ticket.getDestination());
		
			farePerTicket=getCost.executeQuery();
			
			while(farePerTicket.next())
			{
				fare=farePerTicket.getInt("FARE_SD");
			}
		}
		
		finally
		{
			farePerTicket.close();
			getCost.close();
			DBUtility.closeConnection(connection);
		}
		
		return fare;
	}	
}
