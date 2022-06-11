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
								href="${pageContext.request.contextPath}/cadreadmin//${f.idModule}">Update</a></li>
					<li><a
								href="${pageContext.request.contextPath}/cadreadmin//${f.idModule}">Supprimer</a></li>

						</ul>
					</td>
				</tr>

			</c:forEach>

		</table>	
   </div>
	<jsp:include page="../fragments/userfooter.jsp" />