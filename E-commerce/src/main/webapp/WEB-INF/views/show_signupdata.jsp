<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Mobile</th>
<th>Action</th>
</tr>
<%   ResultSet result=(ResultSet)request.getAttribute("res");
     while(result.next()){
%>
<tr>
<td><%=result.getString(1) %></td>
<td><%=result.getString(2) %></td>
<td><%=result.getString(3) %></td>
<td><%=result.getString(4) %></td>
<td><a href="delete?email=<%=result.getString(2)%>">delete</a></td>
<td><a href="updates?email=<%=result.getString(2)%>&mobile=<%=result.getString(4)%>">update</a></td>

</tr>
<% }%>
</table>

</body>
</html>