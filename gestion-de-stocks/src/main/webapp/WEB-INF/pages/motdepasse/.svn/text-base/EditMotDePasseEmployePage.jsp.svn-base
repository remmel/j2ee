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
		<h2>Modification du mot de passe</h2>

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

	<form:form method="POST" commandName="modificationMotDePasseFormBean">
		<div class="grid_7">
			<p>
				<label>Ancien mot de passe:</label>
				<form:password path="mpActuel" cssErrorClass="error" />
				<form:errors path="mpActuel" cssClass="errorField" />
			</p>

		</div>
		<div class="grid_2"></div>
		<div class="grid_7"></div>

		<div class="grid_16"></div>

		<div class="grid_7">
			<p>
				<label>Nouveau mot de passe:</label>
				<form:password path="mpNouveau" cssErrorClass="error" />
				<form:errors path="mpNouveau" cssClass="errorField" />
			</p>
		</div>
		<div class="grid_2"></div>
		<div class="grid_7"></div>

		<div class="grid_16"></div>

		<div class="grid_7">
			<p>
				<label>Confirmation du nouveau mot de passe:</label>
				<form:password path="mpConfirmationNouveau" cssErrorClass="error" />
				<form:errors path="mpConfirmationNouveau" cssClass="errorField" />
			</p>
		</div>
		<div class="grid_2"></div>
		<div class="grid_7"></div>

		<div class="grid_16"></div>

		<div class="grid_16">
			<p class="submit">
				<input type="button" value="Retour"
					onClick="javascript:document.location.href='<c:url value="/accueil/accueil.htm"/>'" />
				<input type="submit" value="Sauvegarder" />
			</p>
		</div>
	</form:form>
</body>
</html>