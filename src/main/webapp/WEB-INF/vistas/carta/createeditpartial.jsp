<%--
  Created by IntelliJ IDEA.
  User: spardo
  Date: 14/6/2017
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<th:input path="restaurantId" type="hidden" id="lat"></th:input>
<div class="page-header">
    <div class="row">
        <h1>Restaurant: ${restaurant.nombreFantasia}</h1>
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <label for="tipoProductoId" class="col-sm-2 col-md-3 control-label">Tipo</label>
            <div class="col-sm-10 col-md-9">
                <th:select path="tipoProductoId" items="${tiposProducto}" itemLabel="descripcion" itemValue="id"
                           id="tipoProductoId" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="titulo" class="col-sm-2 col-md-3 control-label">Nombre del plato</label>
            <div class="col-sm-10 col-md-9">
                <th:input path="titulo" cssClass="form-control" type="text" id="titulo"></th:input>

            </div>
        </div>
        <div class="form-group">
            <label for="precio" class="col-sm-2 col-md-3 control-label">Precio</label>
            <div class="col-sm-10 col-md-9">
                <th:input path="precio" cssClass="form-control" type="number" id="precio"></th:input>
            </div>
        </div>
        <div class="form-group">
            <label for="descripcion" class="col-sm-2 col-md-3 control-label">Descripción</label>
            <div class="col-sm-10 col-md-9">
                <th:textarea path="descripcion" cssClass="form-control" id="descripcion"  rows="5" cols="6"></th:textarea>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-sm-offset-9 col-sm-3">
        <button class="btn btn-primary" type="submit">Guardar</button>
    </div>
</div>


