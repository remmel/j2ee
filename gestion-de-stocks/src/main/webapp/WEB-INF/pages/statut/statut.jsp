<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<security:authorize access="isAuthenticated()">
		<div class="grid_16">

			<div class="box">
				<p>
					Vous êtes connecté en tant que :
					<security:authentication property="principal.username" />
				</p>
				<p>
					<a href="<c:url value='/motdepasse/edit.htm'/>">Modifier le mot
						de passe</a> 
					<a href="<c:url value="/j_spring_security_logout"/>">se
						déconnecter</a>
				</p>
			</div>

		</div>
	</security:authorize>
</body>
</html>


