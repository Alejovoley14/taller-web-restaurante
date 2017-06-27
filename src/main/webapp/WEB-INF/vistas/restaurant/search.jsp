<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>

<t:layout>
     <jsp:attribute name="scripts">
        <script type="text/javascript">
            $(document).ready(function () {

                function getLocalidades(departamentoId) {

                    return $.get("${context}/localidad/" + departamentoId + "/all").done(function (data) {
                        var localidades = '<option>Seleccione una localidad...</option>';
                        for (i = 0; i < data.length; i++) {
                            localidades = localidades + '<option value="' + data[i].id + '">' + data[i].descripcion + '</option>';
                        }
                        $("#localidadId").html(localidades);
                    });
                }


                function getDepartamentos(provinciaId) {

                    return $.get("${context}/departamento/" + provinciaId + "/all").done(function (data) {
                        var deptos = '<option>Seleccione un departamento...</option>';
                        for (i = 0; i < data.length; i++) {
                            deptos = deptos + '<option value="' + data[i].id + '">' + data[i].descripcion + '</option>';
                        }
                        $("#departamentoId").html(deptos);
                    });
                }

                $("#provinciaId").change(function () {
                    modal.showPleaseWait();
                    $.when(getDepartamentos($("#provinciaId").val())).always(function () {
                        modal.hidePleaseWait();
                    });
                });

                $("#departamentoId").change(function () {
                    modal.showPleaseWait();
                    $.when(getLocalidades($("#departamentoId").val())).always(function () {
                        modal.hidePleaseWait();
                    })
                });


                $("#alertNoResults").hide();
                $("#tableResults").hide();

                $("#btnBuscar").click(function () {
                    var query = {};
                    if ($("#nombre").val() != '' && $("#nombre").val() != undefined && $("#nombre").val() != null) {
                        query.nombre = $("#nombre").val();
                    }
                    if ($("#localidadId").val() != null && $("#localidadId").val() != undefined) {
                        query.localidadId = $("#localidadId").val();
                    }
                    $.get("${context}/restaurant/query", query).done(function (data) {
                        if (data.length > 0) {
                            $("#alertNoResults").hide();
                            $("#alertParameters").hide();
                            $("#tableResults").show();
                            $("#tableResults").html('<tr><th>Nombre</th><th>Dirección</th><th></th></tr>');

                            $.each(data, function (key, value) {
                                $("#tableResults tr:last").after(
                                    '<tr>' +
                                    '<td>' + value.nombre + '</td>' +
                                    '<td>' + value.domicilio + '</td>' +
                                    '<td><a href="'+ value.id +'" class="btn btn-warning">Reservar</a></td>');
                            });
                        } else {
                            $("#alertNoResults").show();
                            $("#alertParameters").hide();
                            $("#tableResults").hide();
                        }

                    })
                });
            })
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="nombre" class="col-sm-2 col-md-3 control-label">Nombre</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" id="nombre" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="provinciaId" class="col-sm-2 col-md-3 control-label">Provincia</label>
                        <div class="col-sm-10 col-md-9">
                            <select id="provinciaId" class="form-control">
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
                            <select id="departamentoId" class="form-control">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="localidadId" class="col-sm-2 col-md-3 control-label">Localidad</label>
                        <div class="col-sm-10 col-md-9">
                            <select id="localidadId" class="form-control">
                            </select>
                        </div>
                    </div>
                    <button class="btn btn-primary" type="button" id="btnBuscar"><i class="fa fa-search"></i></button>
                </div>
            </div>
            <div class="row">
                <div class="alert alert-info" id="alertParameters">
                    <h1><i class="fa fa-info-circle"></i><strong>Ingrese los parametros para buscar</strong></h1>
                </div>
                <div class="alert alert-warning" id="alertNoResults">
                    <h1><i class="fa fa-info-circle"></i><strong>Su busqueda no arrojo resultados</strong></h1>
                </div>
                <div class="row" id="results">
                    <table id="tableResults" class="table table-striped">

                    </table>
                </div>
            </div>
        </div>


    </jsp:body>
</t:layout>