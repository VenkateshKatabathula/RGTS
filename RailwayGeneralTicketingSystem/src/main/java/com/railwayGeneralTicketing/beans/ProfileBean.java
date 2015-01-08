package com.railwayGeneralTicketing.beans;

import java.math.BigDecimal;

public class ProfileBean 
{
	private String employeeID;
	private String employeeName;
	private String station;
	private char role;
	private String address;
	private long phoneNumber;
	
	public ProfileBean() 
	{
		super();
		
	}

	public String getEmployeeID() 
	{
		return employeeID;
	}

	public void setEmployeeID(String employeeID) 
	{
		this.employeeID = employeeID;
	}

	public String getEmployeeName() 
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}

	public String getStation() 
	{
		return station;
	}

	public void setStation(String station) 
	{
		this.station = station;
	}

	public char getRole() 
	{
		return role;
	}

	public void setRole(char role) 
	{
		this.role = role;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public long getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	
}
