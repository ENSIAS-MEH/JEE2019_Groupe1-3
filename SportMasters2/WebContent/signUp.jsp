<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Inscription</title>
<link href="assets/css/signUp.css" rel="stylesheet" type="text/css">
<%@ include file="/includes/css.jsp"%>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<body>
	<%@ include file="/includes/header.jsp"%>
	<h1
		style="text-align: center; font-size: 50px; color: #000; margin-top: 50px;">Veuillez
		SVP remplir la fiche d'insscription</h1>
	<form class="modal-popup-content animate" action="#">
		<div class="imgcontainer">
			<img src="images/avatar.png" alt="Avatar" class="avatar">
			<h1 style="text-align: center">Inscription</h1>
		</div>

		<div class="container">
			<input type="text" placeholder="Entrer votre email" name="email"
				size="20" maxlength="60" /> 
			<input type="password" id="motdepasse"
				placeholder="Entrer votre mot de passe" name="motDePasse" size="20"
				maxlength="20"> 
			<input type="password" id="confirmation"
				name="confirmation" placeholder="Confirmer le Password" size="20"
				maxlength="20" /> 
			<input type="text" id="nom" name="nom" size="20"
				placeholder="Entrer votre nom d'utilisateur " maxlength="20" />
			<button type="submit">S'inscrir</button>
		</div>
	</form>
	<%@ include file="/includes/footer.jsp"%>
	<%@ include file="/includes/js.jsp"%>
</body>
</html>