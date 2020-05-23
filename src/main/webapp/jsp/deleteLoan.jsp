<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Delete Loan</h1>

<form:form modelAttribute="deleteLoan">
  <table>
    <tr>
      <td>Loan ID:</td>
      <td><form:input path="lid"></form:input></td>
    </tr>
    <tr>
      <td colspan="1">
        <input type="submit" value="Delete Loan"/>
      </td>
    </tr>
  </table>
</form:form>

<br />

<table>
	<tr>
    	<td><a href="/">Home</a></td>
		<td><a href="/showBooks">List Books</a></td>
		<td><a href="/showCustomers">List Customers</a></td>
		<td><a href="/showLoans">List Loans</a></td>
    </tr>
</table>

</body>
</html>