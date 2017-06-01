<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:layout>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                <h1>Bienvenido a MESA VIP
                    <small>tu sitio de reservas on-line</small>
                </h1>

                <c:if test="${!existeCliente}">

                    <div class="bs-callout bs-callout-info">
                        <h4>Bienvenido! <security:authentication property="principal.username"/></h4>
                        <p class="lead">
                            <i class="fa fa-info-circle"></i> Para poder hacer reservas tenés que completar tus
                            datos de cliente.
                        </p>
                        <a href="/cliente" class="btn btn-info">Completar ahora!</a>
                    </div>
                </c:if>
                </div>
            </div>
        </div>
    </jsp:body>

</t:layout>
