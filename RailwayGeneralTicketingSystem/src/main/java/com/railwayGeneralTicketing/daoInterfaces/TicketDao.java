package com.railwayGeneralTicketing.daoInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.railwayGeneralTicketing.beans.TicketBean;

public interface TicketDao
{
	public abstract List<TicketBean> getDetails(String passengerName) throws SQLException;

	public abstract List<TicketBean> getDetails(int ticketNumber) throws SQLException;
}
