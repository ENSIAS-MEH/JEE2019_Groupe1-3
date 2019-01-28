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
					<a href="#" class="btn reserver-terrain">Reserver</a>
				</div>
				<div id="modal-wrapper${terrain.id_terrain}" class="modal-popup">
				<form class="modal-popup-content animate" action="#">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('modal-wrapper${terrain.id_terrain}').style.display='none'"
							class="close" title="Close PopUp">&times;</span> 
							<img src="terrainsImages/${terrain.image}" alt="Avatar" class="avatar">
						<h1 style="text-align: center">Modal Popup Box</h1>
					</div>
					<div class="container">
						<h4 class="text-center">${terrain.description }</h4>
						<h5 class="text-center">Prix: ${terrain.prix }MAD/heurer</h5>
						<br />
						<button type="submit">Reserver</button>
					</div>
				</form>
			</div>
				
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
	</script>
</body>
</html>