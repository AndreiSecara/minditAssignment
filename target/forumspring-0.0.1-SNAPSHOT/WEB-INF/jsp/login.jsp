<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<h1>Login</h1>
	<c:url var="loginAction" value="/login/confirm"></c:url>
	<form:form action="${loginAction}" method="POST" modelAttribute="user">
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
				<td></td>
				<td>
					<td colspan="2"><input type="submit"
					value="<spring:message text="Login"/>" />
				</td>
			</tr>
		</table>
	</form:form>
	<a href='<c:url value="/welcome" />'>Home</a>
	<a href='<c:url value="/signup" />'>Sign up</a>
</body>
</html>

