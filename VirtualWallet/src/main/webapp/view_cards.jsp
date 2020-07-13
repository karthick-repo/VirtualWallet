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
	<div>
		<%
			int use = (int) request.getAttribute("totalsize");
		%>
		
		<%
			if (use >=6) {
		%>

		<div style="width: 300px; height: 130px; border: 1px solid #000;">
			<label>${allcards.get(7)}</label><br> <label>${allcards.get(6)}</label><br>
			<label>${allcards.get(8)}</label><br>
		</div>

		<%
			}
		if (use >=3) {
		%>

		<div style="width: 300px; height: 130px; border: 1px solid #000;">
			<label>${allcards.get(4)}</label><br> <label>${allcards.get(3)}</label><br>
			<label>${allcards.get(5)}</label><br>
		</div>
		<%
			}
		if (use >0) {
		%>
		<div style="width: 300px; height: 130px; border: 1px solid #000;">
			<label>${allcards.get(1)}</label><br> <label>${allcards.get(0)}</label><br>
			<label>${allcards.get(2)}</label><br>
		</div>
		<%
			}
		%>

	</div>


	<form action="create_card">
		<%
			int used_cards = (int) request.getAttribute("currentcards");
		%>
		<%
			if (used_cards < 3) {
		%>
		<button id="btn-createcard">Create a Virtual Card</button>
		<%
			} else {
		%>
		<div id="information">
			<p style="color: red; text-align: center">You have reached the
				limit to create new card</p>
			<br>
		</div>
		<button id="btn-createcard" disabled>Create a Virtual Card</button>
		<%
			}
		%>
	</form>

</body>
</html>