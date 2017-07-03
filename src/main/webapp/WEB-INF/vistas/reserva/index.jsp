<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<t:layout>
    <jsp:attribute name="scripts">
        <jsp:include page="scripts.jsp"></jsp:include>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="page-header">
                <div class="panel panel-info">
                    <div class="panel-heading">
                            ${restaurant.nombreFantasia}
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>Domicilio :
                                <strong>${restaurant.domicilio.calle} ${restaurant.domicilio.numero} ${restaurant.domicilio.localidadDescripcion}, ${restaurant.domicilio.departamentoDescripcion},${restaurant.domicilio.provinciaDescripcion}</strong>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <th:form cssClass="form-horizontal" action="${context}/reserva/confirmar" method="post">
                <div class="row">
                    <div class="form-group">
                        <label for="txtComensales" class="col-md-2">Cantidad de comensales</label>
                        <div class="col-md-3"><input type="number" id="txtComensales" name="cantidadComensales" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2">Fecha</label>
                        <div class='input-group date col-md-4' id='fechaPicker'>
                            <input type='text' class="form-control" name="fecha" id="fecha"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <div class="form-group" id="divMesas">
                        <label class="col-md-2">Mesa</label>
                        <div class="col-md-8">
                            <select class="form-control" name="mesaId" id="selectMesa">
                            </select>
                        </div>
                    </div>
                    <div class="alert alert-info" id="divMesaNoDisponible">
                        <h4>No hay mesas disponibles</h4>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2">Medio de pago</label>
                        <div class="col-md-8">
                            <select class="form-control" name="medioPagoId">
                                <c:forEach var="item" items="${restaurant.mediosPago}">
                                    <option value="${item.id}">${item.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2">Plato/Bebida</label>
                        <div class="col-md-8">
                            <select class="form-control" id="optPlatos">
                                <c:forEach var="item" items="${restaurant.carta}">
                                    <option value="${item.id}" precio="${item.precio}">${item.titulo}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-success" id="btnAddPlato"><i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <div id="selectedPlatos"></div>
                </div>
                <div class="row">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </th:form>

            <div class="row">
                <table class="table table-striped" id="tablePlatos">
                    <tr>
                        <th>Plato</th>
                        <th>Valor</th>
                        <th></th>
                    </tr>
                </table>
            </div>
            <p>
                Total: <strong id="totalPrecio"></strong>
            </p>
        </div>


    </jsp:body>
</t:layout>