<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>List of Books</h1>

<table border="2" cellpadding="4">
  <tr>
   <th>Loan ID</th>
   <th>Customer ID</th>
   <th>Customer Name</th>
   <th>Book Title</th>
   <th>Author</th>
   <th>Due Date</th>
  </tr>
  <tr>
    <c:forEach items="${loans}" 
                 var="loan">
      <tr> 
        <td>${loan.lid}</td>
        <td>${loan.cust.cId}</td>
        <td>${loan.cust.cName}</td>
        <td>${loan.book.title }</td>
        <td>${loan.book.author }</td>
        <td>${loan.dueDate }</td>
      </tr>
    </c:forEach>
  </tr>
</table>

<br />

<table>
	<tr>
		<td><a href="/">Home</a></td>
		<td><a href="/showBooks">List Books</a></td>
		<td><a href="/showCustomers">List Customers</a></td>
		<td><a href="/showLoans">List Loans</a></td>
		<td><a href="/deleteLoan">Delete Loan</a></td>
		<td><a href="/logout">Logout</a></td>
	</tr>
</table>

</body>
</html>