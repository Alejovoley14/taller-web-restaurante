<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 13/05/2017
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:when test="${userAuthenticated}">
<jsp:include page="common/authenticatedNav.jsp"></jsp:include>

</c:when>
<c:when test="${!userAuthenticated}">
    <jsp:include page="common/unauthenticatedNav.jsp"></jsp:include>
</c:when>

<jsp:body></jsp:body>

<jsp:include page="common/footer.jsp"></jsp:include>

<script src="/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/js/jquery-1.11.3.min.js" type="text/javascript"></script>
</body>
</html>
