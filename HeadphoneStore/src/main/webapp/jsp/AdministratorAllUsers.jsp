<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All users</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/Cart.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
<div class="cart-template">
<table>
<c:forEach items="${test.allCustomerEntity()}" var="element">
	<tr>
		<td>${element.getCustomerId()}</td>
		<td>${element.getFirstname()}</td>
		<td>${element.getSecondname()}</td>
		<td>${element.getEmail()}</td>
		<td>${element.getPassword()}</td>
		<td>${element.getSity()}</td>
		<td>${element.getStreet()}</td>
		<td>${element.getHouse()}</td>
		<td>${element.getPhoneNumber()}</td>
		<td>${element.getApartment()}</td>
		<td>${element.getZipCode()}</td>
	</tr>
</c:forEach>
</table>
</div>
<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>