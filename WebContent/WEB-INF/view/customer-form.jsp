<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relationship MAnagement System</h2>
		</div>
	

	<div id="container">
	<h3>Save Customer</h3>
	<hr>
	
	
	<f:form action= "savecustomer" modelAttribute="customer" method="POST">
	<!-- Customer Id -->
	<f:hidden path="id"/>
	<table>
	<tbody>
	<tr>
	<td><label>FirstName:</label>
	<td><f:input path="firstName"/></td>
	</tr>
	<tr>
	<td><label>LastName:</label>
	<td><f:input path="lastName"/></td>
	</tr>
	<tr>
	<td><label>email:</label>
	<td><f:input path="email"/></td>
	</tr>
	<tr>
	<td><label></label></td>
	<td><input type="submit" value="Save"/></td>
	</tr>
	
	</tbody>
	</table>
	
	</f:form>
	<hr>
	<p><a href="customer/list">Back to List</a>
	</p>
	</div>
	</div>

	
</body>
</html>
