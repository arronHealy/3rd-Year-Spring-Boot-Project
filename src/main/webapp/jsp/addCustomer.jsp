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

<h1>Add New Customer</h1>

<form:form modelAttribute="newCustomer">
  <table>
    <tr>
      <td>Customer Name:</td>
      <td><form:input path="cName"></form:input></td>
      <td><form:errors path="cName"></form:errors></td>
    </tr>
   <tr>
      <td>Loan Period (days):</td>
      <td><form:input path="loanPeriod"></form:input></td>
      <td><form:errors path="loanPeriod"></form:errors></td>
    </tr>
    <tr>
      <td colspan="1">
        <input type="submit" value="Add"/>
      </td>
    </tr>
  </table>
</form:form>

<br />

<table>
	<tr>
    	<td><a href="/">Home</a></td>
		<td><a href="/addBook">Add Book</a></td>
		<td><a href="/addCustomer">Add Customer</a></td>
		<td><a href="/newLoan">New Loan</a></td>
    </tr>
</table>

</body>
</html>