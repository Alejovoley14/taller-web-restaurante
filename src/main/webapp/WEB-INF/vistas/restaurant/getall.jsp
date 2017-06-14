<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<t:layout>
    <jsp:body>
        <div class="container">
            <div class="page-header">
                <div class="row">
                    <h1>Restaurants</h1>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="btn-group">
                            <a href="${context}/" class="btn btn-primary"><i class="fa fa-backward"></i> </a>
                            <a class="btn btn-success" type="submit" href="${context}/restaurant/create">Agregar <i class="fa fa-plus"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre Fantasia</th>
                        <th>Razon Social</th>
                        <th>Cuit</th>
                        <th></th>
                    </tr>
                    </thead>

                    <c:forEach var="restaurant" items="${lista}">
                        <tr>
                            <td>${restaurant.id}</td>
                            <td>${restaurant.nombreFantasia}</td>
                            <td>${restaurant.razonSocial}</td>
                            <td>${restaurant.cuit}</td>
                            <td>
                                <div class="btn-group">
                                    <a class="btn btn-primary" href="${context}/mesas/${restaurant.id}">Mesas <i class="fa fa-cutlery" aria-hidden="true"></i></i></a>
                                    <a class="btn btn-warning" href="${context}/carta/${restaurant.id}">Carta <i class="fa fa-glass" aria-hidden="true"></i></a>
                                    <a class="btn btn-info" href="${context}/restaurant/edit/${restaurant.id}">Editar <i class="fa fa-edit"></i></a>
                                    <a class="btn btn-danger">Elimiar <i class="fa fa-minus"></i>
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </jsp:body>
</t:layout>