<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
</head>
<body>
<div class="header-element">
		<em><a href="ServletTestJSP" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("header").getElementEntity("1").getTxtEntity().getText()}</a></em>
		<em><a href="Catalog" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("header").getElementEntity("2").getTxtEntity().getText()}</a></em>
		<em><a href="AboutCompany" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("header").getElementEntity("3").getTxtEntity().getText()}</a></em>
		<em><a href="Delivery" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("header").getElementEntity("4").getTxtEntity().getText()}</a></em>
		<em><a href="Contacts" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("header").getElementEntity("5").getTxtEntity().getText()}</a></em>
	</div>
</body>
</html>