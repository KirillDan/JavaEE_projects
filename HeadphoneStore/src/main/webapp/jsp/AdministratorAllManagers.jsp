<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/Cart.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
<meta charset="ISO-8859-1">
<title>All</title>
</head>
<body>
	Все менеджеры
<div class="cart-template">
	<table>
		<caption>Все менеджеры</caption>
		<tr>
			<td>Id</td>
			<td>Имя</td>
			<td>Фамилия</td>
			<td>email</td>
			<td>Пароль</td>
			<td>Город</td>
			<td>Улица</td>
			<td>№ Дома</td>
			<td>Квартира</td>
			<td>Телефон</td>
			<td>Заказы</td>	
		</tr>
		<c:forEach items="${adminTest.getAllManagers()}" var="element" >
		<tr>
			<td>${element.getManagerId()}</td>
			<td>${element.getFirstname()}</td>
			<td>${element.getSecondname()}</td>
			<td>${element.getEmail()}</td>
			<td>${element.getPassword()}</td>
			<td>${element.getSity()}</td>
			<td>${element.getStreet()}</td>
			<td>${element.getHouse()}</td>
			<td>${element.getApartment()}</td>
			<td>${element.getPhoneNumber()}</td>
			<td>${element.getListOrderEntity().size()}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>