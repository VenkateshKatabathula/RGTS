package com.railwayGeneralTicketing.testCases;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.railwayGeneralTicketing.beans.TrainBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.TrainService;

public class TestGetTrain 
{
	TrainBean train=new TrainBean();
	TrainService trainService=ServiceFactory.getTrainService();
	
	@Test
	public void testGetTrain() throws SQLException
	{
		String source="HYD";
		String destination="VSKP";
		
		/*Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("H");
		String time=dateFormat.format(date);
		*/
		String time="10";
		TreeMap<String, String> trainDetails;
		trainDetails=trainService.getTrain(source, destination, time);
		
		Set set=trainDetails.entrySet();
		Iterator itr=set.iterator();
		
		while(itr.hasNext())
		{
			Map.Entry me=(Map.Entry)itr.next();
			
			train.setTrainNumber((String)me.getKey());
			train.setTrainName((String)me.getValue());
		}
		
		assertNotNull(train.getTrainNumber());
	}
}
