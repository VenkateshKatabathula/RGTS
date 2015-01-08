package com.railwayGeneralTicketing.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railwayGeneralTicketing.beans.ProfileBean;
import com.railwayGeneralTicketing.serviceFactory.ServiceFactory;
import com.railwayGeneralTicketing.services.ProfileService;

//Servlet implementation class ModifyProfileController
@WebServlet("/ModifyProfileController")
public class ModifyProfileController extends HttpServlet 
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userName=request.getParameter("emp_id");
               
        ProfileBean profile=new ProfileBean();
              
        ProfileService profileService=ServiceFactory.getProfileService();
        List<ProfileBean> profileDetails;
        
        try 
		{
			profileDetails = profileService.getProfile(userName);
				
			/*while(profileDetails.next())
			{
				
				profile.setEmployeeID(profileDetails.getString("EMPLOYEE_ID"));
				profile.setEmployeeName(profileDetails.getString("EMPLOYEE_NAME"));
				profile.setStation(profileDetails.getString("STATION_ID"));
				profile.setRole((profileDetails.getString("ROLE")).charAt(0));
				profile.setAddress(profileDetails.getString("ADDRESS"));
				profile.setPhoneNumber(profileDetails.getLong("CONTACT_NO"));
			}*/
			
			profile=profileDetails.get(0);
			
		}
        
        catch (SQLException sqle) 
        {
				sqle.printStackTrace();
		}
        	
        request.setAttribute("profile",profile);
        	
        RequestDispatcher rd=request.getRequestDispatcher("ModifyProfilePage.jsp");
        rd.forward(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		processRequest(request,response);
	}
	
	public String getServletInfo() 
	{
		String description="Description of ModifyProfileController";
		return description; 
	}
}
