package com.railwayGeneralTicketing.daoInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public interface TrainDao 
{
	public abstract TreeMap<String, String> getTrain(String source,String destination,String time) throws SQLException;
	public abstract int getSeats(String source,String destination,String time) throws SQLException;
	public abstract int getFare(String source,String destination) throws SQLException;
}
