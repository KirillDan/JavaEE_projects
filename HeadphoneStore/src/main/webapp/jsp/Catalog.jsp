<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalog</title>
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" href="CSS/ProductContainer.css">
<link rel="stylesheet" href="CSS/Media.css">
<link rel="stylesheet" href="CSS/Validator.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
	<div class="product-container-element">
		<div class="product-container-element-left">
			<!--Validator------------------------------------------------------------->
			<div class="validator-element">
				<div class="validator-element-header"><em>${page.getBlockEntity("validator-firm").getElementEntity("0").getTxtEntity().getText()}</em></div>
				<div class="validator-element-body">
					<c:forEach items="${blockmainFirm.getElementEntitySet()}" var="element">
					<c:if test="${element.getNumber() > 0}">
					<em><em></em>${element.getTxtEntity().getText()}</em>
					</c:if>
					</c:forEach>
				</div>
			</div>
						<!--Validator------------------------------------------------------------->
			<div class="validator-element">
				<div class="validator-element-header"><em>${page.getBlockEntity("validator-type-headphones").getElementEntity("0").getTxtEntity().getText()}</em></div>
				<div class="validator-element-body">
					<c:forEach items="${blockmainTypeH.getElementEntitySet()}" var="element">
					<c:if test="${element.getNumber() > 0}">
					<em><em></em>${element.getTxtEntity().getText()}</em>
					</c:if>
					</c:forEach>
				</div>
			</div>			<!--Validator------------------------------------------------------------->
			<div class="validator-element">
				<div class="validator-element-header"><em>${page.getBlockEntity("validator-tdh").getElementEntity("0").getTxtEntity().getText()}</em></div>
				<div class="validator-element-body">
					<c:forEach items="${blockmainTDH.getElementEntitySet()}" var="element">
					<c:if test="${element.getNumber() > 0}">
					<em><em></em>${element.getTxtEntity().getText()}</em>
					</c:if>
					</c:forEach>
				</div>
			</div>

		</div>
		<div class="product-container-element-right">
			<c:forEach items="${listProductEntity}" var="element">
			<!--MediaCard--------------------------------------------------------------------------------------------->
			<div class="media-card">
					<div class="media-card-images" style="background-image: url(${element.getSrcImg(1)})">
						<img src="${element.getSrcImg(1)}" class="media-card-image"><img src="${element.getSrcImg(2)}" class="media-card-image"><img src="${element.getSrcImg(3)}" class="media-card-image "><img src="${element.getSrcImg(4)}" class="media-card-image">
					</div>
					<div class="media-card-body">
						<p class="media-card-body-firm">${element.getFirm()}</p>
						<p class="media-card-body-name">${element.getName()}</p>
						<a href="Product?productId=${element.getProductEntityId()}" class="media-card-body-detail">${page.getBlockEntity("media-card").getElementEntity("1").getTxtEntity().getText()}</a>
						<hr>
						<a href="Catalog?cartproductId=${element.getProductEntityId()}" class="media-card-body-buy">${page.getBlockEntity("media-card").getElementEntity("2").getTxtEntity().getText()}</a>
						<em class="media-card-body-price">${element.getPrice().intValue()} ${page.getBlockEntity("media-card").getElementEntity("3").getTxtEntity().getText()}</em>
					</div>
				</div>
			</c:forEach>

		<!-- 	<div class="product-container-element-right-footer"><em>${page.getBlockEntity("text-see-more").getElementEntity("1").getTxtEntity().getText()}</em></div>    -->
		</div>
	</div>
<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>