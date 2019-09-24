<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert</title>
</head>
<body>
	<form action="AdministratorInsertManager" method="post">
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
		<button type="submit">Добавить менеджера</button>
	</form>
</body>
</html>