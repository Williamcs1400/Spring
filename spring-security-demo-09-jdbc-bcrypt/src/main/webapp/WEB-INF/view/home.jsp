<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Will Company</title>
</head>

<body>

	<h2>Will Company Home Page</h2>
	
	<hr>
	
	<p>
	Welcome to Will Company
	</p>
	
	<hr>
	
	<p>
		User: <sec:authentication property="principal.username" />
		<br><br>
		Role(s): <sec:authentication property="principal.authorities" />
	</p>
	
	
	<sec:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for Manager peeps)
	
	<hr>
	
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/systems">It systems Meeting</a>
		(Only for Admin peeps)
	
	<hr>
	
	</sec:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="post">
	
		<input type="submit" value="Logout"/>
		
	</form:form>
	
</body>

</html>