<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View cards</title>
<%@include file="navbar.jsp" %>
</head>
<body>
    <p>${allcards}</p>
     
   <form action="newcard" >  
       <input type="submit" value="create new card" />
     </form> 
    
    </body>
</html>