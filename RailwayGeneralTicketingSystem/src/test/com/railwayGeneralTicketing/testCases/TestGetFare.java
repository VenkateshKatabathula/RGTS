package com.railwayGeneralTicketing.testCases;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.railwayGeneralTicketing.beans.TrainBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.TrainService;

public class TestGetFare 
{
	TrainBean train=new TrainBean();
	TrainService trainService=ServiceFactory.getTrainService();
	
	@Test
	public void testGetTrain() throws SQLException
	{
		String source="HYD";
		String destination="VSKP";
		
		int fareOfTicket=trainService.getFare(source, destination);
		train.setFareOfTicket(fareOfTicket);
		
		Assert.assertEquals(220,train.getFareOfTicket());
	}
}
