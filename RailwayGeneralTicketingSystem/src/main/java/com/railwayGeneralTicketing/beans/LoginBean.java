package com.railwayGeneralTicketing.beans;

import java.io.Serializable;

public class LoginBean implements Serializable
{
	//instance variables of the class LoginBean
	private String userName;
	private String password;
	
	//Default constructor
	public LoginBean() 
	{
		super();
	}

	//Getter method to return userName
	public String getUserName() 
	{
		return userName;
	}
	
	//Setter method to set userName
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	//Getter method to return password
	public String getPassword() 
	{
		return password;
	}

	//Setter method to set userName
	public void setPassword(String password) 
	{
		this.password = password;
	}	
}