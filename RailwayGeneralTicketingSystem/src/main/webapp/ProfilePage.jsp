<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Profile</title>
		
		<script type="text/javascript" src="DisableBackButton.js"></script>
		
		<style>
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
			
			div.details{
				color: white;
			}
			
			div.details form{
				margin-left: 250px;
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
<body onload="changeHashOnLoad();">

	<div id="header">
			<h1>RAILWAY GENERAL TICKETING</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="HomePage.html" style="visibility: hidden;">Home</a></li>
				<li><a href="./ProfileController">Profile</a></li>
				<li><a href="SaleTicketPage.jsp">Sale Ticket</a></li>
				<li><a href="LoginPage.jsp" style="visibility: hidden;">View Ticket</a></li>
				<li><a href="./LogoutController" >Logout</a></li>
			</ul>
			
		</div>
		<div class="details">
			<jsp:useBean id="profile" scope="application" class="com.railwayGeneralTicketing.beans.ProfileBean"/>
				<table border="0" cellpadding="7" width="50%" align="center">
					<tr>
						<td>Employee ID:</td>
						<td><jsp:getProperty property="employeeID" name="profile"/></td>
					</tr>
					<tr>
						<td>Employee Name:</td>
						<td><jsp:getProperty property="employeeName" name="profile"/></td>
					</tr>
					<tr>
						<td>Station:</td>
						<td><jsp:getProperty property="station" name="profile"/></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><jsp:getProperty property="role" name="profile"/></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><jsp:getProperty property="address" name="profile"/></td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><jsp:getProperty property="phoneNumber" name="profile"/></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					
				</table>
				
				<form action="ModifyProfileController" method="get" name="form">
				
				<input type="submit" value="Modify Details" align="bottom"/>
				<input type="text" name="emp_id" style="visibility: hidden;" value="<jsp:getProperty property="employeeID" name="profile"/>"/>
			</form>
				
		</div>
			
		<div id="img">
			<img src="TrainLoginPage.jpg"/>
		</div>
	
</body>
</html>