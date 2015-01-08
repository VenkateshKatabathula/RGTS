package com.railwayGeneralTicketing.daoInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.railwayGeneralTicketing.beans.ProfileBean;

public interface ProfileDao 
{
	public abstract List<ProfileBean> getProfile(String employeeID) throws SQLException;
	public abstract boolean updateProfile(ProfileBean profile) throws SQLException; 
}
