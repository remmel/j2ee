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
		<fmt:message key="listerProduits.titre.label" />
	</h2>
	<div class="grid_16">
		<p>
			<input type="button" value="Ajouter un produit"
				onClick="javascript:document.location.href='<c:url value="/produit/edit.htm?id=0"/>'" />
		</p>
	</div>

	<div class="clear">&nbsp;</div>

	<br />

	<div class="grid_16">

		<table>
			<thead>
				<tr>
					<th><fmt:message key="listerProduits.nom.table.label" /></th>
					<th><fmt:message key="listerProduits.description.table.label" /></th>
					<th><fmt:message
							key="listerProduits.prixConseille.table.label" /></th>
					<th><fmt:message key="listerProduits.action.table.label" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produits}" var="produit">
					<tr>
						<td>${produit.nom}</td>
						<td>${produit.description}</td>
						<td>${produit.prixConseille}</td>
						<td>
							<ul>
								<li><a
									href="<c:url value='/produit/edit.htm?id=${produit.id}'/>"
									class="edit"><fmt:message key="edit.bouton.label" /></a></li>
								<li><a
									href="<c:url value='/produit/delete.htm?id=${produit.id}'/>"
									class="delete"><fmt:message key="delete.bouton.label" /></a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>