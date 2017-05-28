<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
                <ul class="nav navbar-nav navbar-right">
                    <li><p class="navbar-text">Ya tiene cuenta?</p></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Iniciar Sesión</b> <span
                                class="caret"></span></a>
                        <ul id="login-dp" class="dropdown-menu">
                            <li>
                                <div class="row">
                                    <div class="col-md-12">
                                        Iniciar sesión con
                                        <div class="social-buttons">
                                            <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                            <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                        </div>
                                        o
                                        <th:form class="form-horizontal" action="login" method="POST" id="login-nav">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            <div class="form-group">
                                                <label class="sr-only" for="username">Username</label>
                                                <input type="email" id="username" name="username" class="form-control"
                                                       required placeholder="usuario"/>
                                            </div>
                                            <div class="form-group">
                                                <label class="sr-only" for="password">Password</label>
                                                <input type="password" id="password" name="password"
                                                       class="form-control" required placeholder="Contraseña"/>
                                                <div class="help-block text-right"><a href="">Olvido su contraseña?</a>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión
                                                </button>
                                            </div>
                                            <c:choose>
                                                <c:when test="${param.error != null}">
                                                    <div th:if="${param.error}" class="alert alert-danger">
                                                        Usuario o contraseña incorrectos.
                                                    </div>
                                                </c:when>
                                                <c:when test="${param.logout != null} ">
                                                    <div th:if="${param.logout}" class="alert alert-success">
                                                        Cierre de sesión correcto.
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                        </th:form>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><security:authentication property="principal.username" /> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/logout">Cerrar Sesión</a></li>
                    </ul>
                </li>
            </ul>
        </security:authorize>
    </div>
    </div>
</nav>