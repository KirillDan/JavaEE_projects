<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Вход для менеджера
	<form method="post">
		<label for="">Id</label>
		<input type="text" name="id" id="">
		<br/>
		<label for="">Email</label>
		<input type="text" name="email" id="">
		<br/>
		<label for="">Пароль</label>
		<input type="password" name="password" id="">
		<br>
		<button type="submit">Войти</button>
	</form>
</body>
</html>