package com.railwayGeneralTicketing.beans;

import java.util.Date;

public class GeneratedTicketBean 
{
	private int ticketNumber;
	private String passengerName;
	private String source;
	private String destination;
	private int numberOfTickets;
	private Date dateOfJourney;
	private String trainNumber;
	private String trainName;
	private int departureTime;
	private int farePerPerson;
	private int totalFare;
	
	public int getTicketNumber() 
	{
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) 
	{
		this.ticketNumber = ticketNumber;
	}

	public String getPassengerName() 
	{
		return passengerName;
	}

	public void setPassengerName(String passengerName)
	{
		this.passengerName = passengerName;
	}

	public String getSource() 
	{
		return source;
	}

	public void setSource(String source) 
	{
		this.source = source;
	}

	public String getDestination() 
	{
		return destination;
	}

	public void setDestination(String destination) 
	{
		this.destination = destination;
	}

	public int getNumberOfTickets() 
	{
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) 
	{
		this.numberOfTickets = numberOfTickets;
	}

	public GeneratedTicketBean() 
	{
		super();
	}

	public Date getDateOfJourney() 
	{
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) 
	{
		this.dateOfJourney = dateOfJourney;
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

	public int getDepartureTime() 
	{
		return departureTime;
	}

	public void setDepartureTime(int departureTime) 
	{
		this.departureTime = departureTime;
	}

	public int getFarePerPerson() 
	{
		return farePerPerson;
	}

	public void setFarePerPerson(int farePerPerson) 
	{
		this.farePerPerson = farePerPerson;
	}

	public int getTotalFare()
	{
		return totalFare;
	}

	public void setTotalFare(int totalFare) 
	{
		this.totalFare = totalFare;
	}
}
