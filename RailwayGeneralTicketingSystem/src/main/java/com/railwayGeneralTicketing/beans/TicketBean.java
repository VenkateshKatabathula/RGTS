package com.railwayGeneralTicketing.beans;

public class TicketBean 
{
	private int ticketNumber;
	private String passengerName;
	private String source;
	private String destination;
	private String ticketType; 
	
	public String getTicketType()
	{
		return ticketType;
	}

	public void setTicketType(String ticketType) 
	{
		this.ticketType = ticketType;
	}

	private int numberOfTickets;
	
	public TicketBean() 
	{
		super();
	}

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

	/*public char getTicketType() 
	{
		return ticketType;
	}

	public void setTicketType(char ticketType) 
	{
		this.ticketType = ticketType;
	}*/

	public int getNumberOfTickets() 
	{
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) 
	{
		this.numberOfTickets = numberOfTickets;
	}	
}
