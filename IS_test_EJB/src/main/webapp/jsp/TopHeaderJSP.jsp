<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<em>${page.getBlockEntity("top-header").getElementEntity("2").getTxtEntity().getText()}</em>
			<em><em>${page.getBlockEntity("top-header").getElementEntity("3").getTxtEntity().getText()}</em>
			<em>${page.getBlockEntity("top-header").getElementEntity("4").getTxtEntity().getText()}</em></em>
		</div>
		<div class="top-header-element-cart">
			<img src="${page.getBlockEntity("top-header").getElementEntity("5").getImgEntity().getSrc()}">
			<div>
				<em>${page.getBlockEntity("top-header").getElementEntity("6").getTxtEntity().getText()}</em>
				<em>0  ${page.getBlockEntity("top-header").getElementEntity("7").getTxtEntity().getText()}</em>
			</div>
		</div>
	</div>
</body>
</html>