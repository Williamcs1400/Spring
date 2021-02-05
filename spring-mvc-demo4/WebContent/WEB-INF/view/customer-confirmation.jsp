<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>

The customer is corfirmed: ${customer.firstName} ${customer.lastName}.

<br><br>

Free passes: ${customer.freePasses }

<br><br>

Postal Code: ${customer.postalCode }

</body>

</html>