<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>

<t:layout>

    <jsp:attribute name="styles">
        <style type="text/css">
            /*SI FUERA NECESARIO AGREGAR JQUERY O ESTILOS ESTA ES LA MANERA USANDO LOS ATTRIBUTOS DEL LAYOUT*/
        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <script type="text/javascript">
            //SI FUERA NECESARIO AGREGAR JQUERY O ESTILOS ESTA ES LA MANERA USANDO LOS ATTRIBUTOS DEL LAYOUT
        </script>
    </jsp:attribute>

    <jsp:body>
        <div id="fb-root"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">Registrarse</div>
                        <div class="panel-body">
                            <th:form class="form-horizontal" action="CrearUsuario" method="POST"
                                     modelAttribute="usuario">
                                <div class="form-group">
                                    <label for="email" class="col-md-4 control-label">Usuario</label>
                                    <div class="col-md-6">
                                        <c:choose>
                                            <c:when test="${usuario == null}">
                                                <input id="email" type="email" class="form-control" name="email"
                                                       value="" required>
                                            </c:when>
                                            <c:when test="${usuario != null}">
                                                <th:input path="email" cssClass="form-control"></th:input>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Contraseña</label>
                                    <div class="col-md-6">
                                        <input id="password" type="password" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="verifyPassword" class="col-md-4 control-label">Confirmar
                                        Contraseña</label>
                                    <div class="col-md-6">
                                        <input id="verifyPassword" type="password" class="form-control"
                                               name="verifyPassword" required>
                                    </div>
                                </div>
                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger">
                                        <h4><span class="glyphicon glyphicon-exclamation-sign"></span> ${error}</h4>
                                    </div>
                                </c:if>
                                <c:if test="${not empty success}">
                                    <div class="alert alert-success">
                                        <h4><span class="glyphicon glyphicon-exclamation-sign"></span> ${success}</h4>
                                    </div>
                                </c:if>
                                <div class="row">

                                    <div class="col-md-6 col-md-offset-4">
                                        <button type="submit" class="btn btn-info">
                                            Registrarse
                                        </button>
                                    </div>
                                </div>
                                <hr>


                            </th:form>
                            <div class="row">
                                <p class="lead">
                                    Tambien podes usar tu red social favorita
                                </p>
                            </div>
                            <div class="row">

                                <div class="col-md-2">
                                    <!-- Add Facebook sign in button -->
                                    <a href="${pageContext.request.contextPath}/auth/facebook?scope=email">
                                        <button class="btn btn-primary"><i class="fa fa-facebook"></i> |
                                            Facebook
                                        </button>
                                    </a>
                                </div>
                                <div class="col-md-2">
                                    <a href="${pageContext.request.contextPath}/auth/twitter?socpe=email">
                                        <button class="btn btn-info"><i class="fa fa-twitter"></i> |
                                            Tiwtter
                                        </button>
                                    </a>
                                </div>
                                <div class="col-md-2">
                                    <%--<form action="${pageContext.request.contextPath}/signin/google" method="POST">--%>
                                        <%--<button class="btn btn-danger" type="submit"><i class="fa fa-google"></i> |--%>
                                            <%--Google--%>
                                        <%--</button>--%>
                                    <%--</form>--%>
                                    <a href="${pageContext.request.contextPath}/auth/google?scope=email">
                                        <button class="btn btn-danger"><i class="fa fa-google"></i> |
                                            Google
                                        </button>
                                    </a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</t:layout>