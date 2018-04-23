<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login success</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h3>Forums List</h3>
	<table class="tg">
		<tr>
			<th width="60">ID</th>
			<th width="120">Name</th>
			<th width="120">Options</th>
		</tr>
		<c:forEach items="${listForums}" var="forum">
			<tr>
				<td>${forum.id}</td>
				<td>${forum.name}</td>
				<td>
					<spring:url value="/select/${forum.id}" var="selectURL" />
					<a href="${selectURL}">Select</a>
					<spring:url value="/delete/${forum.id}" var="deleteURL" />
					<a href="${deleteURL}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<!-- ADD FORUM -->
	<h3>New Forum</h3>
	<c:url var="addAction" value="/addForum"></c:url>
	<form:form method="POST" action="${addAction}" modelAttribute="forum">
		<table>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add"/>" />
				</td>
			</tr>
		</table>
	</form:form>
	<a href='<c:url value="/welcome" />'>Home</a>
</body>
</html>