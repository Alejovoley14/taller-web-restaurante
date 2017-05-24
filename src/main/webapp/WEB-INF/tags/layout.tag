<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="../vistas/common/navigation.jsp"></jsp:include>
<%--<c:when test="${userAuthenticated}">--%>
    <%--<jsp:include page="../vistas/common/authenticatedNav.jsp"></jsp:include>--%>

<%--</c:when>--%>
<%--<c:when test="${!userAuthenticated}">--%>
    <%--<jsp:include page="../vistas/common/unauthenticatedNav.jsp"></jsp:include>--%>
<%--</c:when>--%>
<div id="body">
    <jsp:doBody/>
</div>


<jsp:include page="../vistas/common/footer.jsp"></jsp:include>

<script src="/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/js/jquery-1.11.3.min.js" type="text/javascript"></script>
</body>
</html>