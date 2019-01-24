<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="assets/css/popup.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="bootstrap/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%-- For tests !! ms je sais pas pq il ne marche pas !!  --%>
	<div class="container">
		<h1 class="text-center">Voici Nos Terrains</h1>
		<hr>

		<div class="row">
			<%-- terrain --%>
			<div class="col-md-4 terrain-grid">
				<div class="image-terrain">
					<a href="#"
						onclick="document.getElementById('modal-wrapper1').style.display='block'">
						<img src="terrainsImages/terrain4.jpg" class="w-100">
						<div class="overlay-terrain">
							<div class="detail-terrain">View Details</div>
						</div>
					</a>
				</div>
				<h4 class="text-center">terrain 1 nadi</h4>
				<h5 class="text-center">Price: 20$/hour</h5>
				<a href="#" class="btn reserver-terrain">Reserver</a>
			</div>
			<div id="modal-wrapper1" class="modal-popup">
				<form class="modal-popup-content animate" action="#">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('modal-wrapper1').style.display='none'"
							class="close" title="Close PopUp">&times;</span> <img
							src="terrainsImages/terrain4.jpg" alt="Avatar" class="avatar">
						<h1 style="text-align: center">Modal Popup Box</h1>
					</div>
					<div class="container">
						<h4 class="text-center">terrain 1 nadi</h4>
						<h5 class="text-center">Price: 20$/hour</h5>
						<br />
						<button type="submit">Reserver</button>
					</div>
				</form>
			</div>
			<%-- ./terrain --%>
			<%-- terrain --%>
			<div class="col-md-4 terrain-grid">
				<div class="image-terrain">
					<a href="#"
						onclick="document.getElementById('modal-wrapper2').style.display='block'">
						<img src="terrainsImages/terrain3.jpg" class="w-100">
						<div class="overlay-terrain">
							<div class="detail-terrain">View Details</div>
						</div>
					</a>
				</div>
				<h4 class="text-center">terrain 2 nadi</h4>
				<h5 class="text-center">Price: 20$/hour</h5>
				<a href="#" class="btn reserver-terrain">Reserver</a>
			</div>
			<div id="modal-wrapper2" class="modal-popup">
				<form class="modal-popup-content animate" action="#">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('modal-wrapper2').style.display='none'"
							class="close" title="Close PopUp">&times;</span> <img
							src="terrainsImages/terrain3.jpg" alt="Avatar" class="avatar">
						<h1 style="text-align: center">Modal Popup Box</h1>
					</div>
					<div class="container">
						<h4 class="text-center">terrain 1 nadi</h4>
						<h5 class="text-center">Price: 20$/hour</h5>
						<br />
						<button type="submit">Reserver</button>
					</div>
				</form>
			</div>
			<%-- ./terrain --%>
			<%-- terrain --%>
			<div class="col-md-4 terrain-grid">
				<div class="image-terrain">
					<a href="#"> <img src="terrainsImages/terrain4.jpg"
						class="w-100">
						<div class="overlay-terrain">
							<div class="detail-terrain">View Details</div>
						</div>
					</a>
				</div>
				<h4 class="text-center">terrain 1 nadi</h4>
				<h5 class="text-center">Price: 20$/hour</h5>
				<a href="#" class="btn reserver-terrain">Reserver</a>
			</div>
			<%-- ./terrain --%>
			<%-- terrain --%>
			<div class="col-md-4 terrain-grid">
				<div class="image-terrain">
					<a href="#"> <img src="terrainsImages/terrain3.jpg"
						class="w-100">
						<div class="overlay-terrain">
							<div class="detail-terrain">View Details</div>
						</div>
					</a>
				</div>
				<h4 class="text-center">terrain 1 nadi</h4>
				<h5 class="text-center">Price: 20$/hour</h5>
				<a href="#" class="btn reserver-terrain">Reserver</a>
			</div>
			<%-- ./terrain --%>
		</div>

	</div>
	<script>
		//if user clicks anywhere outside of the modal, modal will close !!
		var list= document.getElementsByClassName("modal-popup");
		window.onclick = function(event) {
			for (var i = 0; i < list.length; i++) {
				if (event.target == list[i]) {
					list[i].style.display = "none";
				} //second console output
			}
		}
	</script>
</body>
</html>