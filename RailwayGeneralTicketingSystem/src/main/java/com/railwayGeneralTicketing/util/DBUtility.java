package com.railwayGeneralTicketing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
{
	//Method definition to establish connection with the database 
	public static Connection getConnection() throws SQLException
	{
		Connection connection=null;
		
		//Loading the Type 4 Driver Class
		/*DriverManager.registerDriver(new oracle.jdbc.OracleDriver());*/
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		//Establishing the connection
		/*connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RGTSDATABASE","rgtsdata");*/
		connection=DriverManager.getConnection("jdbc:oracle:thin:@hstslc015:1521:elp","elp1115","msat123$");
				
		return connection;
	}
	
	//Method definition to close the connection established
	public static void closeConnection(Connection connection) throws SQLException
	{
		if(connection!=null)
		{
			connection.close();
		}
	}
}
