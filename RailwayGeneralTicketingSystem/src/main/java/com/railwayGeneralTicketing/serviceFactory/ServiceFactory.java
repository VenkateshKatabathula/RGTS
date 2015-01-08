package com.railwayGeneralTicketing.serviceFactory;

import com.railwayGeneralTicketing.services.BookService;
import com.railwayGeneralTicketing.services.LoginService;
import com.railwayGeneralTicketing.services.ProfileService;
import com.railwayGeneralTicketing.services.TicketService;
import com.railwayGeneralTicketing.services.TrainService;

public class ServiceFactory 
{
	private static LoginService loginService=null;
	private static ProfileService profileService=null;
	private static TicketService ticketService=null;
	private static TrainService trainService=null;
	private static BookService bookService=null;
	
	public static LoginService getLoginService()
	{
		if(loginService==null)
		{
			loginService=new LoginService();
		}
		
		return loginService;
	}
	
	public static ProfileService getProfileService()
	{
		if(profileService==null)
		{
			profileService=new ProfileService();
		}
		
		return profileService;
	}
	
	public static TicketService getTicketService()
	{
		if(ticketService==null)
		{
			ticketService=new TicketService();
		}
		
		return ticketService;
	}
	
	public static TrainService getTrainService()
	{
		if(trainService==null)
		{
			trainService=new TrainService();
		}
		
		return trainService;
	}
	
	public static BookService getBookService()
	{
		if(bookService==null)
		{
			bookService=new BookService();
		}
		
		return bookService;
	}
}
