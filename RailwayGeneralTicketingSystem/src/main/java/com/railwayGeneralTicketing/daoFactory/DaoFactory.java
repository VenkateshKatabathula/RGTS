package com.railwayGeneralTicketing.daoFactory;

import com.railwayGeneralTicketing.daoImplementations.BookDaoImplementation;
import com.railwayGeneralTicketing.daoImplementations.LoginDaoImplementation;
import com.railwayGeneralTicketing.daoImplementations.ProfileDaoImplementation;
import com.railwayGeneralTicketing.daoImplementations.TicketDaoImplementation;
import com.railwayGeneralTicketing.daoImplementations.TrainDaoImplementation;
import com.railwayGeneralTicketing.daoInterfaces.BookDao;
import com.railwayGeneralTicketing.daoInterfaces.LoginDao;
import com.railwayGeneralTicketing.daoInterfaces.ProfileDao;
import com.railwayGeneralTicketing.daoInterfaces.TicketDao;
import com.railwayGeneralTicketing.daoInterfaces.TrainDao;

public class DaoFactory 
{
	private static LoginDao loginDao=null;
	private static ProfileDao profileDao=null;
	private static TicketDao ticketDao=null;
	private static TrainDao trainDao=null;
	private static BookDao bookDao=null;
	
	public static LoginDao getLoginDao()
	{
		if(loginDao==null)
		{
			loginDao=new LoginDaoImplementation();
		}
		
		return loginDao;
	}
	
	public static ProfileDao getProfileDao()
	{
		if(profileDao==null)
		{
			profileDao=new ProfileDaoImplementation();
		}
		
		return profileDao;
	}
	
	public static TicketDao getTicketDao()
	{
		if(ticketDao==null)
		{
			ticketDao=new TicketDaoImplementation();
		}
		
		return ticketDao;
	}	
	
	public static TrainDao getTrainDao()
	{
		if(trainDao==null)
		{
			trainDao=new TrainDaoImplementation();
		}
		
		return trainDao;
	}
	
	public static BookDao getBookDao()
	{
		if(bookDao==null)
		{
			bookDao=new BookDaoImplementation();
		}
		
		return bookDao;
	}
}
