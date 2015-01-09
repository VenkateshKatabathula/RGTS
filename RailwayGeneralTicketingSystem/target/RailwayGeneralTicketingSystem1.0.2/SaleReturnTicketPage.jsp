<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Sale Return Ticket</title>
		
		<script type="text/javascript">		
		function validateRequirementsForm()
			{
				var d=new Date();
				if(document.requirementsForm.destination.value=="")
				{
					alert("Select your destination");
					return false;
				}
				
				if(document.requirementsForm.source.value==document.requirementsForm.destination.value)
				{
					alert("Both source and destination cannot be same")
					return false;
				}
				
				if(document.requirementsForm.source.value=="HYD" && document.requirementsForm.destination.value=="SC")
				{
					alert("No trains from Hyderabad to Secunderabad");
					return false;
				}
				
				if(document.requirementsForm.source.value=="SC" && document.requirementsForm.destination.value=="HYD")
				{
					alert("No trains from Secunderabad to Hyderabad");
					return false;
				}
				
				if(document.requirementsForm.year.value==d.getFullYear())
				{
					if((document.requirementsForm.month.value)==d.getMonth())
					{
						if((document.requirementsForm.date.value)<d.getDate())
						{
							alert("Please select a future date");
							return false;
						}
					}
					else if((document.requirementsForm.month.value)<d.getMonth())
					{
						alert("Please select a present or a future month");
						return false;
					}
				}
				else if(document.requirementsForm.year.value<d.getFullYear())
				{
					alert("Please select the present year or a future year");
					return false;
				}
				
				return true; 
			}
		</script>
		
		<style>
			
			body{
				overflow:hidden;
			}
		
			#header {
				padding: 30px 0 30px;
				margin: 0px;
				background-color: #DC6A50;
				color: white;
				text-align: center;
			}

 			#menu {
			   	width: auto;
			    height: 35px;
			    font-size: 16px;
			    font-family: Tahoma, Geneva, sans-serif;
			    font-weight: bold;
			    text-align: center;
			    text-shadow: 3px 2px 3px #333333;
			    background-color: #101010 ;
			}

			#menu ul {
			    height: auto;
			    padding: 8px 0px;
			    margin: 0px;
			}
			
			#menu li { 
			display: inline; 
			padding: 20px; 
			}
			
			#menu a:link,a:visited {
			    text-decoration: none;
			    color: #FFFFFF;
			    padding: 8px 8px 8px 8px;
			}
			
			#menu a:hover {
			    color: #F90;
			    background-color: #B8B8B8 ;
			}
			
			#menu a:hover,a:active {
				background-color: #7A991A;
			}
			
			div.ticket{
				color:white;
			}
			
			#img{
				width:100%;
			}
			
			#img img{
			 	width: 98.88%;
    			height: 100%;
    			max-height: 650px; 
    			opacity: 0.4;
    			filter: alpha(opacity=80);
    			position: absolute;
    			top: 182px;
    			z-index: -1;
			}
 		</style>
	</head>
	
	<body>
			
		<div id="header">
			<h1>RAILWAY GENERAL TICKETING</h1>
		</div>
		
		<div id="menu">
			<ul>
				<li><a style="visibility: hidden;">Home</a></li>
				<li><a href="./ProfileController">Profile</a></li>
				<li><a href="cp.html" style="visibility: hidden;">Sale Ticket</a></li>
				<li><a href="LoginPage.jsp" style="visibility: hidden;">View Ticket</a></li>
				<li><a href="./LogoutController" >Logout</a></li>	
			</ul>
		</div>
		
		<div class="ticket">
			<jsp:useBean id="ticket" scope="application" class="com.railwayGeneralTicketing.beans.TicketBean"/>
				<form action="ShowReturnTrainsController" name="requirementsForm" method="get" 
					target="_top" onsubmit="return validateRequirementsForm()">
					<table border="0" align="center" width="50%" cellpadding="7">
						<tr></tr>
						<tr></tr>
						<tr></tr>						
						<tr>
							<td>Passenger Name:</td>
							<td><jsp:getProperty property="passengerName" name="ticket"/></td>
						</tr>
						<tr>
							<td>Source:</td>
							<td><jsp:getProperty property="destination" name="ticket"/></td>
						</tr>
						<tr>
							<td>Destination:</td>
							<td><select id="destination" name="destination">
									<option value="<jsp:getProperty property="source" name="ticket"/>" selected="selected"><jsp:getProperty property="source" name="ticket"/></option>
									<option value="HYD">Hyderabad</option>
									<option value="SC">Secunderabad</option>
									<option value="WL">Warangal</option>
									<option value="BZA">Vijayawada</option>
									<option value="EE">Eluru</option>
									<option value="RJY">Rajahmundry</option>
									<option value="VSKP">Visakhapatnam</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Number of Tickets:</td>
							<td><input type="text" name="numberOfTickets" value="1"></td>
						</tr>
						<tr>
							<td>Date of return journey:</td>
							<td>
								<select name="date">
									<c:forEach var="dd" begin="1" end="31" step="1">
										<option value="${dd}">${dd}</option>
									</c:forEach>		 	
								</select>
								<select name="month">
									<option value="0">January</option>
									<option value="1">February</option>
									<option value="2">March</option>
									<option value="3">April</option>
									<option value="4">May</option>
									<option value="5">June</option>
									<option value="6">July</option>
									<option value="7">August</option>
									<option value="8">September</option>
									<option value="9">October</option>
									<option value="10">November</option>
									<option value="11">December</option>											 	
								</select> 
								<select name="year">
									<option value="2014" selected="selected">2014</option>
									<option VALUE="2015">2015</option>
								</select>								
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						
						<tr>
							<td><input type="submit" value="Show Available Trains" onfocus="validateRequirementsForm()"></td>
							<td><input type="hidden" name="passengerName" value="<jsp:getProperty property="passengerName" name="ticket"/>"/></td>
							<td><input type="hidden" name="source" value="<jsp:getProperty property="destination" name="ticket"/>"/></td>
						</tr>
					</table>
				</form>
		</div>
				
		<div id="img">
 			<img src="TrainLoginPage.jpg"/>
		</div>
	</body>
</html>