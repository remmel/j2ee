<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<security:authorize access="isAuthenticated()">

		<ul id="navigation">
			<li><a href="<c:url value="/accueil/accueil.htm"/>"><fmt:message
						key="menu.acceuil.label" /></a></li>
			<security:authorize ifAnyGranted="ROLE_ADMIN">
				<li><a href="<c:url value="/employe/list.htm"/>"><fmt:message
							key="menu.gestionEmployes.label" /></a></li>
			</security:authorize>
			<security:authorize ifAnyGranted="ROLE_USER">
				<li><a href="<c:url value="/client/list.htm"/>"><fmt:message
							key="menu.gestionClients.label" /></a></li>
				<li><a href="<c:url value="/produit/list.htm"/>"><fmt:message
							key="menu.gestionProduits.label" /></a></li>

			</security:authorize>

		</ul>
	</security:authorize>
</body>
</html>