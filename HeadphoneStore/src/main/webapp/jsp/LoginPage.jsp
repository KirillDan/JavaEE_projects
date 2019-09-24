<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">

<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>

<div>
	<form method="post" action="Login" >
		<label for="">Email</label>
		<input type="text" name="email" id="">
		<br/>
		<label for="">Пароль</label>
		<input type="password" name="password" id="">
		<br>
		<button type="submit">Войти</button>
	</form>
</div>

<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>