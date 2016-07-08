<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link type="text/css" rel="stylesheet" href="adminStylesheet.css" />
		<link rel="stylesheet" type="text/css" media="all" href="reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="text.css" />
		<link rel="stylesheet" type="text/css" media="all" href="960.css" />
	</head>
	
	<body>
		<jsp:useBean id="counter" scope="session" class="com.fixertin.first.Model" />
	
	
		<div class="navbar">
			<div class="container_12">
				<h3>Login</h3>
			</div>
		</div>
		
		<div class="login">
			<div class="container_12" id="loginForms">
				<form name="loginForm" method="post" action="WebsiteServlet">
				    <p class="grid_12">
				    	<label>Username</label>
				    	<% System.out.println(counter.getFailed()); %>
				    	<%if(request.getParameter("invalid").equalsIgnoreCase("true")){%>
				    		<%="Your username or password is invalid, please try again." %>
				    	<% } %>
				    	
				    	<br/>
				    	<input type="text" name="username"/> <br/>
    				</p>
    				<p class="grid_12">
    					<label>Password </label> <br/>
    					<input type="password" name="password"/> <br/>	
					</p>
					<p class="grid_12">
						<input type="submit" value="Login" />
					</p>
				</form>
			</div>
		</div>
		
		<div class="container_12">
			<div class="grid_12">
				<h1>Don't have an account? Register <a href="RegisterPage.jsp?invalid=false">HERE</a>!</h1>
			</div>
		</div>
		
	</body>
</html>