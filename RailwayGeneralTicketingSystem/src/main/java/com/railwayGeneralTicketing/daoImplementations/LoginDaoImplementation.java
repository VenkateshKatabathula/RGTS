package com.railwayGeneralTicketing.daoImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.railwayGeneralTicketing.beans.LoginBean;
import com.railwayGeneralTicketing.daoInterfaces.LoginDao;
import com.railwayGeneralTicketing.util.DBUtility;

public class LoginDaoImplementation implements LoginDao
{
	@Override 
	public Character validateCounterPerson(LoginBean loginBean) throws SQLException 
	{
		Character role='N';
		
		//Invoking the method getConnection() to load the driver and establish connection 
		Connection connection=DBUtility.getConnection();
		
		//Prepared Statement 
		PreparedStatement getCredentials=connection.prepareStatement("SELECT EMPLOYEE_ID,PASSWORD,ROLE FROM EMPLOYEE_RGTS WHERE EMPLOYEE_ID=? AND PASSWORD=? AND ROLE='C'");
		
		getCredentials.setString(1, loginBean.getUserName());
		getCredentials.setString(2,loginBean.getPassword());
		
		ResultSet rs=getCredentials.executeQuery();
		
		if(rs.next())
		{
			role=(rs.getString(3)).charAt(0);
		}
		else
		{
			role='N';
		}
		
		//Closing the ResultSet
		rs.close();
				
		//Closing the PreparedStatement
		getCredentials.close();
		
		//Invoking the method closeConnection() to disconnect the established connection
		DBUtility.closeConnection(connection);
		
		//To return the role
		return role;
	}

	@Override
	public Character validateAdmin(LoginBean loginBean) throws SQLException 
	{
		Character role='N';
	
		//Invoking the method getConnection() to load the driver and establish connection 
		Connection connection=DBUtility.getConnection();
	
		//Prepared Statement 
		PreparedStatement getCredentials=connection.prepareStatement("SELECT EMPLOYEE_ID,PASSWORD,ROLE FROM EMPLOYEE_RGTS WHERE EMPLOYEE_ID=? AND PASSWORD=? AND ROLE='A'");
	
		getCredentials.setString(1, loginBean.getUserName());
		getCredentials.setString(2,loginBean.getPassword());
	
		ResultSet rs=getCredentials.executeQuery();
	
		if(rs.next())
		{
			role=(rs.getString(3)).charAt(0);
		}
		else
		{
			role='N';
		}
	
		//Closing the ResultSet
		rs.close();
		
		
		//Closing the PreparedStatement
		getCredentials.close();
		
		//Invoking the method closeConnection() to disconnect the established connection
		DBUtility.closeConnection(connection);
		
		//To return the role
		return role;
	}
}
