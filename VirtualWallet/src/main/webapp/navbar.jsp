<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="style.css"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
    <div i="outer">
     <div class="inner"> <form action="dashboard">
      <button>Dashboard</button></div>
      </form>
     <div class="inner"> <form action="viewcards">
      <button>View Cards</button>
      </form>
      </div>
      
      <div class="inner"> 
      <form action="topupcard">
      <button>TopupCard</button></div></form>
      <div class="inner"> 
     <form action="logout"> <button>Logout</button></div></form>
 </ul>
  </div>
</nav>

</head>
<body>

</body>
</html>