<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="/css/site.css" rel="stylesheet" type="text/css">
    <jsp:invoke fragment="styles" />
</head>
<body>
<jsp:include page="../vistas/common/navigation.jsp"></jsp:include>


<jsp:doBody/>


<jsp:include page="../vistas/common/footer.jsp"></jsp:include>

<script src="/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"></script>

<jsp:invoke fragment="scripts" />
</body>
</html>