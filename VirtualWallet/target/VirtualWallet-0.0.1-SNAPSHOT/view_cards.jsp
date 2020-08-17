<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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
			if (use ==3) {
		%>

		<div style="width: 300px; height: 100px; border: 1px solid #000;">
			Card Number &nbsp<label lbl-cardname>${allcards.get(2)}</label> <br>
			Card Name &nbsp<label lbl-cardnumber>${userscardname.get(2)}</label> <br>
			Card Date  &nbsp<label lbl-expiry> ${usersdate.get(2)} </label><br>
			Card Amount &nbsp<label lbl-cardbalance>${usersamount.get(2)} </label> <br>		</div>

		<% use=use-1;
			}
		if (use ==2) {
		%>

		<div style="width: 300px; height: 100px; border: 1px solid #000;">
			Card Number &nbsp<label lbl-cardname>${allcards.get(1)}</label> <br>
			Card Name &nbsp<label lbl-cardnumber>${userscardname.get(1)}</label> <br>
			Card Date  &nbsp<label lbl-expiry> ${usersdate.get(1)} </label><br>
			Card Amount &nbsp<label lbl-cardbalance>${usersamount.get(1)} </label> <br>		</div>

		</div>
		<%use=use-1;
			}
		if (use ==1) {
		%>
		<div style="width: 300px; height: 100px; border: 1px solid #000;">
		   Card Number &nbsp<label lbl-cardname>${allcards.get(0)}</label> <br>
			Card Name &nbsp<label lbl-cardnumber>${userscardname.get(0)}</label> <br>
			Card Date  &nbsp<label lbl-expiry> ${usersdate.get(0)} </label><br>
			Card Amount &nbsp<label lbl-cardbalance>${usersamount.get(0)} </label> <br>		</div>

		</div>
		<%
			}
		%>

	</div>


	<form  action="create_card">
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