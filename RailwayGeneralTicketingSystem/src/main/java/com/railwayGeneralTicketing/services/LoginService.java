package com.railwayGeneralTicketing.services;

import java.sql.SQLException;

import com.railwayGeneralTicketing.beans.LoginBean;
import com.railwayGeneralTicketing.daoFactory.DaoFactory;
import com.railwayGeneralTicketing.daoInterfaces.LoginDao;

public class LoginService 
{
	public Character validateUser(LoginBean loginBean) throws SQLException
	{
		Character role=null;
		
		LoginDao loginDao=DaoFactory.getLoginDao();
		
		if((loginDao.validateCounterPerson(loginBean))=='C')
		{
			role='C';
		}
		else if((loginDao.validateAdmin(loginBean))=='A')
		{
			role='A';
		}
		else
		{
			role='N';
		}
		return role;
	}
}
