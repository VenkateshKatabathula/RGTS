package com.railwayGeneralTicketing.testCases;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.railwayGeneralTicketing.beans.LoginBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.LoginService;

public class TestLoginCredentials 
{
	LoginBean loginCredentials=new LoginBean();
	LoginService loginService=ServiceFactory.getLoginService();
	
	//Test to check validateUser() method in LoginService class
	@Test
	public void testValidateUser() throws SQLException
	{
		loginCredentials.setUserName("E1001");
		loginCredentials.setPassword("VK001001");
		
		Character role=loginService.validateUser(loginCredentials);
		String roleOfEmployee=role.toString();
		assertEquals("C",roleOfEmployee);		
	}
}
