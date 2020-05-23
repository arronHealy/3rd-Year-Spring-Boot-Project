<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books List</title>
</head>
<body>

<h1>List of Books</h1>

<table border="2" cellpadding="4">
  <tr>
   <th>Person ID</th>
   <th>Name</th>
   <th>Country</th>
  </tr>
  <tr>
    <c:forEach items="${books}" 
                 var="book">
      <tr> 
        <td>${book.bid}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
      </tr>
    </c:forEach>
  </tr>
</table>

<br />

<table>
	<tr>
		<td><a href="/">Home</a></td>
		<td><a href="/addBook">Add Book</a></td>
		<td><a href="/showCustomers">List Customers</a></td>
		<td><a href="/showLoans">List Loans</a></td>
		<td><a href="/logout">Logout</a></td>
	</tr>
</table>
</body>
</html>