<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">

<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>

<div>
	<form method="post" action="Registration">
		<label for="">Имя</label>
		<input type="text" name="firstname" id="">
		<br/>
		<label for="">Фамилия</label>
		<input type="text" name="secondname" id="">
		<br/>
		<label for="">email</label>
		<input type="text" name="email" id="">
		<br/>
		<label for="">Пароль</label>
		<input type="password" name="password" id="">
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
		<label for="">Почтовый индекс</label>
		<input type="text" name="zipindex" id="">
		<br/>
		<button type="submit">Регистрация</button>
	</form>
</div>

<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>