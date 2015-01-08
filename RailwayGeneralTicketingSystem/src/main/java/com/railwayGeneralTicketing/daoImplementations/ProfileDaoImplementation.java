package com.railwayGeneralTicketing.daoImplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.railwayGeneralTicketing.beans.ProfileBean;
import com.railwayGeneralTicketing.daoInterfaces.ProfileDao;
import com.railwayGeneralTicketing.util.DBUtility;

public class ProfileDaoImplementation implements ProfileDao
{
	@Override
	public List<ProfileBean> getProfile(String employeeID) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement getProfileDetails=null;
		ResultSet profileDetails=null;
		List<ProfileBean> profileOfEmployee;
		
		try
		{
			connection=DBUtility.getConnection();
		
			getProfileDetails=connection.prepareStatement("SELECT * FROM EMPLOYEE_RGTS WHERE EMPLOYEE_ID='"+employeeID+"'");
		
			profileDetails=getProfileDetails.executeQuery();	
		
			profileOfEmployee=new ArrayList<ProfileBean>();
		
			while(profileDetails.next())
			{
				ProfileBean profile=new ProfileBean(); 
			
				profile.setEmployeeID(profileDetails.getString("EMPLOYEE_ID"));
				profile.setEmployeeName(profileDetails.getString("EMPLOYEE_NAME"));
				profile.setStation(profileDetails.getString("STATION_ID"));
				profile.setRole((profileDetails.getString("ROLE")).charAt(0));
				profile.setAddress(profileDetails.getString("ADDRESS"));
				profile.setPhoneNumber(profileDetails.getLong("CONTACT_NO"));
			
				profileOfEmployee.add(profile);
			}
		}
		
		finally
		{
			profileDetails.close();
			getProfileDetails.close();
			DBUtility.closeConnection(connection);
		}
		
		return profileOfEmployee;		
	}

	@Override
	public boolean updateProfile(ProfileBean profile) throws SQLException 
	{
		Connection connection=null;
		Boolean updatedProfile=null;
		PreparedStatement updateAddress=null;
		ResultSet updatedAddress=null;
		PreparedStatement updateContact=null;
		ResultSet updatedContact=null;
		
		try
		{
			connection=DBUtility.getConnection();
		
			updateAddress=connection.prepareStatement("UPDATE EMPLOYEE_RGTS SET ADDRESS=? WHERE EMPLOYEE_ID=?");
			updateAddress.setString(1,profile.getAddress());
			updateAddress.setString(2,profile.getEmployeeID());
			
			updatedAddress=updateAddress.executeQuery();
			
			updateContact=connection.prepareStatement("UPDATE EMPLOYEE_RGTS SET CONTACT_NO=? WHERE EMPLOYEE_ID=?");
			updateContact.setLong(1, profile.getPhoneNumber());
			updateContact.setString(2,profile.getEmployeeID());
			
			updatedContact=updateContact.executeQuery();
			
			if(updatedAddress.next() && updatedContact.next())
			{
				updatedProfile=true;
			}
			else
			{
				updatedProfile=false;
			}	
		}
		
		finally
		{
			updateAddress.close();
			updateContact.close();
			
			updatedAddress.close();
			updatedContact.close();
			
			DBUtility.closeConnection(connection);
		}
			
		return updatedProfile;
	}
}