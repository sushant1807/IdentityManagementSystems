<%@page
		import="com.sushant.login.dto.UserDetailsdto,java.util.*;"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

	

	<h1>Users List</h1>

	<%
		List<UserDetailsdto> list = (List<UserDetailsdto>) session.getAttribute("allUsers");
		request.removeAttribute("allUsers");
	%>

	<table border="1" width="90%">
		<thead>
			<tr>
				<td>User Id</td>
				<td>Name</td>
				<td>Password</td>
				<td>Display Name</td>
			</tr>

		</thead>
		<tbody>
			<%
				if (list == null || list.isEmpty()) {
			%>
			<tr>
				<td colspan="4">No result</td>
			</tr>

			<%
				} else {
					for (UserDetailsdto id : list) {
			%>
			<tr>

				<%-- <td> <label for="id" name="id" id="id" value="<%=id.getId() %>"><%=id.getId() %></label></td> --%>
				<td><%=id.getUserId()%></td>

				<td><%=id.getUserName()%></td>

				<td><%=id.getPassword()%></td>

				<td><%=id.getName()%></td>

				<form action="ManipulateUserServlett" method="post">
					<td>
						<Button type="submit" name="delete"
							value=<%="Edit," + id.getUserId()%>>Edit</Button>
						<Button type="submit" name="delete"
							value=<%="Delete," + id.getUserId()%>>Delete</Button>
					</td>
				</form>

			</tr>
			<%
				}
				}
			%>

		</tbody>
	</table>
	<br/>
	<a href="adduserform.jsp">Add New User</a>

</body>
</html>
