<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Create cards</title>
<%@include file="navbar.jsp"%>
<link rel="stylesheet" type="text/css" href="formstyle.css" />
</head>
<h3 style="text-align:center">Create New VirtualCard</h3>
<body>
	<form method="POST" action="create_card_success">
		
			<input type="hidden" id="username" name="username" value="${username}"
				required><br />
			<br /> <input type="hidden" id="cardnumber" name="cardnumber"
				value="${cardnumber}" required><br />
			<br /> <input type="hidden" id="date" name="date" value="${date}"
				required><br />
			<br /> Amount : <input type="number" name="amount" id="amount"
				required /><br />
			<br /> Card Name : <input type="text" name="cardname" id="cardname"
				required><br/>
			<br /> select Account: <label for="selectaccount"></label> <select
				id="selectaccount">
				<option value="My Wallet">My Wallet</option>
			</select> <br><br>
			
			<br> <input type="submit" value="Create card" />
		
		</div>
	</form>

</body>
</html>