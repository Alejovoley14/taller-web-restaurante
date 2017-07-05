<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<th:input path="domicilio.Latitud" type="hidden" id="lat"></th:input>
<th:input path="domicilio.Longitud" type="hidden" id="long"></th:input>

<hr>
<div class="row">
    <div class="col-sm-12 col-md-5">
        <h3>Datos Personales</h3>
        <div class="row">
            <div class="form-group">
                <label for="razonSocial" class="col-sm-2 col-md-3 control-label">Razon Social</label>
                <div class="col-sm-10 col-md-9">
                    <th:input path="razonSocial" cssClass="form-control" type="text" id="razonSocial"></th:input>

                </div>
            </div>
            <div class="form-group">
                <label for="nombreFantasia" class="col-sm-2 col-md-3 control-label">Nombre Fantasia</label>
                <div class="col-sm-10 col-md-9">
                    <th:input path="nombreFantasia" cssClass="form-control" type="text" id="nombreFantasia"></th:input>

                </div>
            </div>
            <div class="form-group">
                <label for="cuit" class="col-sm-2 col-md-3 control-label">Cuit</label>
                <div class="col-sm-10 col-md-9">
                    <th:input path="cuit" cssClass="form-control" type="text" id="cuit"></th:input>

                </div>
            </div>


            <div class="form-group">
                <label for="cuit" class="col-sm-2 col-md-3 control-label">Medios de Pago</label>
                <div class="col-sm-8 col-md-7">
                    <select class="form-control" id="optMedioPago">
                        <option>Seleccione los medios de pago...</option>
                        <c:forEach items="${medioPagos}" var="item">
                            <option value="${item.id}">${item.descripcion}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-sm-2 col-md-2">
                    <button type="button" class="btn btn-success" id="btnAddMedioPago"><i class="fa fa-plus"></i>
                    </button>
                </div>

            </div>
            <div class="col-sm-12">
                <table class="table" id="tableMediosPago">
                    <tr>
                        <th>Medio de pago</th>
                        <th></th>
                    </tr>
                </table>
                <div id="selectedMediosPago"></div>
            </div>


        </div>
    </div>
    <div class="col-sm-12 col-md-offset-1 col-md-5">
        <h3>Domicilio</h3>
        <div class="row">
            <div class="form-group">
                <label for="provinciaId" class="col-sm-2 col-md-3 control-label">Provincia</label>
                <div class="col-sm-10 col-md-9">
                    <select id="provinciaId" name="domicilio.provinciaId" class="form-control">
                        <option>Seleccione una provincia...</option>
                        <c:forEach items="${provincias}" var="item">
                            <option value="${item.id}">${item.descripcion}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="departamentoId" class="col-sm-2 col-md-3 control-label">Departamento</label>
                <div class="col-sm-10 col-md-9">
                    <select id="departamentoId" name="domicilio.departamentoId" class="form-control">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="localidadId" class="col-sm-2 col-md-3 control-label">Localidad</label>
                <div class="col-sm-10 col-md-9">
                    <select id="localidadId" name="domicilio.localidadId" class="form-control">
                    </select>
                </div>
            </div>
            <div class="row input-group">

                <label for="calle" class="col-sm-2 col-md-2 control-label">Calle</label>
                <div class="col-sm-10 col-md-5">
                    <th:input path="domicilio.calle" cssClass="form-control" type="text" id="calle"></th:input>

                </div>
                <label for="numero" class="col-sm-2 col-md-2 control-label">Nro</label>
                <div class="col-sm-9 col-md-2">
                    <th:input path="domicilio.numero" cssClass="form-control" type="text" id="numero"></th:input>

                </div>

                <div class="col-sm-1">
                    <button type="button" id="btnSetMarker" class="btn btn-info"><span
                            class="glyphicon glyphicon-map-marker"></span></button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="panel">
                    <div class="panel-body">
                        <div id="map" class="embed-responsive-16by9"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<div class="row">
    <c:if test="${errors!= null}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li><strong>${error.defaultMessage}</strong></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</div>
<div class="row">

    <div class="col-sm-offset-9 col-sm-3">
        <button class="btn btn-primary" type="submit">Guardar</button>
    </div>
</div>

