<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="grid_16">
		<h2>Authentification</h2>

		<security:authorize access="isAuthenticated()">
			<div id="loginstatus">
				Vous êtes connecté en tant que : 
				<security:authentication property="principal.username" />
				<a href="<c:url value="/j_spring_security_logout"/>">déconnection</a>
			</div>
		</security:authorize>
		<c:if test="${not empty login_error}">
						<p class="error">Le nom d'utilisateur et le mot de passe
							ne sont pas valides.</p>
							
					</c:if>
		<security:authorize access="not isAuthenticated()">
			<form name='f' action="<c:url value='j_spring_security_check' />"
				method='POST'>
				<fieldset>
					

					<div class="grid_16">
						<p>
							<label>User: </label> <input type='text' name='j_username'
								value=''>
						</p>
					</div>
					
					<div class="grid_16">
						<p>
							<label>Password: </label> <input type='password'
								name='j_password' />
						</p>
					</div>
					
					<div class="grid_16">
						<p class="submit">
							<input name="submit" type="submit" value="submit" /> <input
								name="reset" type="reset" />
						</p>
					</div>
				</fieldset>
			</form>
		</security:authorize>
	</div>
</body>
</html>