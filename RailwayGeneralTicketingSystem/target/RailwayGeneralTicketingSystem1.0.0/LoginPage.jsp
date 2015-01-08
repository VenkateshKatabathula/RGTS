<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LOGIN PAGE</title>
	
	<script type="text/javascript" >
		function validateLoginForm()
		{
			var username=document.LoginForm.userName.value;
			var password=document.LoginForm.password.value;
			var pattern=/[^0-9]/;
			
			if(username=="")
			{
				alert("Username column must not be left blank");
				return false;
			}
			else if(username.length!=5)
			{
				alert("Username must consist of five characters only");
				return false;
			}
			else if(username.charAt(0)!='E')
			{
				alert("Username must start with the letter 'E' ");
				return false;
			}
			else if(pattern.test(username.substring(1,4)))
			{
				alert("Username must have 4 digits following the letter 'E' ");
				return false;
			}
			
			if(password=="")
			{
				alert("Password column must not be left blank");
				return false;
			}
			else if((password.length<6) || (password.length>8))
			{
				alert("Password must be six to eight characters");
				return false;
			}
			return true;
		}
	</script>
	
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
			
			div.login{
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

<body >

	<div id="header">
			<h1>RAILWAY GENERAL TICKETING</h1>
	</div>
	
	<div id="menu">
		<ul>
			<li><a href="HomePage.html" style="visibility: hidden;">Home</a></li>
			<li><a href="./ProfileController" style="visibility: hidden;">Profile</a></li>
			<li><a href="cp.html" style="visibility: hidden;">Sale Ticket</a></li>
			<li><a href="cp.html" style="visibility: hidden;">Sale Ticket</a></li>
		</ul>
	</div>
	
	<div class="login">
		<h2 align="center">Please Enter your Login Credentials</h2>
	
		<form action="LoginController" method="post" name="LoginForm" 
			target="_top" onsubmit="return validateLoginForm();">
		
			<table border="0" align="center" cellpadding="7" width="50%">
			
				<tr>
					<td>Username:</td>
					<td><input type="text" name="userName"></td>
				</tr>
			
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
			
				<tr align="left">
					<td><input type="submit" value="Login" name="Login"></td>
					<td><input type="reset" value="Reset" name="Reset"></td>
				</tr>
			
			</table>
		
		</form>
	</div>
	
	<div id="img">
			<img src="TrainLoginPage.jpg"/>
	</div>
	
</body>
</html>