<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:layout>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-sm-offset-1">
                    <a class="btn btn-success" type="submit" href="/restaurant/create">Agregar <i class="fa fa-plus"></i></a>
                </div>
            </div>
            <hr>
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
                                <a class="btn btn-info" href="/restaurant/edit/${restaurant.id}">Editar <i class="fa fa-edit"></i>
                                </a>
                                <a class="btn btn-danger">Elimiar <i class="fa fa-minus"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </jsp:body>
</t:layout>