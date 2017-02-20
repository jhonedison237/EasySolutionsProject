<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search all level of friends</title>

<style>
	.error {color: #ff0000;}
</style>
</head>
<body>
	<form:form method="POST" modelAttribute="member">
		<table>
			<tr>
				<td><label for="email">Enter the email: </label> </td>
				<td><form:input path="memEmail" id="email"/></td>
				<td><form:errors path="memEmail" cssClass="error"/></td>
		    </tr>
			<tr>
				<td >
					<input type="submit" value="Search all friends"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>