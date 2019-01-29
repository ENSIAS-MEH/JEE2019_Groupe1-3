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
	<div class="container">
		<h1 class="text-center">Voici Nos Terrains</h1>


		<div class="row">
			<c:forEach items="${listeTerrains}" var="terrain">
				<%-- terrain --%>
				<div class="col-md-4 terrain-grid">
					<div class="image-terrain">
						<a href="#" onclick="document.getElementById('modal-wrapper${terrain.id_terrain}').style.display='block'"> <img src="terrainsImages/${terrain.image}"
							class="w-100">
							<div class="overlay-terrain">
								<div class="detail-terrain">View Details</div>
							</div>
						</a>
					</div>
					<h4 class="text-center">${terrain.description }</h4>
					<h5 class="text-center">Prix: ${terrain.prix }MAD/heure</h5>
					<c:choose>
						<c:when test="${empty sessionScope.sessionUtilisateur}">
							<c:set var="listeTerrains" value="true" scope="session" /> <%-- indiquer à la page connexion qu'on veut se rediriger vers la page de listeTerrains apres la connexion --%>
							<a href="connexion" onclick="myFunction()" class="btn reserver-terrain">Reserver</a>
						</c:when>
						<c:when test="${!empty sessionScope.sessionUtilisateur}">
							<a href="#connected" class="btn reserver-terrain">Reserver</a>
						</c:when>
					</c:choose>
				</div>
				<div id="modal-wrapper${terrain.id_terrain}" class="modal-popup">
				<c:choose>
					<c:when test="${empty sessionScope.sessionUtilisateur}">
						<c:set var="listeTerrains" value="true" scope="session" /> <%-- indiquer à la page connexion qu'on veut se rediriger vers la page de listeTerrains apres la connexion --%>
						<form class="modal-popup-content animate" action="connexion" >
					</c:when>
					<c:when test="${!empty sessionScope.sessionUtilisateur}">
						<form class="modal-popup-content animate" action="reserver" method="post">
					</c:when>
				</c:choose> 
				<form class="modal-popup-content animate" action="reserver" method="post">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('modal-wrapper${terrain.id_terrain}').style.display='none'"
							class="close" title="Close PopUp">&times;</span> 
							<img src="terrainsImages/${terrain.image}" alt="Avatar" class="avatar">
						<h3 style="text-align: center">Infos terrain</h1>
					</div>
					<div class="container">
						<h4 class="text-center">${terrain.description }</h4>
						<h5 class="text-center">Prix: ${terrain.prix }MAD/heurer</h5>
						<br />
						
						<%--
						onclick="document.getElementById('ModalWrapper2${terrain.id_terrain}').style.display='block'" 
						--%>
						<%--<a type="submit" class="btn reserver-terrain" ${empty sessionScope.sessionUtilisateur ? 'onclick="myFunction()"' : 'onclick=""'} >Reeeserver</a>--%>
						<input type="hidden" id="id_terrain" name="id_terrain" value="${terrain.id_terrain }">
						<%--<input type="submit" value="Reserver" class="btn reserver-terrain">
						--%>
						<button type="submit" ${empty sessionScope.sessionUtilisateur ? 'onclick="myFunction()"' : 'onclick=""'} >Reserver</button>
						
					</div>
				</form>
			</div>
			<%--
			<div id="modal-wrapper2${terrain.id_terrain}" class="modal-popup2"> 
				<form class="modal-popup-content animate" action="#">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('modal-wrapper${terrain.id_terrain}').style.display='none'"
							class="close" title="Close PopUp">&times;</span> 
							<img src="terrainsImages/${terrain.image}" alt="Avatar" class="avatar">
						<h3 style="text-align: center">Infos terrain</h1>
					</div>
					<div class="container">
						<h4 class="text-center">${terrain.description }</h4>
						<h5 class="text-center">Prix: ${terrain.prix }MAD/heurer</h5>
						<br />
						<button type="submit" nclick="myFunction()" >Reserver</button>
					</div>
				</form>
			</div>
			 --%>
				<%-- ./terrain --%>
			</c:forEach>
		</div>
	</div>
	<%@ include file="/includes/footer.jsp"%>
	<%@ include file="/includes/js.jsp"%>
	<script>
		//if user clicks anywhere outside of the modal, modal will close !!
		var list= document.getElementsByClassName("modal-popup");
		window.onclick = function(event) {
			for (var i = 0; i < list.length; i++) {
				if (event.target == list[i]) {
					list[i].style.display = "none";
				}
			}
		}
		function myFunction() {
			 alert("Connecter vous d'abord SVP!");
		}
	</script>
</body>
</html>