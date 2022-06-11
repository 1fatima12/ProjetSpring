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
		<h3>Consultation des elements</h3>
	</div>
	<div>


		<f:form action="ConsulterElement" method="POST" modelAttribute="elemModel" >

			

				<div class="col">
					<label>Code</label>
					<f:input path="code" type="text" class="form-control"
						placeholder="code" />
					<f:errors path="code" class="text-danger" />
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
				  <th scope="col">Nom d'Element</th>
					<th scope="col">Code Element</th>
					<th scope="col">Coeficient</th>
					<th scope="col">module Fin Accreditation</th>
					<th scope="col">Enseignant</th>
					
				</tr>
			</thead>
				<tr>
					<td><c:out value="${elementChercher.nom}" /></td>
					<td><c:out value="${elementChercher.code}"  /></td>
					<td><c:out value="${elementChercher.currentCoefficient}"  /></td>
					<td><c:out value="${elementChercher.module.getTitre()}" /></td>
					<td><c:out value="${elementChercher.enseignant.getNom()}" /></td>
				
<td>
						<ul>
						
							

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/UpdateElement/${f.idMatiere}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin/SupprimerElement/${f.idMatiere}">Supprimer</a></li>

						</ul>
					</td>
				</tr>

			

		</table>	
   </div>
	
	<jsp:include page="../fragments/userfooter.jsp" />