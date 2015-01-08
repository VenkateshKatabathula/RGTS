package com.railwayGeneralTicketing.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.railwayGeneralTicketing.beans.ProfileBean;
import com.railwayGeneralTicketing.daoFactory.DaoFactory;
import com.railwayGeneralTicketing.daoInterfaces.ProfileDao;

public class ProfileService 
{
	public List<ProfileBean> getProfile(String employeeID) throws SQLException
	{
		ProfileDao profileDao=DaoFactory.getProfileDao();
		
		return profileDao.getProfile(employeeID);
	}
	
	public boolean updateProfile(ProfileBean profile) throws SQLException
	{
		ProfileDao profileDao=DaoFactory.getProfileDao();
		
		return profileDao.updateProfile(profile);
	}
}