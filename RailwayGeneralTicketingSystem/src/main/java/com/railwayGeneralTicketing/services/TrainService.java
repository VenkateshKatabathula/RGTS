package com.railwayGeneralTicketing.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import com.railwayGeneralTicketing.daoFactory.DaoFactory;
import com.railwayGeneralTicketing.daoInterfaces.TrainDao;

public class TrainService 
{
	public TreeMap<String, String> getTrain(String source,String destination,String time) throws SQLException
	{
		TrainDao trainDao=DaoFactory.getTrainDao();
		
		return trainDao.getTrain(source, destination, time);		
	}
	
	public int getSeats(String source,String destination,String trainNumber) throws SQLException
	{
		TrainDao trainDao=DaoFactory.getTrainDao();
		
		return trainDao.getSeats(source, destination, trainNumber);
	}
	
	public int getFare(String source,String destination) throws SQLException
	{
		TrainDao trainDao=DaoFactory.getTrainDao();
		
		return trainDao.getFare(source,destination);
	}
}
