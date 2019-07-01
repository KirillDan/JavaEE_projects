<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/SliderMedia.css">
<link rel="stylesheet" href="CSS/Media.css">
<link rel="stylesheet" type="text/css" href="CSS/Description.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
<title>Main</title>
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
	<img class="banner_picture" width="100%" src="${page.getBlockEntity("banner").getElementEntity("1").getImgEntity().getSrc()}" style="margin-top: 0.7vw"/>
	
	<div class="slider-media-element">
		<div class="slider-media-element-header"><em>${pagemain.getBlockEntity("media-card-container").getElementEntity("1").getTxtEntity().getText()}</em></div>
		<div class="slider-media-element-body">
			<div class="slider-media-element-body-left"><img src="${page.getBlockEntity("media-card-container").getElementEntity("2").getImgEntity().getSrc()}"></div>
			<div class="slider-media-element-body-container">
				<c:forEach items="${blockmain2.getElementEntitySet()}" var="element">
				<div class="media-card">
					<div class="media-card-images" style="background-image: url(${element.getProductEntity().getSrcImg(1)})">
						<img src="${element.getProductEntity().getSrcImg(1)}" class="media-card-image"><img src="${element.getProductEntity().getSrcImg(2)}" class="media-card-image"><img src="${element.getProductEntity().getSrcImg(3)}" class="media-card-image "><img src="${element.getProductEntity().getSrcImg(4)}" class="media-card-image">
					</div>
					<div class="media-card-body">
						<p class="media-card-body-firm">${element.getProductEntity().getFirm()}</p>
						<p class="media-card-body-name">${element.getProductEntity().getName()}</p>
						<a href="" class="media-card-body-detail">${page.getBlockEntity("media-card").getElementEntity("1").getTxtEntity().getText()}</a>
						<hr>
						<a href="" class="media-card-body-buy">${page.getBlockEntity("media-card").getElementEntity("2").getTxtEntity().getText()}</a>
						<em class="media-card-body-price">${element.getProductEntity().getPrice().intValue()} ${page.getBlockEntity("media-card").getElementEntity("3").getTxtEntity().getText()}</em>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="slider-media-element-body-right"><img src="${page.getBlockEntity("media-card-container").getElementEntity("3").getImgEntity().getSrc()}"></div>
		</div>
	</div>
	<div class="slider-media-element">
		<div class="slider-media-element-header"><em>${pagemain.getBlockEntity("media-card-container_2").getElementEntity("1").getTxtEntity().getText()}</em></div>
		<div class="slider-media-element-body">
			<div class="slider-media-element-body-left"><img src="${page.getBlockEntity("media-card-container").getElementEntity("2").getImgEntity().getSrc()}"></div>
			<div class="slider-media-element-body-container">
				<c:forEach items="${blockmain4.getElementEntitySet()}" var="element">
				<div class="media-card">
					<div class="media-card-images" style="background-image: url(${element.getProductEntity().getSrcImg(1)})">
						<img src="${element.getProductEntity().getSrcImg(1)}" class="media-card-image"><img src="${element.getProductEntity().getSrcImg(2)}" class="media-card-image"><img src="${element.getProductEntity().getSrcImg(3)}" class="media-card-image "><img src="${element.getProductEntity().getSrcImg(4)}" class="media-card-image">
					</div>
					<div class="media-card-body">
						<p class="media-card-body-firm">${element.getProductEntity().getFirm()}</p>
						<p class="media-card-body-name">${element.getProductEntity().getName()}</p>
						<a href="" class="media-card-body-detail">${page.getBlockEntity("media-card").getElementEntity("1").getTxtEntity().getText()}</a>
						<hr>
						<a href="" class="media-card-body-buy">${page.getBlockEntity("media-card").getElementEntity("2").getTxtEntity().getText()}</a>
						<em class="media-card-body-price">${element.getProductEntity().getPrice().intValue()} ${page.getBlockEntity("media-card").getElementEntity("3").getTxtEntity().getText()}</em>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="slider-media-element-body-right"><img src="${page.getBlockEntity("media-card-container").getElementEntity("3").getImgEntity().getSrc()}"></div>
		</div>
	</div>
	<div class="description-element">
		<div class="description-element-header" style="background: var(--dark-gray)"><em style="margin-left: 43vw">${pagemain.getBlockEntity("preference").getElementEntity("1").getTxtEntity().getText()}</em></div>
		<div class="description-element-body">
			<img src="${pagemain.getBlockEntity("preference").getElementEntity("2").getImgEntity().getSrc()}" style="width: 66.3541666vw">
		</div>
		<div class="description-element-footer" style="background: var(--dark-gray)"></div>
	</div>
<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>