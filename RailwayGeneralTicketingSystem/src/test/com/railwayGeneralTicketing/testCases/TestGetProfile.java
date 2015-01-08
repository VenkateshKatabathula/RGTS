package com.railwayGeneralTicketing.testCases;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.railwayGeneralTicketing.beans.ProfileBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.ProfileService;

public class TestGetProfile 
{
	ProfileBean profile=new ProfileBean();
	ProfileService profileService=ServiceFactory.getProfileService();
	
	@Test
	public void testGetProfile() throws SQLException
	{
		String employeeID="E1010";
					
		List<ProfileBean> profileList=profileService.getProfile(employeeID);
		profile=profileList.get(0);
		assertNotNull(profile);	
	}
}
