<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/Cart.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
<!-- 
<br>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getCustomerId() }
<br>
<br>${pageContext.session.getAttribute('orderId')}
<br>
<br>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getOrderId()}
<br>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getDate()}
-->
<div class="cart-template">
	<table>
		<caption>Данные профиля пользователя</caption>
		<tr>
			<td>Id пользователя</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getCustomerId()}</td>
		</tr>
		<tr>
			<td>Имя пользователя</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getFirstname()}</td>
		</tr>
		<tr>
			<td>Фамилия пользователя</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getSecondname()}</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getEmail()}</td>
		</tr>
		<tr>
			<td>Город</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getSity()}</td>
		</tr>
		<tr>
			<td>Улица</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getStreet()}</td>
		</tr>
		<tr>
			<td>Номер дома</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getHouse()}</td>
		</tr>
		<tr>
			<td>Номер квартиры</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getApartment()}</td>
		</tr>
		<tr>
			<td>Номер телефона</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getPhoneNumber()}</td>
		</tr>
		<tr>
			<td>Почтовый индекс</td>
			<td>${test.getCustomerEntity(pageContext.session.getAttribute('CustomerId')).getZipCode()}</td>
		</tr>
	</table>
</div>
<div class="cart-template">
	<hr>
	<table>
		<caption>Адрес доставки из формы заказа</caption>
		<tr>
			<td>Город</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getSity()}</td>
		</tr>
		<tr>
			<td>Улица</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getStreet()}</td>
		</tr>
		<tr>
			<td>Номер дома</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getHouse()}</td>
		</tr>
		<tr>
			<td>Номер квартиры</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getApartment()}</td>
		</tr>
		<tr>
			<td>Номер телефона</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getPhoneNumber()}</td>
		</tr>
		<tr>
			<td>Почтовый индекс</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getZipCode()}</td>
		</tr>
		<tr>
			<td>Комментарий</td>
			<td>${test.getOrderEntityById(pageContext.session.getAttribute('orderId')).getAddressEntity().getComment()}</td>
		</tr>
	</table>
</div>




<br>
<form method="POST" action="http://localhost:8080/MiniBank/BankServlet/Pay">
		<input type="hidden" name="returnUrl" value="http://localhost:8080/HeadphoneStore/SuccessfulPayment">
		<input type="hidden" name="failUrl" value="http://localhost:8080/HeadphoneStore/FailedPayment">
		<input type="hidden" name="jsonParams" value='${cartSessionEJB.getTotalPriceJson()}'>
		<input type="hidden" name="orderNumber" value='${pageContext.session.getAttribute('orderId')}'>
		<button type="submit">Перейти на страницу банка</button>
</form>

<jsp:include page="FooterJSP.jsp"></jsp:include>

</body>
</html>