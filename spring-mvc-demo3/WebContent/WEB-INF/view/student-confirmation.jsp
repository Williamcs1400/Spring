<!DOCTYPE html>
<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is corfirmed: ${student.firstName} ${student.lastName} from ${student.country } that has the favorite language: ${student.favoriteLanguage}
Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	
	<li> ${temp} </li>
	</c:forEach>
</ul>

</body>

</html>