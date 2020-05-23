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
<h1>List of Customers</h1>

<c:forEach items="${customers}" var="customer">
       
   <h1>${customer.cId} ${customer.cName}</h1>
      	
   <p>Loan period = ${customer.loanPeriod}</p>
      	
   <h2>${customer.cName}'s Loans</h2>
      	
   <table border="2" cellpadding="3">
      <tr>
      	<th>Loan ID</th>
      	<th>Book ID</th>
      	<th>Title</th>
      	<th>Author</th>
      </tr>
      <tr>
      	<c:forEach items="${customer.loans}" var="loan">
      	<tr>
      		<td>${loan.lid}</td>
      		<td>${loan.book.bid}</td>
      		<td>${loan.book.title }</td>
      		<td>${loan.book.author}</td>
      	</tr>
      	</c:forEach>
      </tr>	
   </table>

</c:forEach>

<br />

<table>
	<tr>
		<td><a href="/">Home</a></td>
		<td><a href="/showBooks">List Books</a></td>
		<td><a href="/showCustomers">List Customers</a></td>
		<td><a href="/showLoans">List Loans</a></td>
		<td><a href="/logout">Logout</a></td>
	</tr>
</table>

</body>
</html>