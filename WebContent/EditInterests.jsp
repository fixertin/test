<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Interests</title>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<link rel="stylesheet" type="text/css" media="all" href="reset.css" />
<link rel="stylesheet" type="text/css" media="all" href="text.css" />
<link rel="stylesheet" type="text/css" media="all" href="960.css" />
</head>
<body>
	<jsp:useBean id="counter" scope="session" class="com.fixertin.first.Model" />
	
		<div class="navbar">
			<div class="container_12">
				<h3 class="grid_11">Your resume</h3>
				<h3 class="grid_1"><a href="AdminLoginPage.jsp">Login</a></h3>
			</div>
		</div>
		
		<div class="contentTable">
			<div class="container_12">
				<form name="editForm" method="post" action="EditInterestsServlet">
					<table>
						<%for(int i=0; i<counter.getTempSize(counter.getUser(), "ALL_INTERESTS"); i++){ %>
							 <%="<tr>"%>
							 	<%=counter.getSpecificElementDataTable(counter.getUser(), "ALL_INTERESTS", i) %>
							 <%="</tr>"%>
						<% } %>
						<tr>
							<td>
								<input type="text" name="newSkill" />
								<input type="submit" value="Add" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="number" min="0" name="removeSkill" />
								<input type="submit" value="Remove" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
</body>
</html>