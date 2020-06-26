<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topup virtual card</title>
<%@include file="navbar.jsp" %>
</head>
<body>
<h2>Topup Virtual Card</h2>
<form action="topupcard">
select Card:
<p>${allcards.size()}</p>
<% int k=(int)request.getAttribute("key"); %>
<label for="MyCard"></label>
<select name="category">
 <% if(k == 0){%>
    
    <option>None</option>
   <% }if(k == 1){%>
        <option value="${allcards.get(0)}">${allcards.get(0)}</option>
   <%  }if(k==2){%>
        <option value="${allcards.get(0)}">${allcards.get(0)}</option>
        <option value="${allcards.get(1)}">${allcards.get(1)}</option>
  <%  }if(k==3){%>
        <option value="${allcards.get(0)}">${allcards.get(0)}</option>
        <option value="${allcards.get(1)}">${allcards.get(1)}</option>
        <option value="${allcards.get(2)}">${allcards.get(2)}</option>  
  <%  }%>
</select>
<br><br>
select Account:
<label for="selectaccount"></label>
<select id="selectaccount">
  <option value="My Wallet ">My Wallet</option>
</select>
<br><br><br><br>
<input type="text"  id=enteredamount name=enteredamount ><br><br>
<input type="submit" value="Topup card" />
</form>
</body>
</html>