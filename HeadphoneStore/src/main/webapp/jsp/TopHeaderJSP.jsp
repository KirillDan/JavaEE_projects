<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
</head>
<body>
	<div class="top-header-element">
		<div class="top-header-element-logo"><img src="${page.getBlockEntity("top-header").getElementEntity("1").getImgEntity().getSrc()}"></div>
		<div class="top-header-element-service">
			<c:choose>
				<c:when test="${pageContext.session != null && sessionScope.Login == 'Login'}">
					<em>${page.getBlockEntity("top-header").getElementEntity("2").getTxtEntity().getText()}</em>
					<em><em>Кабинет</em>
					<em>Выход</em></em>
				</c:when>
				<c:otherwise>
					<em>${page.getBlockEntity("top-header").getElementEntity("2").getTxtEntity().getText()}</em>
					<em><em>${page.getBlockEntity("top-header").getElementEntity("3").getTxtEntity().getText()}</em>
					<em>${page.getBlockEntity("top-header").getElementEntity("4").getTxtEntity().getText()}</em></em>
				</c:otherwise>
			</c:choose>
			
		</div>
		<a class="top-header-element-cart" href="Cart" style="text-decoration: none">
			<img src="${page.getBlockEntity("top-header").getElementEntity("5").getImgEntity().getSrc()}">
			<div>
				<em>${page.getBlockEntity("top-header").getElementEntity("6").getTxtEntity().getText()}</em>
				<em>${cartSessionEJB.sizeproductEntityIds()}  ${page.getBlockEntity("top-header").getElementEntity("7").getTxtEntity().getText()}</em>
			</div>
		</a>
	</div>
</body>
</html>