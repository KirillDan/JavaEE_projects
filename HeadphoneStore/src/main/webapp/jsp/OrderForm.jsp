<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderForm</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">

<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>

<div>
	<form method="post" action="BankSite">
		<label for="">Имя</label>
		<input type="text" name="firstname" id="">
		<br/>
		<label for="">Фамилия</label>
		<input type="text" name="secondname" id="">
		<br/>
		<label for="">Город</label>
		<input type="text" name="sity" id="">
		<br/>
		<label for="">Улица</label>
		<input type="text" name="street" id="">
		<br/>
		<label for="">Дом</label>
		<input type="text" name="house" id="">
		<br/>
		<label for="">Квартира</label>
		<input type="text" name="apartment" id="">
		<br/>
		<label for="">Телефон</label>
		<input type="text" name="phone" id="">
		<br/>
		<label for="">email</label>
		<input type="text" name="email" id="">
		<br/>
		<label for="">Почтовый индекс</label>
		<input type="text" name="zipindex" id="">
		<br/>
		<label for="">Комментарий к заказу</label>
		<textarea name="comment"></textarea>
		<button type="submit">Далее</button>
	</form>
</div>

<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>