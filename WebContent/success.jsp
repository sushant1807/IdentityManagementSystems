
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dash Board | My Application</title>
</head>
<body>

	<%! 

		
		String name = null;
	
	%>

	<%
	
		if(session.getAttribute("userDetails") != null) {
			
			//userDetails = (UserDetailsdto)session.getAttribute("userDetails");
			
			name =session.getAttribute("userDetails").toString();
		}
	
	%>

	<h1>Hello <%=name %></h1>

	<br/>
	
	
	<!-- Your design should goes here -->
	<h2>Welcome to Identity Management Systems :))</h2>
	<form action="ViewAddServlet" method="post">
			<button type="submit" name="check" value="View">View All Users</button> 
	</form>
</body>
</html>