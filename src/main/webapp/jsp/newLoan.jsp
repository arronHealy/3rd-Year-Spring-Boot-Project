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

<h1>Add New Loan</h1>

<form:form modelAttribute="newLoan">
  <table>
    <tr>
      <td>Customer ID:</td>
      <td><form:input path="cust.cId"></form:input></td>
      <td><form:errors path="cust.cId"></form:errors></td>
    </tr>
   <tr>
      <td>Book ID:</td>
      <td><form:input path="book.bid"></form:input></td>
      <td><form:errors path="book.bid"></form:errors></td>
    </tr>
    <tr>
      <td colspan="1">
        <input type="submit" value="Loan Book"/>
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