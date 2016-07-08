<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register</title>
		<link type="text/css" rel="stylesheet" href="registerStylesheet.css" />
		<link rel="stylesheet" type="text/css" media="all" href="reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="text.css" />
		<link rel="stylesheet" type="text/css" media="all" href="960.css" />
	</head>
	<body>
		<div class="navbar">
			<div class="container_12">
				<h3 class="grid_12">Register</h3>
			</div>
		</div>
		
		<div class="login">
			<div class="container_12" id="loginForms">
				<form name="loginForm" method="post" action="RegisterServlet">
				    <p class="grid_12">
				    	<label>Username</label> 
				    	<%if(request.getParameter("invalid").equalsIgnoreCase("true")){%>
				    		<%="Your username is invalid, please try again." %>
				    	<% } %>
				    	<br/>
				    	<input type="text" name="username"/> <br/>
    				</p>
    				<p class="grid_12">
    					<label>Password </label>
    					<input type="password" name="password"/> <br/>	
					</p>
					<p class="grid_12">
						<label>Age</label>
						<input type="text" name="age"/>
					</p>
					<p class="grid_12">
						<label>Phone number</label>
						<input type="text" name="phone"/>
					</p>
					<p class="grid_12">
						<label>Current job</label>
						<input type="text" name="job"/>
					</p>
					<p class="grid_12">
						<label>Company/School</label>
						<input type="text" name="company"/>
					</p>
					<p class="grid_12">
						<label>Email</label>
						<input type="text" name="email"/>
					</p>
					<p class="grid_12">
						<input type="submit" value="Register" />
					</p>
				</form>
			</div>
		</div>
	</body>
</html>