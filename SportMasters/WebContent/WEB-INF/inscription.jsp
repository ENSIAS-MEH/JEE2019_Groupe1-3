<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  !!!!!! -->
<html>
<title>Inscription</title>
<link href="assets/css/form.css" rel="stylesheet" type="text/css" >
<link href="assets/css/signUp.css" rel="stylesheet" type="text/css">
<%@ include file="/includes/css.jsp"%>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<body>
	<%@ include file="/includes/header.jsp"%>
	<h1
		style="text-align: center; font-size: 50px; color: #000; margin-top: 50px;">Veuillez
		SVP remplir la fiche d'inscription</h1>
	<form class="modal-popup-content animate" method="post" action="inscription">
		<div class="imgcontainer">
			<img src="images/avatar.png" alt="Avatar" class="avatar">
			<h1 style="text-align: center">Inscription</h1>
		</div>

		<div class="container">
			<input type="text"
				<c:if test="${! empty form}">value="<c:out value="${utilisateur.email}"/>"</c:if>
				<%-- 
				<c:choose>
					<c:when test="${empty form}">placeholder="Entrer votre email" </c:when>
					<c:otherwise>value="<c:out value="${utilisateur.email}"/>"</c:otherwise>
				</c:choose>
				--%>
				placeholder="Entrer votre email"
				name="email"
				size="20" maxlength="60" />
			<span class="erreur">${form.erreurs['email']}</span>
			<input type="password" id="motdepasse"
				placeholder="Entrer votre mot de passe" name="motdepasse" size="20"
				maxlength="20"> 
			<span class="erreur">${form.erreurs['motdepasse']}</span>
			<input type="password" id="confirmation"
				name="confirmation" placeholder="Confirmer le Password" size="20"
				maxlength="20" /> 
			<span class="erreur">${form.erreurs['confirmation']}</span>
			<input type="text" id="nom" name="nom" size="20"
				<c:if test="${! empty form}">value="<c:out value="${utilisateur.nom}"/>"</c:if>
				placeholder="Entrer votre nom d'utilisateur " maxlength="20" />
			<span class="erreur">${form.erreurs['nom']}</span>
			<button type="submit">S'inscrir</button>
		</div>
	</form>
	<%@ include file="/includes/footer.jsp"%>
	<%@ include file="/includes/js.jsp"%>
</body>
</html>