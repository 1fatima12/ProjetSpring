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
		<h3>Formulaire d'ajout d'une filiere</h3>
	</div>
	<div>


		<f:form action="AjouterFiliere" method="POST" modelAttribute="Filieremodel" >

			<div class="row">
				<div class="col">
					<label>titreFiliere</label>
					<f:input path="titreFiliere" type="text" class="form-control"
						placeholder="titreFiliere" />
					<f:errors path="titreFiliere" class="text-danger" />
				</div>

				<div class="col">
					<label>codeFiliere</label>
					<f:input path="codeFiliere" type="text" class="form-control"
						placeholder="codeFiliere" />
					<f:errors path="codeFiliere" class="text-danger" />
				</div>
			<div class="col">
					<label>anneeccreditation</label>
					<f:input path="anneeaccreditation" type="text" class="form-control"
						placeholder="anneeaccreditation" />
					<f:errors path="anneeaccreditation" class="text-danger" />
				</div>
				<div class="col">
					<label>anneeFinaccreditation</label>
					<f:input path="anneeFinaccreditation" type="text" class="form-control"
						placeholder="anneeFinaccreditation" />
					<f:errors path="anneeFinaccreditation" class="text-danger" />
				</div>
				<div class="col">
					<label>Coordinateur</label>
					<f:select path="enseignant" multiple="false" size="1"
						class="form-control">
						<f:options items="${listEns}" itemValue="idUtilisateur" itemLabel="nom" />
					</f:select>
				</div>
			

			
			
				


				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
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

			<c:forEach items="${filiereList}" var="f">
				<tr>
					<td><c:out value="${f.titreFiliere}" /></td>
					<td><c:out value="${f.codeFiliere}"  /></td>
					<td><c:out value="${f.anneeaccreditation}" /></td>
					<td><c:out value="${f.anneeFinaccreditation}" /></td>
					<td><c:out value="${f.enseignant.getNom()}" /></td>
				
				
<td>
						<ul>
						
							

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/UpdateFiliere/${f.idFiliere}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin/SupprimerFiliere/${f.idFiliere}">Supprimer</a></li>
<li><a
								href="${pageContext.request.contextPath}/cadreadmin/listeNiveau/${f.idFiliere}">Niveaux</a></li>
						</ul>
					</td>
				</tr>

			</c:forEach>

		</table>	
   </div>
	
	<jsp:include page="../fragments/userfooter.jsp" />