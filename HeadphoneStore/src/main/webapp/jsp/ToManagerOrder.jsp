<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Orders</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/Cart.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
<c:choose>
		<c:when test="${pageContext.session != null && sessionScope.Login == 'Login'}">
			Закавы, переданные менеджеру<br>
			<div class="cart-template">
				<table>
				<tr>
					<td>Номер</td>
					<td>Дата</td>
					<td>Оплачен</td>
					<td>В обработке</td>
					<td>У менеджера</td>
					<td>Завершен</td>
					<td>Стоимость</td>
				</tr>
				<c:forEach items="${test.allTransferedManagerOrderEntitysByCustomer(pageContext.session.getAttribute('CustomerId'))}" var="element" >
				<tr>
					<td>${element.getOrderId() }</td>
					<td>${element.getDate() }</td>
					<td>${element.getPaid() }</td>
					<td>${element.getProcessing() }</td>
					<td>${element.getTransferedManager() }</td>
					<td>${element.getClosed() }</td>
					<td>${element.getPrice() }</td>
				</tr>
				</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<br><a href="Login">Вход</a>
		</c:otherwise>
	</c:choose>
<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>