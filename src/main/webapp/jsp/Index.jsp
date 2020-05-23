<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	  <tr>
	    <th>Books</th>
	    <th>Customers</th> 
	    <th>Loans</th>
	  </tr>
	  <tr>
	    <td><a href="/showBooks">List Books</a></td>
	    <td><a href="/showCustomers">List Customers</a></td>
	    <td><a href="/showLoans">List Loans</a></td>
	  </tr>
	  <tr>
	    <td><a href="/addBook">Add Book</a></td>
	    <td><a href="/addCustomer">Add Customers</a></td>
	    <td><a href="/newLoan">New Loan</a></td>
	  </tr>
	  <tr>
	    <td></td>
	    <td></td>
	    <td><a href="/deleteLoan">Delete Loan</a></td>
	  </tr>
	</table>
</body>
</html>