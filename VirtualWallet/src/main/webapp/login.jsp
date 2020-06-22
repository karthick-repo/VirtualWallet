<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Virtual Cards Wallet - Login</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<script type="text/javascript">
function val(){

       document.getElementById("error-message").innerHTML= "";
       var userName = document.getElementById("userid");
       var password = document.getElementById("password");
       if(userName.value.trim().length>30)
       {
              document.getElementById("error-message").innerHTML="Userid not more than 30 characters";
              return false;

       }else if (password.value.trim().length>30) {
              document.getElementById("error-message").innerHTML="password not more than 30 characters";
              return false;

       }else{

              return true;

              }

}     

</script>
<body>
<form action="validate" onsubmit="return val()">

              <h3 style="text-align:center">VIRTUAL WALLET</h3>
              <div id="error-message" style="color: red; text-align: center">${error}</div>
              <label>User Name</label>
              <input type="text" name="userid" id="userid"/><br><br>
              <label>Password</label>
              <input type="password" name="password" id="password"/><br>
              <br>
              <input type="submit" value="login" />
              <br>
              <br>

</form>
</body>
</html>