<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="navbar.jsp"%>
<div style="width: 300px; height: 100px; border: 1px solid #000;">
	Avaliable Balance <br>
	<br> <input type="text" name="avbalance" value="${amount}"
		readonly>
</div>
<div style="width: 300px; height: 100px; border: 1px solid #000;">
	Avaliable Cards <br>
	<br> <input type="text" name="avcards" value="${tcards}" readonly>
</div>
</body>
</html>