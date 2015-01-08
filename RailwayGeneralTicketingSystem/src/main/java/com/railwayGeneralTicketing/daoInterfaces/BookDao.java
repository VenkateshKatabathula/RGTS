package com.railwayGeneralTicketing.daoInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.railwayGeneralTicketing.beans.GeneratedTicketBean;
import com.railwayGeneralTicketing.beans.TicketBean;

public interface BookDao 
{
	public abstract Boolean updateTicket(TicketBean ticket, String trainNumber, int trip,
			int seats,Date date) throws SQLException;
	public abstract Boolean updateAvailable(String trainNumber, int seats) throws SQLException;
	public abstract int getTrip(String TrainNumber) throws SQLException;
	public abstract int getSeats(TicketBean ticket,String trainNumber) throws SQLException;
	public abstract List<GeneratedTicketBean> retrieveTicket(TicketBean ticket, String trainNumber) throws SQLException;
	public abstract int getFare(TicketBean ticket) throws SQLException;
	
}
