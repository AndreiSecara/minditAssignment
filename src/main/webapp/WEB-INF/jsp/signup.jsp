<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up page</title>
</head>
<body>
	<h1>Register</h1>
	<c:url var="registerAction" value="/signup/confirm"></c:url>
	<form:form method="POST" action="${registerAction}" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="user_name">
						<spring:message text="Username" />
					</form:label></td>
				<td><form:input path="user_name" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input path="password" type="password"/></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr></tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Register"/>" /></td>
			</tr>
		</table>
	</form:form>
	<a href='<c:url value="/welcome" />'>Home</a>
</body>
</html>