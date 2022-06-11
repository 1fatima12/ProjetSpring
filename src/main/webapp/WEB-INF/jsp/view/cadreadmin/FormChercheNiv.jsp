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
		<h3>Formulaire de recherche d'un Niveau</h3>
	</div>
	<div>


		<f:form action="cherNiv" method="POST" modelAttribute="NiveauChercheModel" >

			<div class="row">
				<div class="col">
					<label>alias</label>
					<f:input path="alias" type="text" class="form-control"
						placeholder="alias" />
					<f:errors path="alias" class="text-danger" />
				</div>
				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Consulter</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>
   <div>
    <table class="table">
			<thead>
				<tr>
				  <th scope="col">Alias</th>
					<th scope="col">titre</th>
					<th scope="col"> filiere</th>
				</tr>
			</thead>

			
				<tr>
					<td><c:out value="${NiveauCherchee.alias}" /></td>
					<td><c:out value="${NiveauCherchee.titre}"  /></td>
					<td><c:out value="${NiveauCherchee.filiere.getCodeFiliere()}" /></td>
					
				
<td>
						<ul>
						
							

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/UpdateNiveau/${n.idNiveau}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin/SupprimerNiveau/${n.idNiveau}">Supprimer</a></li>

						</ul>
					</td>
				</tr>


		</table>	
   </div>
	
	
	<jsp:include page="../fragments/userfooter.jsp" />