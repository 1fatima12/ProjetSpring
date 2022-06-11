<%@page import="com.gsnotes.web.models.PersonModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />


<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<jsp:include page="../fragments/usermenu.jsp" />

		</div>
	</nav>



	<div>
		<h3>Formulaire de recherche de filiere</h3>
	</div>
	<div>


		<f:form action="cherFil" method="POST" modelAttribute="Filiererechmodel" >

			

				<div class="col" >
					<label>codeFiliere</label>
					<f:input path="codeFiliere" type="text" class="form-control"
						placeholder="codeFiliere" />
					<f:errors path="codeFiliere" class="text-danger" />
				</div>
			
				
				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Chercher</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>
   <div>
    <table class="table">
			<thead>
				<tr>
				  <th scope="col">Titre de Filiere</th>
					<th scope="col">Code Filiere</th>
					<th scope="col">Annee Accreditation</th>
					<th scope="col">Annee Fin Accreditation</th>
					<th scope="col">Cordinateur</th>
					
				</tr>
			</thead>

			
				<tr>
					<td><c:out value="${filerecherche.titreFiliere}" /></td>
					<td><c:out value="${filerecherche.codeFiliere}"  /></td>
					<td><c:out value="${filerecherche.anneeaccreditation}" /></td>
					<td><c:out value="${filerecherche.anneeFinaccreditation}" /></td>
					<td><c:out value="${filerecherche.enseignant.getNom()}" /></td>
				
				

				</tr>


		</table>	
   </div>
	
	<jsp:include page="../fragments/userfooter.jsp" />