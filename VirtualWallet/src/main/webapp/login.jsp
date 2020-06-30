<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Virtual Cards Wallet - Login</title>
</head>

<script type="text/javascript">
	function val() {

		document.getElementById("error-message").innerHTML = "";
		var userName = document.getElementById("userid");
		var password = document.getElementById("password");
		if (userName.value.trim().length > 30) {
			document.getElementById("error-message").innerHTML = "User Name  not more than 30 characters";
			return false;

		} else if (password.value.trim().length > 30) {
			document.getElementById("error-message").innerHTML = "password not more than 30 characters";
			return false;

		} else {

			return true;

		}

	}
</script>
<body class="loginbody">
	<br><h3 style="text-align:center">VIRTUAL WALLET</h3><br><br><br>
	<div id="error-message" style="color: red; text-align: center">${error}</div>
	
	<form action="validate" onsubmit="return val()">
		<label>User Name</label>
	    <input type="text" name="userid" id="userid" /><br>
		<br> <label>Password</label><br> <input type="password"
			name="password" id="password" value="wallet@2020" /><br> <br>
		<button id="login">login</button>

	</form>
</body>
</html>