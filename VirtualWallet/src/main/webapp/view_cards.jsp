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
			if (use ==3) {
		%>

		<div style="width: 300px; height: 100px; border: 1px solid #000;">
			<label>  ${userscardname.get(2)}</label><br>
			<label> ${allcards.get(2)}</label> <br>
			<labe> ${usersdate.get(2)}</label><br>
			<label>$ </label> ${usersamount.get(2)}<br>
		</div>

		<% use=use-1;
			}
		if (use ==2) {
		%>

		<div style="width: 300px; height: 100px; border: 1px solid #000;">
			<label>Card Number  </label> ${allcards.get(1)}<br>
			<label>Card Name  </label> ${userscardname.get(1)}<br>
			<label>Card Date  </label> ${usersdate.get(1)}<br>
			<label>Card Amount  </label> ${usersamount.get(1)}<br>
		</div>
		<%use=use-1;
			}
		if (use ==1) {
		%>
		<div style="width: 300px; height: 100px; border: 1px solid #000;">
		<label>Card Number  </label> ${allcards.get(0)}<br>
			<label>Card Name  </label> ${userscardname.get(0)}<br>
			<label>Card Date  </label> ${usersdate.get(0)}<br>
			<label>Card Amount  </label> ${usersamount.get(0)}<br>
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