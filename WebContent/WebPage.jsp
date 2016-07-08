<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="stylesheet.css" />
		<link rel="stylesheet" type="text/css" media="all" href="reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="text.css" />
		<link rel="stylesheet" type="text/css" media="all" href="960.css" />
		<title>Alex Leisure's resume</title>
	</head>
	<body>
	
		<jsp:useBean id="counter" scope="session" class="com.fixertin.first.Model" />
		
	
		
		<div class="navbar">
			<div class="container_12">
				<h3 class="grid_11">Alex Leisure's resume</h3>
				<h3 class="grid_1"><a href="AdminLoginPage.jsp?invalid=false">Login</a></h3>
			</div>
		</div>
		<div class="content">
			<div class="container_12" id="name">
				<!-- ALIGNED TO THE MIDDLE WITH NO CONTAINER BACKGROUND --> 
				<h4 class="grid_10">Alex Leisure</h4>
				<div class="grid_2" id="parent">
					<h4 class="popupButton">What is this?</h4>
					<div class="popup" id="popup">
						<p>
							This is a website I made for an internship with a company called Jackson. This is a website that allows you to make a small resume. What you see now is a small example of mine.
						</p>
					</div>
				</div>
			</div>
			
			<div class="container_12 about">
				<!-- ALIGNED TO LEFT WITH CONTAINER BACKGROUND -->
				<div class="grid_4">
					<div class="contentElement">
						<h2>Skills</h2>
						<ol>
							<%for(int i=0; i< counter.getSize(counter.getSkills()); i++){ %>
								<%=counter.getElement(counter.getSkills(), i) %>
							<% } %>
						</ol>
					</div>
				</div>
				<div class="grid_4">
					<div class="contentElement">
						<h2>Goals</h2>
						<ol>
							<%for(int i=0; i< counter.getSize(counter.getGoals()); i++){ %>
								<%=counter.getElement(counter.getGoals(), i) %>
							<% } %>
						</ol>
					</div>
				</div>
				<div class="grid_4">
					<div class="contentElement">
						<h2>Interests</h2>
						<ol>
							<%for(int i=0; i< counter.getSize(counter.getInterests()); i++){ %>
								<%=counter.getElement(counter.getInterests(), i) %>
							<% } %>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript" src="script.js"></script>
	</body>
</html>