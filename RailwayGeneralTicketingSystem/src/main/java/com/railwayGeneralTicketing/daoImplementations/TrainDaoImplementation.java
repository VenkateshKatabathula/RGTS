package com.railwayGeneralTicketing.daoImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import com.railwayGeneralTicketing.daoInterfaces.TrainDao;
import com.railwayGeneralTicketing.util.DBUtility;

public class TrainDaoImplementation implements TrainDao 
{
	@Override
	public TreeMap<String,String> getTrain(String source, String destination, String time) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getTrainDetails=null;
		ResultSet trainDetails=null;
		TreeMap<String, String> treeDetail =null;
		
		try
		{
			connection=DBUtility.getConnection();
		
			getTrainDetails=connection.prepareStatement("SELECT TRAIN_NO,TRAIN_NAME FROM TRAIN WHERE TRAIN_NO IN (SELECT TRAIN_NO FROM TIMINGS WHERE SD_CODE IN (SELECT SD_CODE FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=?) AND SOURCE_DEPARTURE_TIME>?)");
			getTrainDetails.setString(1, source);
			getTrainDetails.setString(2, destination);
			getTrainDetails.setInt(3, Integer.parseInt(time));
		
			trainDetails=getTrainDetails.executeQuery();
			
			treeDetail = new TreeMap<String,String>(); 
			while(trainDetails.next())
			{
				treeDetail.put(trainDetails.getString("TRAIN_NO"), trainDetails.getString("TRAIN_NAME"));
			}
		}
		
		finally
		{
			trainDetails.close();
			getTrainDetails.close();
			DBUtility.closeConnection(connection);
		}
		
		return treeDetail;
	}

	@Override
	public int getSeats(String source, String destination, String trainNumber) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getNumberOfSeats=null;
		ResultSet numberOfSeats=null;
		int seats=0;
		
		try
		{
			connection=DBUtility.getConnection();

			System.out.println("In connection in train dao");
			getNumberOfSeats=connection.prepareStatement("SELECT NUMBER_OF_SEATS FROM AVAILABLE WHERE TRAIN_NO=? AND SD_CODE IN (SELECT SD_CODE FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=?)");
			getNumberOfSeats.setString(1,trainNumber);
			getNumberOfSeats.setString(2, source);
			getNumberOfSeats.setString(3, destination);
		
			numberOfSeats=getNumberOfSeats.executeQuery();
			/*System.out.println("before while in train dao"+ numberOfSeats.next());*/
			while(numberOfSeats.next())
			{
				seats=numberOfSeats.getInt("NUMBER_OF_SEATS");
			}
			System.out.println(seats+" train dao");
		}
		
		finally
		{
			numberOfSeats.close();
			getNumberOfSeats.close();
			DBUtility.closeConnection(connection);
		}
		
		return seats;
	}

	@Override
	public int getFare(String source, String destination) throws SQLException 
	{
		int fare=0;
		Connection connection=null;
		PreparedStatement getCost=null;
		ResultSet ticketFare=null;
		
		try
		{
			connection=DBUtility.getConnection();
		
			getCost=connection.prepareStatement("SELECT FARE_SD FROM FARE WHERE SOURCE_ID=? AND DESTINATION_ID=?");
			getCost.setString(1,source);
			getCost.setString(2, destination);
		
			ticketFare=getCost.executeQuery();
		
		
			while(ticketFare.next())
			{
				fare=ticketFare.getInt("FARE_SD");
			}
		}
		
		finally
		{
			ticketFare.close();
			getCost.close();
			DBUtility.closeConnection(connection);
		}
		
		return fare;
	}
}
