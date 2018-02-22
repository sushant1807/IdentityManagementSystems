<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%@page
		import="com.sushant.login.dao.IdentityDAO,com.sushant.login.dto.UserDetailsdto"%>

	<%
		UserDetailsdto u = (UserDetailsdto) session.getAttribute("user");
		;
	%>

	<h1>Edit Form</h1>
	<form action="UpdateUserServlet" method="post">

		<table>
			<tr>
				<td>User ID:</td>
				<td><input type="text" name="userId" value="<%=u.getUserId()%>"
					readonly /> <mark>ID cannot be Edited</mark></td>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="userName"
				value="<%=u.getUserName()%>" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"
					value="<%=u.getPassword()%>" /></td>
			</tr>
			<tr>
			<td>Display Name:</td>
			<td><input type="text" name="displayName"
				value="<%=u.getName()%>"/> </td></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit User" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="viewusers.jsp">Cancel</a></td>
			</tr>
		</table>
	</form>

</body>
</html>
