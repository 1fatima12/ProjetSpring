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


		<f:form action="AjouterModule" method="POST" modelAttribute="Modulemodel" >

			<div class="row">
				<div class="col">
					<label>titre</label>
					<f:input path="titre" type="text" class="form-control"
						placeholder="titre" />
					<f:errors path="titre" class="text-danger" />
				</div>

				<div class="col">
					<label>code</label>
					<f:input path="code" type="text" class="form-control"
						placeholder="code" />
					<f:errors path="code" class="text-danger" />
				</div>
			

			<div class="col">
					<label>niveau</label>
					<f:select path="niveau" multiple="false" size="1"
						class="form-control">
						<f:options items="${nivList}" itemValue="idNiveau" itemLabel="titre" />
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
				  <th scope="col">Titre </th>
					<th scope="col">Code </th>
					<th scope="col">Niveau</th>
				
					
				</tr>
			</thead>

			<c:forEach items="${ModuleList}" var="f">
				<tr>
					<td><c:out value="${f.titre}" /></td>
					<td><c:out value="${f.code}"  /></td>
					<td><c:out value="${f.niveau.getAlias()}" /></td>
					
				
<td>
						<ul>
						
							

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/UpdateModule/${f.idModule}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin/SupprimerModule/${f.idModule}">Supprimer</a></li>
<li><a
								href="${pageContext.request.contextPath}/cadreadmin/listeElement/${f.idModule}">Elements</a></li>
						</ul>
					</td>
				</tr>

			</c:forEach>

		</table>	
   </div>
	<jsp:include page="../fragments/userfooter.jsp" />