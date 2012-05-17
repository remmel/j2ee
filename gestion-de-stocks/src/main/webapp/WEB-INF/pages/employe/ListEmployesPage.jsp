<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="grid_16">
		<h2>
			<fmt:message key="listerEmployes.titre.label" />
		</h2>

		<c:if test="${not empty globalErrors}">
			<p class="error">
				<c:forEach var="error" items="${globalErrors}">
					<fmt:message key="${error}" />
					<br />
				</c:forEach>
			</p>
			<c:remove var="globalErrors" />
		</c:if>

		<%-- Success Messages --%>
		<c:if test="${not empty globalMessages}">
			<p class="success">
				<c:forEach var="msg" items="${globalMessages}">
					<fmt:message key="${msg}" />
					<br />
				</c:forEach>
			</p>
			<c:remove var="globalMessages" scope="session" />
		</c:if>

	</div>

	<div class="clear">&nbsp;</div>

	<div class="grid_16">
		<input type="button" value="Ajouter un employé"
			onClick="javascript:document.location.href='<c:url value="/employe/edit.htm?id=0"/>'" />
	</div>

	<br />

	<br />      

	<div class="clear">&nbsp;</div>

	<form:form method="POST" commandName="serviceInfoData">
		<div class="field">
			<div class="prefix_2 grid_3">
				<label><fmt:message key="listerEmployes.service.titre.label" /></label>

			</div>
			<div class="grid_4 ">
				<form:select path="id">
					<form:option value="" label="-" />
					<form:options items="${listServices}" />
				</form:select>
				<form:errors path="id" />
			</div>

			<div class="grid_4 suffix_2">
				<input type="submit"
					value="<fmt:message
						key="filtrer.bouton.label" />" />
			</div>
		</div>


		<div class="clear">&nbsp;</div>

	</form:form>

	<br />

	<div class="grid_16">

		<table>
			<thead>
				<tr>
					<th><fmt:message key="listerEmployes.civilite.table.label" /></th>
					<th><fmt:message key="listerEmployes.nom.table.label" /></th>
					<th><fmt:message key="listerEmployes.prenom.table.label" /></th>
					<th><fmt:message key="listerEmployes.utilisateur.table.label" /></th>
					<th><fmt:message key="listerEmployes.service.table.label" /></th>
					<th><fmt:message key="listerEmployes.dtEntree.table.label" /></th>
					<th><fmt:message key="listerEmployes.commentaires.table.label" /></th>
					<th><fmt:message key="listerEmployes.salaire.table.label" /></th>
					<th><fmt:message key="listerEmployes.commision.table.label" /></th>
					<th><fmt:message key="listerEmployes.roles.table.label" /></th>
					<th><fmt:message key="listerEmployes.action.table.label" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employes}" var="employe">
					<tr>
						<td>${employe.titre}</td>
						<td>${employe.nom}</td>
						<td>${employe.prenom}</td>
						<td>${employe.utilisateur}</td>
						<td>${employe.service.nom}</td>
						<td>${employe.dateEntree}</td>
						<td>${employe.commentaires}</td>
						<td>${employe.salaire}</td>
						<td>${employe.pctCommission}</td>
						<td><c:if test="${not empty employe.authorities}">
								<c:forEach items="${employe.authorities}" var="authority">
    							${authority}
							</c:forEach>
							</c:if></td>
						<td>
							<ul>
								<li><a
									href="<c:url value='/employe/edit.htm?id=${employe.id}'/>"
									class="edit"><fmt:message key="edit.bouton.label" /></a></li>
								<c:if test="${idCourrant != employe.id}">
									<li><a
										href="<c:url value='/employe/delete.htm?id=${employe.id}'/>"
										class="delete"><fmt:message key="delete.bouton.label" /></a></li>
								</c:if>
							</ul>
						</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>