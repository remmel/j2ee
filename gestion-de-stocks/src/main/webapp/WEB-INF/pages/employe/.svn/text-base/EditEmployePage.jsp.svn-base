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
					<fmt:message key="editerEmploye.titre.label" />
				</c:when>

				<c:otherwise>
					<fmt:message key="editerEmploye.creation.titre.label" />
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

	<form:form method="POST" commandName="employeInfoData">
		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="titre"><fmt:message
						key="editerEmploye.titre.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:select path="titre" cssErrorClass="error">
					<form:option value="" label="-" />
					<form:options items="${listTitres}" />
				</form:select>
				<form:errors path="titre" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="nom"><fmt:message
						key="editerEmploye.nom.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="nom" cssErrorClass="error" size="16" />
				<form:errors path="nom" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="prenom"><fmt:message
						key="editerEmploye.prenom.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="prenom" cssErrorClass="error" />
				<form:errors path="prenom" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="utilisateur"><fmt:message
						key="editerEmploye.utilisateur.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<c:choose>
					<c:when test="${param.id > 0}">
						<form:input path="utilisateur" cssErrorClass="error"
							readonly="true" />
					</c:when>

					<c:otherwise>
						<form:input path="utilisateur" cssErrorClass="error" />
					</c:otherwise>
				</c:choose>

				<form:errors path="utilisateur" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="service"><fmt:message
						key="editerEmploye.service.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:select path="service" cssErrorClass="error">
					<form:option value="" label="-" />
					<form:options items="${listServices}" />
				</form:select>
				<form:errors path="service" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<c:if test="${param.id <= 0}">

			<div class="field">
				<div class="prefix_3 grid_3">
					<label for="motDePasse"><fmt:message
							key="editerEmploye.motDePasse.field.label" /></label>
				</div>
				<div class="grid_7 suffix_3">
					<form:password path="motDePasse" cssErrorClass="error" />
					<form:errors path="motDePasse" cssClass="errorField" />
				</div>
			</div>

			<div class="clear">&nbsp;</div>

			<div class="field">
				<div class="prefix_3 grid_3">
					<label for="confirmationMotDePasse"><fmt:message
							key="editerEmploye.confirmationMotDePasse.field.label" /></label>
				</div>
				<div class="grid_7 suffix_3">
					<form:password path="confirmationMotDePasse" cssErrorClass="error" />
					<form:errors path="confirmationMotDePasse" cssClass="errorField" />
				</div>
			</div>

			<div class="clear">&nbsp;</div>

		</c:if>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="commentaires"><fmt:message
						key="editerEmploye.commentaires.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:textarea path="commentaires" rows="8" cssErrorClass="error" />
				<form:errors path="commentaires" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="salaire"><fmt:message
						key="editerEmploye.salaire.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:input path="salaire" cssErrorClass="error" />
				<form:errors path="salaire" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="field">
			<div class="prefix_3 grid_3">
				<label for="authorities"><fmt:message
						key="editerEmploye.authorities.field.label" /></label>
			</div>
			<div class="grid_7 suffix_3">
				<form:select path="authorities" items="${listAuthorities}"
					cssErrorClass="error" />
				<form:errors path="authorities" cssClass="errorField" />
			</div>
		</div>

		<div class="clear">&nbsp;</div>

		<div class="grid_16">
			<p class="submit">
				<input type="button"
					value="<fmt:message
						key="retour.bouton.label" />"
					onClick="javascript:document.location.href='<c:url value="/employe/list.htm"/>'" />
				<input type="submit"
					value="<fmt:message
						key="sauver.bouton.label" />" />
			</p>
		</div>
	</form:form>
</body>
</html>