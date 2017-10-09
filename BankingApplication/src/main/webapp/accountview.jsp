
<%@page import="com.bridgelabz.pojo.CustomerDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		List<CustomerDetail> list = (ArrayList<CustomerDetail>) request.getAttribute("list");
	%>
	<table class="table table-hover">
		<form method="get">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>AccountNumber</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (CustomerDetail customer : list) {
				%>
				<tr>
					<td><a class="name"><%=customer.getName()%></a></td>
					<td><a class="email"><%=customer.getEmail()%></a></td>
					<td><a class="accountnumber"><%=customer.getAccountno()%></a></td>
					<td><button type="button" name="edit"
							onclick="return updateAccount('<%=customer.getId()%>')"
							data-toggle="modal" data-target="#editModal"
							class="btn btn-success">Edit</button></td>
					<td><button type="submit"
							onclick="return deleteAccount('<%=customer.getId()%>')"
							class="btn btn-success">Delete</button></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</form>
	</table>
</body>
</html>
