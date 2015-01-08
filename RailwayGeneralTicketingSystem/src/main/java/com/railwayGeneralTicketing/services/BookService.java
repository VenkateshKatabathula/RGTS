package com.railwayGeneralTicketing.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.railwayGeneralTicketing.beans.GeneratedTicketBean;
import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.daoFactory.DaoFactory;
import com.railwayGeneralTicketing.daoInterfaces.BookDao;

public class BookService 
{
	public Boolean updateTicket(TicketBean ticket,String trainNumber,int trip,int seats, Date date) throws SQLException
	{
		BookDao bookDao=DaoFactory.getBookDao();
		return bookDao.updateTicket(ticket, trainNumber, trip, seats, date);
	}
	
	public Boolean updateAvailable(String trainNumber,int seats) throws SQLException
	{
		BookDao bookDao=DaoFactory.getBookDao();
		return bookDao.updateAvailable(trainNumber, seats);
	}
	
	public int getTrip(String trainNumber) throws SQLException
	{
		BookDao bookDao=DaoFactory.getBookDao();
		return bookDao.getTrip(trainNumber);
	}
	
	public int getSeats(TicketBean ticket,String trainNumber) throws SQLException
	{
		BookDao bookDao=DaoFactory.getBookDao();
		return bookDao.getSeats(ticket,trainNumber);
	}
	
	public int getFare(TicketBean ticket) throws SQLException
	{
		BookDao bookDao=DaoFactory.getBookDao();
		return bookDao.getFare(ticket);
	}
	
	public List<GeneratedTicketBean> retrieveTicket(TicketBean ticket, String trainNumber) throws SQLException
	{
		BookDao bookDao=DaoFactory.getBookDao();
		return bookDao.retrieveTicket(ticket, trainNumber);
	}
}
