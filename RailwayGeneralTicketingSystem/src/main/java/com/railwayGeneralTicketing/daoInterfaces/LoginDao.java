package com.railwayGeneralTicketing.daoInterfaces;

import java.sql.SQLException;

import com.railwayGeneralTicketing.beans.LoginBean;

public interface LoginDao
{
	public abstract Character validateCounterPerson(LoginBean loginBean) throws SQLException;
	public abstract Character validateAdmin(LoginBean loginBean) throws SQLException;
}
