<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cards Wallet-View Cards</title>
<%@include file="navbar.jsp"%>
</head>
<body>

	<p>${allcards}</p>

	<form action="create_card">
	<%
			int used_cards = (int) request.getAttribute("currentcards");
		%>
		<%if(used_cards<3){%>
		<button id="btn-createcard">Create a Virtual Card</button>
		<%}else {%>
		<div id="information"><p style="color: red; text-align: center">You have reached the limit to create new card</p><br></div>
		<button id="btn-createcard" disabled>Create a Virtual Card</button>
		<%}%>
	</form>

</body>
</html>