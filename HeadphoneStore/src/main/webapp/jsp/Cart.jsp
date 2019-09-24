<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
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
	<em>Корзина</em>
	<table>
		<c:set var="i" value="0" />
		<c:set var="k" value="0" />
		<c:forEach items="${cartSessionEJB.allCartProductEntity()}" var="element">
			<tr>
				<c:if test="${k == 0}">
				  <c:set var="k" value="${cartSessionEJB.quantitySameProductEntity(element.getProductEntityId())}" />
						<c:set var="i" value="${i+1}" />
						<td>"${i}"</td>
						<td>${element.getFirm()} ${element.getName()}</td>
						<td>- ${element.getPrice()} p</td>
						<td>x "${cartSessionEJB.quantitySameProductEntity(element.getProductEntityId())}"</td>
						<td>- ${element.getPrice() * cartSessionEJB.quantitySameProductEntity(element.getProductEntityId())} p</td>
						<td><form action="Cart"><button type="submit" value="${element.getProductEntityId()}" name="cartproductId" >добавить</button></form></td>
						<td><form action="Cart"><button type="submit" value="${element.getProductEntityId()}" name="removecartproductId" >удалить</button></form></td>
				</c:if>
				<c:set var="k" value="${k-1}" />
			</tr>
		</c:forEach>
	</table>
	<em>Итого:</em>
	<em>"${cartSessionEJB.getTotalPrice()}"</em>
	<br>
	<form method="post" action="OrderForm">
		<button type="submit">Оформить заказ</button>
	</form>
</div>

<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>