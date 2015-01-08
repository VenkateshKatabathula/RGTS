package com.railwayGeneralTicketing.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.railwayGeneralTicketing.beans.TicketBean;
import com.railwayGeneralTicketing.daoFactory.DaoFactory;
import com.railwayGeneralTicketing.daoInterfaces.TicketDao;

public class TicketService 
{
	public List<TicketBean> getDetails(String passengerName) throws SQLException
	{
		TicketDao ticketDao=DaoFactory.getTicketDao();
		
		return ticketDao.getDetails(passengerName);
	}

	public List<TicketBean> getDetails(int ticketNumber) throws SQLException 
	{
		TicketDao ticketDao=DaoFactory.getTicketDao();
		
		return ticketDao.getDetails(ticketNumber);
	}
}
