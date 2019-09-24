<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/Cart.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
	<div class="cart-template">
	<table>
		<caption>Данные менеджера</caption>
		<tr>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getManagerId()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getFirstname()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getSecondname()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getEmail()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getPassword()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getSity()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getStreet()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getHouse()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getApartment()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getPhoneNumber()}</td>
			<td>${managerEJB.getManagerEntityById(pageContext.session.getAttribute('managerId')).getListOrderEntity().size()}</td>
		</tr>
	</table>
	</div>
</body>
</html>