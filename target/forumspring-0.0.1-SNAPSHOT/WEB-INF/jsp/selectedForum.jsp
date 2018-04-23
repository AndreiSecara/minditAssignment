<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum</title>
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
	<h3 style="text-decoration: underline;"><b>${forum.name}</b></h3>
	
	<table class="tg">
		<tr>
			<th width="120">Post Content</th>
		</tr>
		<c:forEach items="${listPosts}" var="post">
			<tr>
				<td>${post.postContent}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- ADD POST -->
	<h3>New Post</h3>
	<c:url var="addAction" value="/addPost/${forum.id}"></c:url>
	<form:form method="POST" action="${addAction}" modelAttribute="post">
		<table>
			<tr>
				<td><form:label path="postContent">
						<spring:message text="Post Content" />
					</form:label></td>
				<td><form:input path="postContent" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add"/>" />
				</td>
			</tr>
		</table>
		<a href='<c:url value="/forums" />'>All Forums</a>
	</form:form>
</body>
</html>