package com.railwayGeneralTicketing.testCases;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.railwayGeneralTicketing.beans.TrainBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.TrainService;

public class TestGetSeats 
{
	TrainBean train=new TrainBean();
	TrainService trainService=ServiceFactory.getTrainService();
	
	@Test
	public void testGetTrain() throws SQLException
	{
		String source="HYD";
		String destination="VSKP";
		String trainNumber="THVF01";
		
		int numberOfSeats=trainService.getSeats(source, destination, trainNumber);
		train.setNumberOfSeats(numberOfSeats);
		
		Assert.assertNotNull(train.getNumberOfSeats());
	}		
}
