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
<script type="text/javascript"
	src="<c:url value="/resources/js/commande/editerCommande.js"/>"></script>

<script>
	var urlGetPrixByIdProduit = "<c:url value="/commande/getPrix.htm"/>";
</script>

</head>
<body>
	<div class="grid_16">
		<h2>
			<c:choose>
				<c:when test="${param.id > 0}">
					<fmt:message key="editerCommande.titre.label" />
				</c:when>

				<c:otherwise>
					<fmt:message key="editerCommande.creation.titre.label" />
				</c:otherwise>
			</c:choose>
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

	<form:form method="POST" commandName="commande">
		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=dateCommande><fmt:message
						key="editerCommande.dateCommande.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="dateCommande" cssErrorClass="error" size="16"
					readonly="true" />
				<form:errors path="dateCommande" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=dateLivraison><fmt:message
						key="editerCommande.dateLivraison.field.label" /></label>

			</div>
			<div class="grid_7 suffix_3">
				<form:input path="dateLivraison" cssErrorClass="error" size="16" />
				<form:errors path="dateLivraison" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=dateLivraison><fmt:message
						key="editerCommande.ntPaiement.field.label" /></label>

			</div>
			<div class="grid_7 suffix_3">
				<form:input path="ntPaiement" cssErrorClass="error" size="16" />
				<form:errors path="ntPaiement" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=validite><fmt:message
						key="editerCommande.validite.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:checkbox path="validite" cssErrorClass="error" />
				<form:errors path="validite" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="grid_16">
			<input type="submit"
				value="<fmt:message
						key="sauver.bouton.label" />" />
		</div>

		<div class="clear">&nbsp;</div>

	</form:form>

	<br />
	<br />

	<form:form action="addLigne.htm?id=${param.id}&idClient=${idClient}"
		method="POST" commandName="ligne">

		<div class="multifield">
			<div class="grid_4">
				<label for="produit"><fmt:message
						key="editerCommande.produit.field.label" /></label>
			</div>
			<div class="grid_2">
				<label for="quantite"><fmt:message
						key="editerCommande.quantite.field.label" /></label>
			</div>
			<div class="grid_3">
				<label for="prixUnitaire"><fmt:message
						key="editerCommande.prixUnitaire.field.label" /></label>
			</div>
			<div class="grid_3 suffix_4">
				<label for="prix"><fmt:message
						key="editerCommande.prix.field.label" /></label>
			</div>

			<div class="clear">&nbsp;</div>

			<div class="grid_4">
				<form:select path="idProduit" onchange="getQteByIdProduit();">
					<form:option value="" label="-" />
					<form:options items="${listProduits}" />
				</form:select>
				<form:errors path="idProduit" cssClass="errorField" />
			</div>

			<div class="grid_2">
				<form:input path="quantite" cssErrorClass="error" size="4"
					onkeyup="modifierPrixTotal();" />
				<form:errors path="quantite" cssClass="errorField" />
			</div>

			<div class="grid_3">
				<input type="text" id="prixUnitaire" size="8" readonly="true"
					value="-" />
			</div>


			<div class="grid_3">
				<form:input path="prix" cssErrorClass="error" size="8"
					readonly="true" />
				<form:errors path="prix" cssClass="errorField" />
			</div>


			<div class="grid_4">
				<input type="submit" value="Ajouter une ligne" />


			</div>

			<div class="clear">&nbsp;</div>
		</div>


	</form:form>

	<br />

	<div class="clear">&nbsp;</div>

	<div class="grid_16">
		<table>
			<thead>
				<tr>
					<th><fmt:message key="editerCommande.produit.table.label" /></th>
					<th><fmt:message key="editerCommande.quantite.table.label" /></th>
					<th><fmt:message key="editerCommande.prix.table.label" /></th>
					<th><fmt:message key="editerCommande.qteLivree.table.label" /></th>
					<th><fmt:message key="editerCommande.action.table.label" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lignes}" var="ligne">
					<tr>
						<td>${ligne.produit.nom}</td>
						<td>${ligne.quantite}</td>
						<td>${ligne.prix}</td>
						<td>${ligne.qteLivree}</td>
						<td><a
							href="<c:url value='/ligne/delete.htm?idLigne=${ligne.id}'/>"
							class="delete"><fmt:message key="delete.bouton.label" /></a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>

	<div class="field">
		<div class="prefix_3 grid_3">
			<label for="total"><fmt:message
					key="editerCommande.total.field.label" /></label>
		</div>
		<div class="grid_2 suffix_8">
			<input type="text" value="${commande.total}" readonly="readonly">
		</div>
	</div>

	<br>
	<div class="grid_16">
		<p class="submit">
			<input type="button"
				value="<fmt:message
						key="retour.bouton.label" />"
				onClick="javascript:document.location.href='<c:url value="/commande/list.htm"/>'" />
		</p>
	</div>

</body>
</html>