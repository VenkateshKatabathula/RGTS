<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sale Ticket</title>
		<script type="text/javascript" >
		
			function validatePassengerName(a,b)
			{
				var exp=/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
				if(b!=""){
					if(!b.match(exp))
					{
						alert("Passenger name must not contain any digits or special characters except a blank space");
						 document.myform.passenger.value="";
					}
				}
			} 

			function validateRequirementsForm()
			{
				if(document.requirementsForm.passengerName.value=="")
				{
					alert("Passenger Name field must not be left blank");
					return false;
				}
						
				if(document.requirementsForm.source.value=="")
				{
					alert("Select your source");
					return false;
				}
				
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

	<body >
		
		<div id="header">
			<h1>RAILWAY GENERAL TICKETING</h1>
		</div>
		
		<div id="menu">
			<ul>
				<li><a style="visibility: hidden;">Home</a></li>
				<li><a href="./ProfileController">Profile</a></li>
				<li><a href="cp.html" style="visibility: hidden;">Sale Ticket</a></li>
				<li><a href="LoginPage.jsp" style="visibilty:hidden;">View Ticket</a></li>
				<li><a href="./LogoutController">Logout</a></li>	
			</ul>
		</div>
		
		<div class="ticket">
			<jsp:useBean id="ticket" scope="application" class="com.railwayGeneralTicketing.beans.TicketBean"/>
				<form action="ShowTrainsController" name="requirementsForm" method="get" 
					target="_top" onsubmit="return validateRequirementsForm()">
					<table border="0" align="center" width="50%" cellpadding="7">
						<tr></tr>
						<tr></tr>
						<tr></tr>						
						<tr>
							<td>Passenger Name:</td>
							<td><input type="text" name="passengerName" onblur="validatePassengerName(this.id,this.value)"></td>
						</tr>
						<tr>
							<td>Source:</td>
							<td><select id="source" name="source" >
									<option value="HYD" selected="selected">Hyderabad</option>
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
							<td>Destination:</td>
							<td><select id="destination" name="destination">
									<option value="HYD" selected="selected">Hyderabad</option>
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
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						
						<tr>
							<td><input type="submit" value="Show Available Trains" onfocus="validateRequirementsForm()"></td>
						</tr>
					</table>
				</form>
		</div>
				
		<div id="img">
 			<img src="TrainLoginPage.jpg"/>
		</div>
	
	</body>
</html>