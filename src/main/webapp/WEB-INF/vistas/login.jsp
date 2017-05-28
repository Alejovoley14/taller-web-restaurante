<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:layout>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">Registrarse</div>
                        <div class="panel-body">


                            <th:form class="form-horizontal" action="CrearUsuario" method="POST" modelAttribute="usuario">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                <div class="form-group">
                                    <label for="email" class="col-md-4 control-label">Usuario</label>
                                    <div class="col-md-6">
                                        <%--<form:input path="email" id="email" type="email" class="form-control" />--%>

                                        <input id="email" type="email" class="form-control" name="email" value=""
                                               required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Contraseña</label>
                                    <div class="col-md-6">
                                        <%--<form:input path="password" type="password" id="password" class="form-control" />--%>
                                        <input id="password" type="password" class="form-control" name="password"
                                               >
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password-confirm" class="col-md-4 control-label">Confirmar Contraseña</label>
                                    <div class="col-md-6">
                                        <input id="password-confirm" type="password" class="form-control"
                                               name="password_confirmation" required>
                                    </div>
                                </div>

                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger">
                                        <h4><span>${error}</span></h4>
                                    </div>
                                </c:if>
                                <c:if test="${not empty success}">
                                    <div class="alert alert-success">
                                        <h4><span>${success}</span></h4>
                                    </div>
                                </c:if>

                                <div class="form-group">
                                    <div class="col-md-6 col-md-offset-4">
                                        <button type="submit" class="btn btn-info">
                                            Registrarse
                                        </button>
                                    </div>
                                </div>
                            </th:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>