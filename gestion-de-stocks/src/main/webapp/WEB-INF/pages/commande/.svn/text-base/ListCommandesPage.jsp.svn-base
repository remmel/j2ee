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
		<fmt:message key="listerCommandes.titre.label" />
	</h2>
	<div class="grid_16">
		<p>
			<input type="button" value="Ajouter une commande"
				onClick="javascript:document.location.href='<c:url value="/commande/edit.htm?id=0&idClient=${param.id}"/>'" />
		</p>
	</div>

	<div class="clear">&nbsp;</div>

	<div class="grid_16">
		<table>
			<thead>
				<tr>
					<th><fmt:message key="listerCommandes.dtCommande.table.label" /></th>
					<th><fmt:message key="listerCommandes.dtLivraison.table.label" /></th>
					<th><fmt:message key="listerCommandes.total.table.label" /></th>
					<th><fmt:message key="listerCommandes.ntPaiement.table.label" /></th>
					<th><fmt:message key="listerCommandes.validite.table.label" /></th>
					<th><fmt:message key="listerCommandes.action.table.label" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${commandes}" var="commande">
					<tr>
						<td>${commande.dateCommande}</td>
						<td>${commande.dateLivraison}</td>
						<td>${commande.total}</td>
						<td>${commande.ntPaiement}</td>
						<td>${commande.validite}</td>
						<td>
							<ul>
								<li><a
									href="<c:url value='/commande/edit.htm?id=${commande.id}&idClient=0'/>"
									class="edit"><fmt:message key="edit.bouton.label" /></a></li>
								<li><a
									href="<c:url value='/commande/delete.htm?id=${commande.id}&idClient=${param.id}'/>"
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