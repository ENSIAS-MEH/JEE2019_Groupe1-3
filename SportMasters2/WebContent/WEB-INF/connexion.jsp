<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  !!!!!! -->
<html>
<title>Connexion</title>
<link href="assets/css/form.css" rel="stylesheet" type="text/css" >
<link href="assets/css/signUp.css" rel="stylesheet" type="text/css">
<%@ include file="/includes/css.jsp"%>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<body>
	<%@ include file="/includes/header.jsp"%>
	<h1
		style="text-align: center; font-size: 50px; color: #000; margin-top: 50px;">Veuillez
		SVP remplir la fiche de connexion</h1>
	<form class="modal-popup-content animate" method="post" action="connexion">
		<div class="imgcontainer">
			<img src="images/avatar.png" alt="Avatar" class="avatar">
			<h1 style="text-align: center">Connexion</h1>
		</div>

		<div class="container">
			<input type="text"
				<c:if test="${! empty form}">value="<c:out value="${utilisateur.email}"/>"</c:if>
				placeholder="Entrer votre email"
				name="email"
				size="20" maxlength="60" />
			<span class="erreur">${form.erreurs['email']}</span>
			<input type="password" id="motdepasse"
				placeholder="Entrer votre mot de passe" name="motdepasse" size="20"
				maxlength="20"> 
			<span class="erreur">${form.erreurs['motdepasse']}</span>
			<br/>
			<button type="submit">se connecter</button>
		</div>
	</form>
	<%@ include file="/includes/footer.jsp"%>
	<%@ include file="/includes/js.jsp"%>
</body>
</html>