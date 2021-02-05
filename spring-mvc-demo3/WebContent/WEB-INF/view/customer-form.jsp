<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Custumer Registration Form</title>
	
	<style>
		.error{color:red}
	</style>
</head>

<body>

Fill out the form:
<br><br>

	<form:form action="processForm" modelAttribute="customer">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
	
	Last name(*): <form:input path="lastName"/>
	<form:errors path="lastName"  cssClass="error"/>
	
	<br><br>
	
	<input type="submit" value="Submit"/>
	
	</form:form>

</body>

</html>