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
	<h2>
		<fmt:message key="listerClients.titre.label" />
	</h2>
	<div class="grid_16">
		<p>
			<input type="button" value="Ajouter un client"
				onClick="javascript:document.location.href='<c:url value="/client/edit.htm?id=0"/>'" />
		</p>
	</div>

	<div class="clear">&nbsp;</div>

	<br />

	<div class="grid_16">
		<table>
			<thead>
				<tr>
					<th><fmt:message key="listerClients.nom.table.label" /></th>
					<th><fmt:message key="listerClients.telephone.table.label" /></th>
					<th><fmt:message key="listerClients.adresse.table.label" /></th>
					<th><fmt:message key="listerClients.ville.table.label" /></th>
					<th><fmt:message key="listerClients.departement.table.label" /></th>
					<th><fmt:message key="listerClients.pays.table.label" /></th>
					<th><fmt:message key="listerClients.cp.table.label" /></th>
					<th><fmt:message key="listerClients.solvabilite.table.label" /></th>
					<th><fmt:message key="listerClients.commentaires.table.label" /></th>
					<th><fmt:message key="listerClients.action.table.label" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="client">
					<tr>
						<td>${client.nom}</td>
						<td>${client.telephone}</td>
						<td>${client.adresse}</td>
						<td>${client.ville}</td>
						<td>${client.departement}</td>
						<td>${client.pays}</td>
						<td>${client.cpPostal}</td>
						<td>${client.solvabilite}</td>
						<td>${client.commentaires}</td>
						<td>
							<ul>
								<li><a
									href="<c:url value='/commande/list.htm?id=${client.id}'/>"
									class="edit"><fmt:message key="voirCommandes.bouton.label" /></a></li>
								<li><a
									href="<c:url value='/client/edit.htm?id=${client.id}'/>"
									class="edit"><fmt:message key="edit.bouton.label" /></a></li>
								<li><a
									href="<c:url value='/client/delete.htm?id=${client.id}'/>"
									class="delete"><fmt:message key="delete.bouton.label" /></a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
	<br>

</body>
</html>