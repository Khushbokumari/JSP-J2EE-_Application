<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h2>New Registration</h2>
<form action="signup" method="post">
<pre>
Name<input type="text" name="name"/>
Email<input type="email" name="email"/>
Password<input type="password" name="password"/>
Mobile<input type="number" name="mobile"/>
<input type="submit" value="Signup"/></pre>
</form>
<%if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
} %>
</body>
</html>