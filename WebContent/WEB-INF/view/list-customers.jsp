<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!--  Add Button -->
			<input type="button" class="add-button"
				onclick="window.location.href='getFormForAddingCustomer';"
				value="Add Customer" />

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="customer" items="${customers}">
				
					<!-- create a link for the Update process -->
					<c:url var="updateUrl" value="/customer/showFormForUpdatingCustomer">
						<c:param name="customerId" value="${customer.id }" />
					</c:url>
					
					<!-- create a link for the Delete process -->
					<c:url var="deleteUrl" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${customer.id }" />
					</c:url>
					
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateUrl }">Update</a>
						| 	<a href="${deleteUrl }" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>					
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>

	</div>

</body>

</html>