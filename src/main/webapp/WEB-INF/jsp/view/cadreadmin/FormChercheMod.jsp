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
		<h3>Formulaire d'ajout d'un Module</h3>
	</div>
	<div>


		<f:form action="ChercherModule" method="POST" modelAttribute="Modulerechmodel" >

			<div class="col">
					<label>code</label>
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
				  <th scope="col">Titre </th>
					<th scope="col">Code </th>
					<th scope="col">Niveau</th>
				
					
				</tr>
			</thead>

			
				<tr>
					<td><c:out value="${modulecherche.titre}" /></td>
					<td><c:out value="${modulecherche.code}"  /></td>
					<td><c:out value="${modulecherche.niveau.getAlias()}" /></td>
					
				
<td>
						<ul>
						
							

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/UpdateModule/${f.idModule}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin/SupprimerModule/${f.idModule}">Supprimer</a></li>

						</ul>
					</td>
				</tr>


		</table>	
   </div>
	<jsp:include page="../fragments/userfooter.jsp" />