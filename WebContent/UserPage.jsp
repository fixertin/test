<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Your resume</title>
		<link type="text/css" rel="stylesheet" href="userStylesheet.css" />
		<link rel="stylesheet" type="text/css" media="all" href="reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="text.css" />
		<link rel="stylesheet" type="text/css" media="all" href="960.css" />
	</head>
	
	<body>
		<jsp:useBean id="counter" scope="session" class="com.fixertin.first.Model" />
	
		<div class="navbar">
			<div class="container_12">
				<h3 class="grid_12"><%=counter.getUser() %>'s resume</h3>
			</div>
		</div>
		<div class="content">
			<div class="container_12" id="name">
				<!-- ALIGNED TO THE MIDDLE WITH NO CONTAINER BACKGROUND --> 
				<h4 class="grid_11">
					<%=counter.getUser() %>
				</h4>
				<form>
					<input type="button" value="print" onClick="removeEdit('edit');window.print();" />
				</form>
			</div>
			
			<div class="container_12 details">
				<div class="grid_12">
					<h3> 
						Age: <%=counter.data.connect.getUserInfo(counter.getUser(), "AGE") %>
					</h3>
				</div>
				<div class="grid_12">
					<h3>Phone number: <%=counter.data.connect.getUserInfo(counter.getUser(), "PHONE_NUMBER") %></h3>
				</div>
				<div class="grid_12">
					<h3>Current Job: <%=counter.data.connect.getUserInfo(counter.getUser(), "CURRENT_JOB") %></h3>
				</div>
				<div class="grid_12">
					<h3>Company/school: <%=counter.data.connect.getUserInfo(counter.getUser(), "COMPANY_SCHOOL") %></h3>
				</div>
				<div class="grid_12">
					<h3>Email: <%=counter.data.connect.getUserInfo(counter.getUser(), "EMAIL") %></h3>
				</div>
			</div>
			
			<div class="container_12 about">
				<!-- ALIGNED TO LEFT WITH CONTAINER BACKGROUND -->
				<div class="grid_4">
					<div class="contentElement">
						<h2>Skills</h2>
						<ol>
							<%for(int i=0; i< counter.getTempSize(counter.getUser(), "ALL_SKILLS"); i++){ %>
								<%=counter.getSpecificElementData(counter.getUser(), "ALL_SKILLS", i) %>
							<% } %> 
						</ol>
					</div>
				</div>
				<div class="grid_4">
					<div class="contentElement">
						<h2>Goals</h2>
						<ol>
							<%for(int i=0; i< counter.getTempSize(counter.getUser(), "ALL_GOALS"); i++){ %>
								<%=counter.getSpecificElementData(counter.getUser(), "ALL_GOALS", i) %>
							<% } %>
						</ol>
					</div>
				</div>
				<div class="grid_4">
					<div class="contentElement">
						<h2>Interests</h2>
						<ol>
							<%for(int i=0; i< counter.getTempSize(counter.getUser(), "ALL_INTERESTS"); i++){ %>
								<%=counter.getSpecificElementData(counter.getUser(), "ALL_INTERESTS", i) %>
							<% } %>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
		<div class="contentButtons" id="edit">
			<div class="container_12">
				<div class="grid_12">
					<h4>Use buttons below to edit your resume.</h4>
				</div>
				<a href="SkillsEdit.jsp">
					<div class="grid_4 push_1">
						<h3 class="button">EDIT</h3>
					</div>
				</a>
				<a href="EditGoals.jsp">
					<div class="grid_4 push_1">
						<h3 class="button">EDIT</h3>
					</div>
				</a>
				<a href="EditInterests.jsp">
					<div class="grid_4 push_1">
						<h3 class="button">EDIT</h3>
					</div>
				</a>
			</div>
		</div>
		<script type="text/javascript" src="jquery.js"></script>
		<script>
			function removeEdit(edit) {
			       var e = document.getElementById(edit);
			       e.style.display = 'none';
			}
		</script>
	</body>
</html>