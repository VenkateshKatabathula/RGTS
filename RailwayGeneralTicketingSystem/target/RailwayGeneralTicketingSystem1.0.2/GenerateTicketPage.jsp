<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ticket Generated</title>
		
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
			
			div.generateTicket{
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
	<body onload="changeHashOnLoad();">
		
		<div id="header">
			<h1>RAILWAY GENERAL TICKETING</h1>
		</div>
		
		<div id="menu">
			<ul>
				<li><a style="visibility: hidden;">Home</a></li>
				<li><a href="./ProfileController">Profile</a></li>
				<li><a href="SaleTicketPage.jsp">Sale Ticket</a></li>
				<li><a href="LoginPage.jsp" style="visibility: hidden;">View Ticket</a></li>
				<li><a href="./LogoutController" >Logout</a></li>	
			</ul>
		</div>
		
		<div class="generateTicket">
			<%-- <%ArrayList<String> ticketDetails=(ArrayList<String>)request.getAttribute("ticketDetails");%> --%>
			<jsp:useBean id="generatedTicket" scope="application" class="com.railwayGeneralTicketing.beans.GeneratedTicketBean"/>
			<jsp:useBean id="ticket" scope="application" class="com.railwayGeneralTicketing.beans.TicketBean"/>

			<table align="center" border="0" cellpadding="7" width="50%">
				<tr align="center">
					<td>Ticket Number</td>
					<td>Passenger name</td>
					<td>Source</td>
					<td>Destination</td>
					<!-- <td>Ticket Type</td> -->
					<td>Number of Tickets</td>
					<td>Date of Journey</td>
					<!-- <td>Trip</td> -->
					<td>Train Number</td>
					<td>Train Name</td>
					<td>Departure</td>
					<td>Fare per Person</td>
					<td>Total Fare</td>
				</tr>
				<tr align="center">
					<td><jsp:getProperty property="ticketNumber" name="generatedTicket"/></td>
					<td><jsp:getProperty property="passengerName" name="generatedTicket"/></td>
					<td><jsp:getProperty property="source" name="generatedTicket"/></td>
					<td><jsp:getProperty property="destination" name="generatedTicket"/></td>
					<td><jsp:getProperty property="numberOfTickets" name="generatedTicket"/></td>
					<td><jsp:getProperty property="dateOfJourney" name="generatedTicket"/></td>
					<td><jsp:getProperty property="trainNumber" name="generatedTicket"/></td>
					<td><jsp:getProperty property="trainName" name="generatedTicket"/></td>
					<td><jsp:getProperty property="departureTime" name="generatedTicket"/></td>
					<td><jsp:getProperty property="farePerPerson" name="generatedTicket"/></td>
					<td><jsp:getProperty property="totalFare" name="generatedTicket"/></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr align="center">
					<td colspan="10"><h2>Ticket booked successfully</h2></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
			</table>
			
			<c:if test="${ticket.ticketType=='F'}">
			<form action="SaleReturnTicketController" method="get">
			<table align="center" border="0" cellpadding="7" width="50%">
				<tr>
					<td><input type="hidden" name="ticketNumber" value="<jsp:getProperty property="ticketNumber" name="generatedTicket"/>"></td>
					<td colspan="2"><input type="submit" value="Book Return Ticket Here" name="returnTicket"></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
			</table>
			</form>
			</c:if>
		</div>
		
		<div id="img">
 			<img src="TrainLoginPage.jpg"/>
		</div>
	</body>
</html>