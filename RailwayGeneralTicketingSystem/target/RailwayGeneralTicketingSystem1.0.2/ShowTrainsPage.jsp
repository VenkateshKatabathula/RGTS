<%@page import="java.util.Iterator"%>
<%@page import="com.railwayGeneralTicketing.beans.TrainBean"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Select Train</title>
		
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
			
			div.showTrains{
				color: white;
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
				<li><a style="visibility: hidden;">Home</a></li>
				<li><a href="./ProfileController">Profile</a></li>
				<li><a href="cp.html" style="visibility: hidden;">Sale Ticket</a></li>
				<li><a href="LoginPage.jsp" style="visibility: hidden;">View Ticket</a></li>
				<li><a href="./LogoutController">Logout</a></li>	
			</ul>
		</div>
		
		<div class="showTrains">
			<%ArrayList<TrainBean> trains=(ArrayList<TrainBean>)request.getAttribute("trainsList"); %>
			<%Iterator<TrainBean> itr=trains.iterator();
				if(itr.hasNext())
				{%>
			<form method="get" name="form">
				<table border="0" cellpadding="7" width="50%" align="center">
					<tr>
						<td></td>
						<td>Train Number</td>
						<td>Train Name</td>
						<td>Seats Available</td>
						<td>Fare Per Person</td>
					</tr>
				<%
					while(itr.hasNext())
					{
						TrainBean train=(TrainBean)itr.next();	
					%>
					
					<tr>
						<td><input type="radio" value="<%out.print(train.getTrainNumber()); %>" name="trainNumber" checked="checked"/></td>
						<td><%out.println(train.getTrainNumber()); %></td>
						<td><%out.println(train.getTrainName()); %></td>
						<td><%out.println(train.getNumberOfSeats()); %></td>
						<%System.out.println(train.getNumberOfSeats());%>
						<td><%out.println(train.getFareOfTicket()); %></td>
					</tr>
					
					<%} %>
					
					<tr>
						<td><input type="submit" value="Book Ticket" onclick="javascript:form.action='BookTicketController';"/></td>
						<td><input type="submit" value="Back" onclick="javascript:form.action='SaleTicketPage.jsp';"/>
					</tr>
				</table>
			</form>
			 <%}
			   else
			   {%>
					<h1 align="center">No Trains Available Now</h1>
					<form action="SaleTicketPage.jsp" method="get">
						<input type="submit" value="Sale Another Ticket"/>
					</form>
			 <%} %>
		</div>
		
		<div id="img">
 			<img src="TrainLoginPage.jpg"/>
		</div>
	</body>
</html>