package com.railwayGeneralTicketing.beans;

import java.io.Serializable;

public class TrainBean implements Serializable
{
	private String trainNumber;
	private String trainName;
	private String sdCode;
	private int  numberOfCoaches;
	private int  numberOfSeats;
	private int fareOfTicket;
	
	public TrainBean()
	{
		super();
	}

	public String getTrainNumber() 
	{
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) 
	{
		this.trainNumber = trainNumber;
	}

	public String getTrainName() 
	{
		return trainName;
	}

	public void setTrainName(String trainName) 
	{
		this.trainName = trainName;
	}

	public String getSdCode() 
	{
		return sdCode;
	}

	public void setSdCode(String sdCode) 
	{
		this.sdCode = sdCode;
	}

	public int getNumberOfCoaches() 
	{
		return numberOfCoaches;
	}

	public void setNumberOfCoaches(int numberOfCoaches) 
	{
		this.numberOfCoaches = numberOfCoaches;
	}

	public int getNumberOfSeats() 
	{
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) 
	{
		this.numberOfSeats = numberOfSeats;
	}

	public int getFareOfTicket() 
	{
		return fareOfTicket;
	}

	public void setFareOfTicket(int fareOfTicket) 
	{
		this.fareOfTicket = fareOfTicket;
	}

}
