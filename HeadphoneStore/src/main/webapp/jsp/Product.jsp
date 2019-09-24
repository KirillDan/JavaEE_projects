<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/TopHeader.css">
<link rel="stylesheet" type="text/css" href="CSS/Header.css">
<link rel="stylesheet" type="text/css" href="CSS/ProductContainer.css">
<link rel="stylesheet" type="text/css" href="CSS/Media.css">
<link rel="stylesheet" type="text/css" href="CSS/Validator.css">
<link rel="stylesheet" type="text/css" href="CSS/Footer.css">
<link rel="stylesheet" type="text/css" href="CSS/SubFooter.css">
<link rel="stylesheet" type="text/css" href="CSS/MediaObject.css">
<link rel="stylesheet" type="text/css" href="CSS/Characteristics.css">
</head>
<body>
<jsp:include page="TopHeaderJSP.jsp"></jsp:include>
<jsp:include page="HeaderJSP.jsp"></jsp:include>
	<div class="media-container-object" style="margin-top: 1.3vw">
		<div class="media-container-object-triangle"></div>
		<div class="media-container-object-name"><em>${product.getFirm()} ${product.getName()}</em></div>
		<div class="media-object">
			<div class="media-object-front-image" style="background-image: url(${product.getSrcImg(2)})"></div>
			<div class="media-object-body">
				<div class="media-object-body-subheader"><em>${page.getBlockEntity("media-object").getElementEntity("1").getTxtEntity().getText()}</em></div>
				<div class="media-object-body-body">
					<a href="" class="media-object-body-text1">${page.getBlockEntity("media-object").getElementEntity("2").getTxtEntity().getText()} </a>
					<div class="media-object-body-text2and3">
						<em class="media-object-body-text2">${page.getBlockEntity("media-object").getElementEntity("3").getTxtEntity().getText()}</em>
						<a href="" class="media-object-body-text3">${page.getBlockEntity("media-object").getElementEntity("5").getTxtEntity().getText()}</a>
					</div>
					<div class="media-object-images">
						<c:forEach var="i" begin="1" end="5">
						<c:if test="${product.getSrcImg(i).length() > 0}">
						<img src="${product.getSrcImg(i)}" class="media-object-image">
						</c:if>
						</c:forEach>
					</div>
					<div><em class="media-object-body-price">- ${product.getPrice()} ${page.getBlockEntity("media-object").getElementEntity("8").getTxtEntity().getText()}</em>
						<em class="media-object-body-rating">
						<c:forEach var="i" begin="1" end="${product.getRating()}">
						 &#9733
						</c:forEach>
						<c:forEach var="i" begin="1" end="${5 - product.getRating()}">
						 &#9734
						</c:forEach>
						</em>
					</div>
					<div class="media-object-body-footer"><div href="" class="media-object-body-cart"><em>${page.getBlockEntity("media-object").getElementEntity("6").getTxtEntity().getText()}	<br><em>${page.getBlockEntity("media-object").getElementEntity("6a").getTxtEntity().getText()}</em></em></div><div href="" class="media-object-body-buy"><em>${page.getBlockEntity("media-object").getElementEntity("7").getTxtEntity().getText()}<br><em>	${page.getBlockEntity("media-object").getElementEntity("7a").getTxtEntity().getText()}</em></em></div></div>
				</div>
			</div>
		</div>
	</div>
<div class="description-element"  style="margin-top: 1.3vw">
		<div class="description-element-header"><em>Описание</em></div>
		<div class="description-element-body">
		<em>DT 1990 PRO - это открытые студийные наушники для микширования и мастеринга. Открытый дизайн приводит к очень пространственному, динамичному и естественному звучанию с оригинальным воспроизведением. Эффективные драйверы Tesla обеспечивают идеальный звук с превосходным разрешением и высокой производительностью уровень.</em>
		<em>DT 1990 PRO имеет современный дизайн с дискретной элегантностью всех компонентов, таких как как торцевые части, хомуты, ушные чашки и оголовье. Все компоненты заменяются и обеспечивают длительный срок службы наушников.</em>
		<em>Удобные, сменные вкладыши для ушей и регулируемая головная повязка со сменной панелью обеспечить превосходный комфорт в течение длительного периода времени и абсолютно безопасную посадку. Односторонний кабель съемный и запираемый. Поставляемый жесткий футляр обеспечивает безопасную транспортировку или хранение. Наушники снабжены двумя парами подушечек для ушей для различных звуковых вариаций от нейтральный звук для звука с небольшим усилением басов.</em>
		</div>
		<div class="description-element-footer"></div>
	</div>
<div class="characteristics-element"  style="margin-top: 1.3vw">
        <div class="characteristics-element-header"><em>Технические характеристики</em></div>
        <div class="characteristics-element-body">
            <em>Тип преобразователя</em><em>динамический</em>
            <em>Тип конструкции</em><em>открытый</em>
			<em>Частотный диапазон</em><em>5 - 40 000 Гц</em>
			<em>Номинальное сопротивление</em><em>250 Ом</em>
			<em>Номинальный SPL</em><em>102 дБ SPL (1 мВт / 500 Гц)</em>
			<em>Максимум SPL</em><em>125 дБ SPL (200 мВт / 500 Гц)</em>
			<em>T.H.D. </em><em>&lt0,05% (1 мВт / 500 Гц)</em>
			<em>Номинальная мощность</em><em>200 мВт</em>
			<em>Номинальное контактное давление</em><em>6,6 Н</em>
			<em>Вес (без кабеля)</em><em>370 г</em>
			<em>Длина и тип кабеля</em><em>3 м / прямой кабель</em>
			<em>Подключение</em><em>Позолоченный мини-стереоразъем</em>
       </div>
        <div class="characteristics-element-footer"></div>
</div>
<jsp:include page="FooterJSP.jsp"></jsp:include>
</body>
</html>