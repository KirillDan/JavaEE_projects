<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cabinet</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">

<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
Кабинет<br>
	<c:choose>
		<c:when test="${pageContext.session != null && sessionScope.Login == 'Login'}">
				
				<a href="NonPayOrder">Неоплаченные заказы</a><br>
				<a href="PayOrder">Оплаченные заказы</a><br>
				<a href="ProcessingOrder">Заказы в обработке</a><br>
				<a href="ToManagerOrder">Заказы, переданные менеджеру</a><br>
				<a href="FinishedOrder">Завершенные заказы</a><br>
				<a href="AllOrders">Все заказы</a>
			
		</c:when>
		<c:otherwise>
			<br><a href="Login">Вход</a>
		</c:otherwise>
	</c:choose>

<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>