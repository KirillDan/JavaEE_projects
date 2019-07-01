<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/Description.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
</head>
<body>
<div class="footer-element" style="margin-top: 1vw">
		<img src="${page.getBlockEntity("footer").getElementEntity("1").getImgEntity().getSrc()}">
		<div>
			<em><em><a href="ServletTestJSP" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("footer").getElementEntity("2").getTxtEntity().getText()}</a></em><em><a href="Catalog" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("footer").getElementEntity("3").getTxtEntity().getText()}</a></em></em>
			<em><em><a href="Delivery" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("footer").getElementEntity("4").getTxtEntity().getText()}</a></em><em><a href="AboutCompany" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("footer").getElementEntity("5").getTxtEntity().getText()}</a></em></em>
			<em><em><a href="Contacts" style="color: #FFFFFF; text-decoration: none;">${page.getBlockEntity("footer").getElementEntity("6").getTxtEntity().getText()}</a></em></em>
			<em><em>${page.getBlockEntity("footer").getElementEntity("7").getTxtEntity().getText()}</em><em>${page.getBlockEntity("footer").getElementEntity("8").getTxtEntity().getText()}</em></em>
			<em><em>${page.getBlockEntity("footer").getElementEntity("9").getTxtEntity().getText()}</em></em>
		</div>
	</div>
	<div class="description-element" style="margin-top: 1vw">
		<div class="description-element-footer" style="background: var(--dark-gray)"></div>
	</div>
	<div class="subfooter-element" style="margin-top: 1vw">
		<em>${page.getBlockEntity("subfooter").getElementEntity("1").getTxtEntity().getText()}</em>
		<em>${page.getBlockEntity("subfooter").getElementEntity("2").getTxtEntity().getText()}</em>
		<em>${page.getBlockEntity("subfooter").getElementEntity("3").getTxtEntity().getText()}</em>
	</div>
</body>
</html>