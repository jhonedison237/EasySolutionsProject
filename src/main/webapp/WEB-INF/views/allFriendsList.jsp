<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Friend List</title>
	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>
</head>
<body>
	<h2>List of Friends</h2>	
	<c:forEach items="${friendList}" var="friendList" varStatus="status">
		<h3>Level <c:out value="${status.count}"/>:</h3>
		
		<c:forEach items="${friendList}" var="friendLevel">
			<div>${friendLevel}</div>
		</c:forEach>
	</c:forEach>
	<br/>
	Go back to <a href="<c:url value='/searchAllFriends' />">Search all level of friends</a>
</body>
</html>