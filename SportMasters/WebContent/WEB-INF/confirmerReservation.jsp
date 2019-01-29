<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<title>SportMasters</title>
<link href="assets/css/popup.css" rel="stylesheet" type="text/css">
<%@ include file="/includes/css.jsp"%>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="bootstrap/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	<div id="modal-wrapper" class="modal-popup2">
		<form class="modal-popup-content animate" action="#">
			<div class="imgcontainer">
				<img src="terrainsImages/${terrain.image}" alt="Avatar"
					class="avatar">
				<h3 style="text-align: center">
					Infos terrain
					</h1>
			</div>
			<div class="container">
				<h4 class="text-center">${terrain.description }</h4>
				<h5 class="text-center">Prix: ${terrain.prix }MAD/heurer</h5>
				<br/>
				<c:forEach var="i" begin="0" end="13" step="1">
					<c:set var="exist" value="${false}" />
					<c:forEach items="${listLouerTerrain.list}" var="louerTerrain">
						<%--<c:out value="ici ${louerTerrain.heure }"/>--%>
						<%--<c:out value="ici ${i+8 }"/>--%>
						<c:if test="${louerTerrain.heure == i+8}">
							<c:set var="exist" value="${true}" />
						</c:if>
					</c:forEach>
					
					<%--<c:out value="exist = ${exist}"></c:out> --%>
					<c:if test="${!exist}">
						<c:set var="maVar1" value="${i+8}" />
						<c:set var="maVar2" value="${i+9}" />
						<h6 style="text-align: center">
							<c:out
								value="Le terrain est disponible entre ${maVar1}h et ${maVar2 }h" />
						</h6>
						<button type="submit">Reserver pour cette heure</button>

						<br />
						<br />
						<br />
					</c:if>
				</c:forEach>
				<%-- <button type="submit">Reserver</button>  --%>
			</div>
		</form>
	</div>
	<%@ include file="/includes/footer.jsp"%>
	<%@ include file="/includes/js.jsp"%>
</body>
</html>