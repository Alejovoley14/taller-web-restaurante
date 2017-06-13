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
            <div class="page-header">
                <div class="row">
                    <h1>Restaurant: ${restaurant.nombreFantasia}</h1>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="btn-group">
                        <a href="/restaurant" class="btn btn-primary"><i class="fa fa-backward"></i> </a>
                            <a class="btn btn-success" type="submit" href="/carta/create/${ restaurant.id}">Agregar <i class="fa fa-plus"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Plato</th>
                        <th>Descripcion</th>
                        <th>Tipo</th>
                        <th>Precio</th>
                        <th></th>
                    </tr>
                    </thead>

                    <c:forEach var="carta" items="${cartas}">
                        <tr>
                            <td>${carta.id}</td>
                            <td>${carta.titulo}</td>
                            <td>${carta.descripcion}</td>
                            <td>${carta.tipoProducto.descripcion}</td>
                            <td>${carta.precio}</td>
                            <td>
                                <a class="btn btn-info" href="/carta/edit/${carta.id}">Editar <i class="fa fa-edit"></i>
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