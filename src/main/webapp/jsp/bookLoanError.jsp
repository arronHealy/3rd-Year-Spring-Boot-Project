<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Could not create New Loan</h1>

<h2>Sorry Book: ${bid} - ${title} is already on Loan to Customer: ${cid} - ${cName }</h2>

<table>
	<tr>
    	<td><a href="/">Home</a></td>
		<td><a href="/showBooks">List Books</a></td>
		<td><a href="/showCustomers">List Customers</a></td>
		<td><a href="/showLoans">List Loans</a></td>
		<td><a href="/newLoan">New Loan</a></td>
    </tr>
</table>

</body>
</html>