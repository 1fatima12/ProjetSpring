<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<div class="collapse navbar-collapse" id="navbarNav">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page"
			href="${pageContext.request.contextPath}/user/showUserHome">Home</a></li>
<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Gestion De Module </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/formView">Ajouter Un Module</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/listeModule">Liste De Modules</a></li>
					<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/chercherMod">Chercher Module</a></li>
				


			</ul></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Gestion De Filiere </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/formFiliereView">Ajouter Une Filiere</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/listFil">Liste Des Filiere</a></li>
				
                <li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/chercherfil">Chercher Filiere</a></li>

			</ul></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Gestion De Niveau </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrolniveaulingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/formNiveauView">Ajouter Un Niveau</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/ListeNiveaux">Liste Des Niveaux</a></li>
				
                <li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/chercherNiveau">Chercher Niveau</a></li>

			</ul></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Gestion D'Element </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrolniveaulingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/viewElement">Ajouter Un Element</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/ListeElement">Liste Des Elements</a></li>
				
                <li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/showConsult">Chercher Un Element</a></li>

			</ul></li>

		<f:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			<button type="submit" class="btn btn-link">logout</button>
			
			</f:form></li>
	</ul>
</div>