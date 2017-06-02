<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${context}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${context}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${context}/css/site.css" rel="stylesheet" type="text/css">
    <jsp:invoke fragment="styles"/>


</head>
<body>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Mesa VIP</a>
        </div>
        <security:authorize access="!isAuthenticated()">
            <th:form class="navbar-form navbar-right" action="login" method="POST" id="login-nav">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="email" id="username" name="username" class="form-control"
                           required placeholder="usuario"/>
                </div>

                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" id="password" name="password"
                           class="form-control" required placeholder="Contraseña"/>
                </div>

                <button type="submit" id="btnLogin" class="btn btn-primary">Login</button>
            </th:form>

        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><security:authentication property="principal.username"/> <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/logout">Cerrar Sesión</a></li>
                    </ul>
                </li>
            </ul>
        </security:authorize>
    </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <c:choose>
                <c:when test="${param.error != null}">
                    <div th:if="${param.error}" class="alert alert-danger text-center">
                        <p class="lead">
                            <i class="fa fa-exclamation"></i> Usuario o contraseña incorrectos.
                        </p>
                    </div>
                </c:when>
                <c:when test="${param.logout != null} ">
                    <div th:if="${param.logout}" class="alert alert-success text-center">
                        <p class="lead">
                            <i class="fa fa-check"></i> Cierre de sesión correcto.
                        </p>
                    </div>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>

<jsp:doBody/>


<%--<footer class="navbar navbar-default navbar-fixed-bottom">--%>
<%--<div class="container">--%>
<%--<p class="navbar-text pull-left">©  <fmt:formatDate value="${date}" pattern="yyyy" /> - MesaVIP--%>
<%--<a href="#" target="_blank" >Icono facebook</a>--%>
<%--</p>--%>

<%--<a href="#" class="navbar-btn btn-danger btn pull-right">--%>
<%--<span class="glyphicon glyphicon-star"></span>  Boton derecha</a>--%>
<%--</div>--%>


<%--</footer>--%>


<div class="modal fade" id="alertModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="alertModalHeader"></h4>
            </div>
            <div class="modal-body" id="alertModalContent">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn" data-dismiss="modal" id="btnAertModal"></button>
            </div>
        </div>

    </div>
</div>

<script src="${context}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${context}/js/site.js" type="text/javascript"></script>


<jsp:invoke fragment="scripts"/>
</body>
</html>