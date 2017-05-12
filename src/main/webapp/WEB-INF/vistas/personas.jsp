<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>personas</title>
</head>
<body>
	<h1>Personas</h1>
	<ol>
		<c:forEach items="${listaFiltrada}" var="persona">
			<li>${persona.getNombre()}</li>
		</c:forEach>
	</ol>

</body>
</html>