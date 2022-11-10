<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management System</h2>
		</div>
	</div>

	<div id="container">
	<div>
		<!-- Add Customer Button  -->
		<input type="button" value="Add Customer" onclick="window.location.href='showformforadd';return false;"/>

		<!-- Add HTML Table Here -->
		<table class="table">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E-mail</th>
				<th>Action</th>
			</tr>

			<!-- loop over and print our customers -->
			<c:forEach var="tempCustomer" items="${customer}">
				<!-- construct updat elink with customer id -->
    <c:url var="updateLink" value="/customer/showformforupdate">
    <c:param name="customerId" value="${tempCustomer.id }"/>
    </c:url>
    
     <!-- construct delete link with customer id -->
    <c:url var="deleteLink" value="/customer/delete">
    <c:param name="customerId" value="${tempCustomer.id }"/>
    </c:url>
					<tr>
					    <td>${tempCustomer.id}
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Edit</a></td>
						<td><a href="${deleteLink}" onclick="if(!confirm('Are you sure?'))return false">Delete</a></td>
						
					</tr>
				</c:forEach>

		</table>
		</div>
	</div>
</body>
</html>
