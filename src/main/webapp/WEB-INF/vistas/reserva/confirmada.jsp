<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<t:layout>
    <jsp:body>
        <div class="container">
            <div class="panel panel-success">
                <div class="panel-heading text-center">
                    <h1> Tu reserva con el identificador ${reserva.id} fue confirmada!!!</h1>
                </div>
                <div class="panel-body text-center">
                    Tu mesa es la N° ${reserva.mesa.numero}
                    <a href="${context}/" class="btn btn-success">Aceptar</a>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>