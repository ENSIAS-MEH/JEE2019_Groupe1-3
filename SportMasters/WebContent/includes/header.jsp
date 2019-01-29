<!--  header -->
<!-- 
<header id="header">
	<div class="inner">
		<a href="/SportMasters" class="logo">SportMasters</a>
		<nav id="nav">
			<a href="#">About</a> <a href="#">Contact</a> <a href="#">Contact</a>
			<a href="#">Contact</a> <a href="#" class="menu"
				onclick="document.getElementById('submenu').style.display='block'">Services</a>
				<ul id="submenu">
					<li><a href="#">Link1</a></li>
					<li><a href="#">Link 2</a></li>
					<li><a href="#">Link 3</a></li>
					<li><a href="#">Link 4</a></li>
				</ul>
			<!-- 
			<a href="/SportMasters">Accueil</a> <a href="listeTerrains">Reservation</a>
			<c:if test="${empty sessionScope.sessionUtilisateur}">
				<a href="connexion">Se Connecter</a>
			</c:if>
			<a href="#">Contact</a> <a>Contact</a>
			 -->
		<!--
		</nav>
	</div>
</header>
 --> 
<header id="header">
	<div class="inner">
		<a href="index.jsp" class="logo">SportMasters</a>
		<nav id="nav">
			<a href="/SportMasters">Accueil</a> 
			<a href="listeTerrains">Reservation</a> 
			<a href="#footer_contact">Contact</a>
			<c:choose>
				<c:when test="${empty sessionScope.sessionUtilisateur}">
					<a href="connexion">Se Connecter</a>
				</c:when>
				<c:when test="${!empty sessionScope.sessionUtilisateur}">
					<a href="#">mon compte</a>
					<a href="deconnexion" onclick="seDeconnecter()">Se deconnecter</a>
				</c:when>
			</c:choose>
		</nav>
	</div>
</header>
