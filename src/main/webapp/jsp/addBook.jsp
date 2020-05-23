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

<h1>Add New Book</h1>

<form:form modelAttribute="newBook">
  <table>
    <tr>
      <td>Title:</td>
      <td><form:input path="title"></form:input></td>
      <td><form:errors path="title"></form:errors></td>
    </tr>
   <tr>
      <td>Author:</td>
      <td><form:input path="author"></form:input></td>
      <td><form:errors path="author"></form:errors></td>
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