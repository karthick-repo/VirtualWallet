<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View cards</title>
<%@include file="navbar.jsp"%>
</head>
<body>

	<p>${allcards}</p>

	<form action="newcard">
	<%
			int used_cards = (int) request.getAttribute("currentcards");
		%>
		<%if(used_cards<3){%>
		<input type="submit" value="create new card" />
		<%}else {%>
		<button value="button" disabled>Create new card</button>
		<%}%>
	</form>

</body>
</html>