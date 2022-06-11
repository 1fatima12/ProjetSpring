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
		<h3>Formulaire d'ajout d'un Elemenr</h3>
	</div>
	<div>


		<f:form action="AjouterElement" method="POST" modelAttribute="Elementmodel" >

			<div class="row">
				<div class="col">
					<label>Nom</label>
					<f:input path="nom" type="text" class="form-control"
						placeholder="nom" />
					<f:errors path="nom" class="text-danger" />
				</div>

				<div class="col">
					<label>Code</label>
					<f:input path="code" type="text" class="form-control"
						placeholder="code" />
					<f:errors path="code" class="text-danger" />
				</div>
			<div class="col">
					<label>current Coefficient</label>
					<f:input path="currentCoefficient" type="text" class="form-control"
						placeholder="currentCoefficient" />
					<f:errors path="currentCoefficient" class="text-danger" />
				</div>
				<div class="col">
					<label>Enseignant</label>
				
					<f:select path="enseignant" multiple="false" size="1"
						class="form-control">
						<f:options items="${listEns}" itemValue="idUtilisateur" itemLabel="nom" />
					</f:select>
				</div>
				<div class="col">
					<label>Module</label>
				
					<f:select path="module" multiple="false" size="1"
						class="form-control">
						<f:options items="${listMod}" itemValue="idModule" itemLabel="code" />
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
				  <th scope="col">Nom d'Element</th>
					<th scope="col">Code Element</th>
					<th scope="col">Coeficient</th>
					<th scope="col">module Fin Accreditation</th>
					<th scope="col">Enseignant</th>
					
				</tr>
			</thead>
<c:forEach items="${ElementList}" var="f">
				<tr>
					<td><c:out value="${f.nom}" /></td>
					<td><c:out value="${f.code}"  /></td>
					<td><c:out value="${f.currentCoefficient}"  /></td>
					<td><c:out value="${f.module.getTitre()}" /></td>
					<td><c:out value="${f.enseignant.getNom()}" /></td>
				
<td>
						<ul>
						
							

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/UpdateElement/${f.idMatiere}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin/SupprimerElement/${f.idMatiere}">Supprimer</a></li>

						</ul>
					</td>
				</tr>

			</c:forEach>
			

		</table>	
   </div>
	
	<jsp:include page="../fragments/userfooter.jsp" />