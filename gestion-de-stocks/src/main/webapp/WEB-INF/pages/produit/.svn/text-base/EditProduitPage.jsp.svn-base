<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="grid_16">
		<h2>
			<c:choose>
				<c:when test="${param.id > 0}">
					<fmt:message key="editerProduit.titre.label" />
				</c:when>

				<c:otherwise>
					<fmt:message key="editerProduit.creation.titre.label" />
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
	<form:form method="POST" commandName="produitForm">


		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=nom><fmt:message
						key="editerProduit.nom.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="nom" cssErrorClass="error" size="16" />
				<form:errors path="nom" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=description><fmt:message
						key="editerProduit.description.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="description" cssErrorClass="error" size="16" />
				<form:errors path="description" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for=prixConseille><fmt:message
						key="editerProduit.prixConseille.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="prixConseille" cssErrorClass="error" size="16" />
				<form:errors path="prixConseille" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="grid_16">
			<p class="submit">
				<input type="button"
					value="<fmt:message
						key="retour.bouton.label" />"
					onClick="javascript:document.location.href='<c:url value="/produit/list.htm"/>'" />
				<input type="submit"
					value="<fmt:message
						key="sauver.bouton.label" />" />
			</p>
		</div>

	</form:form>
</body>
</html>