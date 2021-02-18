<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="post">
	
		<input type="submit" value="Logout"/>
		
	</form:form>
	
</body>

</html>