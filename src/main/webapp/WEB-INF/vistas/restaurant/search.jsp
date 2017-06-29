<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="context" value="${pageContext.request.contextPath}"></c:set>

<t:layout>
     <jsp:attribute name="scripts">
        <script type="text/javascript">
            var directionsDisplay;
            var directionsService;
            var map;
            function initMap() {
                directionsService = new google.maps.DirectionsService()
                directionsDisplay = new google.maps.DirectionsRenderer();
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -34.397, lng: 150.644},
                    zoom: 8,
                    disableDefaultUI: true,
                    draggable: true
                });
            }

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
                            $("#tableResults").html('<tr><th>Nombre</th><th>Dirección</th><th>¿Como llegar?</th><th>Ver Carta</th><th>Reservar</th></tr>');

                            $.each(data, function (key, value) {
                                var url =  '${context}/reserva/' + value.id;
                                $("#tableResults tr:last").after(
                                    '<tr>' +
                                    '<td>' + value.nombre + '</td>' +
                                    '<td>' + value.domicilio + '</td>' +
                                    '<td><a href="#" class="btn btn-primary btnLlegar" latLong="' + value.latLong + '"><i class="fa fa-eye"></i></a></td>' +
                                    '<td><a href="#" class="btn btn-info btnCarta" restaurantId="' + value.id + '"><i class="fa fa-eye"></i></a></td>' +
                                    '<td><a href="' + url + '" class="btn btn-warning"><i class="fa fa-bell" aria-hidden="true"></i></a></td>');
                            });
                        } else {
                            $("#alertNoResults").show();
                            $("#alertParameters").hide();
                            $("#tableResults").hide();
                        }
                    })
                });

                $("#tableResults").on("click", ".btnCarta", function () {
                    $.get("${context}/carta/restaurant/" + $(this).attr("restaurantId")).done(function (data) {
                        if (data.length > 0) {

                            $("#cartaModalTable").html('<tr><th>Plato</th><th>Tipo</th><th>Precio</th></tr>');

                            $.each(data, function (key, value) {
                                $("#cartaModalTable tr:last").after(
                                    '<tr>' +
                                    '<td><p>' + value.titulo + '<br><small>' + value.descripcion + '</small></p></td>' +
                                    '<td>' + value.tipo + '</td>' +
                                    '<td>' + value.precio + '$</td>');
                            });

                            $("#cartaModal").modal("show");
                        }
                    });
                })

                var currentPos;
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
                        currentPos = pos.lat + "," + pos.lng;
                        map.setCenter(pos);
                    });
                }

                var from, to, medioTransporte;

                function calcRoute() {

                    var request = {
                        origin: from,
                        destination: to,
                        travelMode: google.maps.TravelMode[medioTransporte]
                    };
                    directionsService.route(request, function (result, status) {
                        if (status == 'OK') {
                            directionsDisplay.setDirections(result);
                            directionsDisplay.setMap(map);
                        }
                    });
                }

                $("#tableResults").on("click", ".btnLlegar", function () {
                    to = $(this).attr("latLong");
                    from = $("#myLatLong").val();
                    medioTransporte = 'DRIVING';
                    calcRoute();
                    $("#mapModal").modal("show");


                });

                $("#mapModal").on("shown.bs.modal", function () {
                    google.maps.event.trigger(map, "resize");
                    map.setCenter(new google.maps.LatLng($("#myLatLong").val().split(",")[0], $("#myLatLong").val().split(",")[1]));
                });


                $('input[type=radio][name=medioTransporte]').change(function () {
                    medioTransporte = $('input[name=medioTransporte]:checked').val()
                    calcRoute();
                });

                $('input[type=radio][name=fromWhere]').change(function () {
                    if ($('input[name=fromWhere]:checked').val() == 'current') {
                        from = currentPos;
                    } else {
                        from = $("#myLatLong").val();
                    }

                    calcRoute();
                });


            });
        </script>
         <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBwsdz2QoD3Bk4JhQNShw1GZ2cTsuY61vE&callback=initMap"
                 async defer></script>
    </jsp:attribute>
    <jsp:body>
        <input id="myLatLong" type="hidden" value="${latLong}">
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
                    <button class="btn btn-primary" type="button" id="btnBuscar">Buscar <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="alert alert-info" id="alertParameters">
                    <h3><i class="fa fa-info-circle"></i><strong>Ingrese los parametros para buscar</strong></h3>
                </div>
                <div class="alert alert-warning" id="alertNoResults">
                    <h3><i class="fa fa-info-circle"></i><strong>Su busqueda no arrojo resultados</strong></h3>
                </div>
                <div class="row" id="results">
                    <table id="tableResults" class="table table-striped">

                    </table>
                </div>
            </div>
        </div>


        <div class="modal fade" tabindex="-1" role="dialog" id="cartaModal"
             aria-labelledby="modalCarta">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Carta</h4>
                    </div>
                    <div class="modal-body">
                        <table id="cartaModalTable" class="table table-striped">

                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" tabindex="-1" role="dialog" id="mapModal"
             aria-labelledby="modalCarta">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">¿Como llegar?</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-offset-2 col-md-4">

                                <div class="btn-group" data-toggle="buttons">
                                    <label class="btn btn-default">
                                        <input type="radio" name="medioTransporte" value="TRANSIT"> <i
                                            class="fa fa-bus"></i>
                                    </label>
                                    <label class="btn btn-default active">
                                        <input type="radio" name="medioTransporte" value="DRIVING"
                                               checked><i class="fa fa-car"></i>
                                    </label>
                                    <label class="btn btn-default">
                                        <input type="radio" name="medioTransporte" value="WALKING"><i
                                            class="fa fa-male"></i>
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-offset-2 col-md-4">
                                <div class="btn-group" data-toggle="buttons">
                                    <label class="btn btn-default">
                                        <input type="radio" name="fromWhere" value="current"> Mi ubicación
                                    </label>
                                    <label class="btn btn-default active">
                                        <input type="radio" name="fromWhere" value="fixed" checked> Mi domicilio
                                    </label>

                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-offset-1 col-md-10">
                                <div id="map" class="embed-responsive-16by9"></div>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>


    </jsp:body>
</t:layout>