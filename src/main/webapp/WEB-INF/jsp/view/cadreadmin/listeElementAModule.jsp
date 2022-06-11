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
		<h3>Liste des Elements Associer à un module</h3>
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

			<c:forEach items="${listeElementAModule}" var="f">
				<tr>
					<td><c:out value="${f.nom}" /></td>
					<td><c:out value="${f.code}"  /></td>
					<td><c:out value="${f.currentCoefficient}"  /></td>
					<td><c:out value="${f.module.getTitre()}" /></td>
					<td><c:out value="${f.enseignant.getNom()}" /></td>
				

				</tr>

			</c:forEach>
			
		</table>	
   </div>
	<jsp:include page="../fragments/userfooter.jsp" />