<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>

<script type="text/javascript">

    var map;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8,
            disableDefaultUI: true,
            draggable: false
        });
    }

    $(document).ready(function () {


        var marker;

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


        function toggleBounce() {
            if (marker.getAnimation() !== null) {
                marker.setAnimation(null);
            } else {
                marker.setAnimation(google.maps.Animation.BOUNCE);
            }
        }


        function setMarker() {

            if (marker != undefined)
                marker.setMap(null);

            var address = $("#provinciaId option:selected").text() + ',' +
                $("#departamentoId option:selected").text() + ',' +
                $("#localidadId option:selected").text() + ',' + $("#calle").val() + ' ' + $("#numero").val();
            var latLng;
            return $.get("https://maps.googleapis.com/maps/api/geocode/json", {
                address: address,
                //todo:Api key alt AIzaSyCwh1Iw_UoMk5RGKEDc-6YVLsK6XCOUvxw(working) AIzaSyBwsdz2QoD3Bk4JhQNShw1GZ2cTsuY61vE(NOT WORKING)
                key: "AIzaSyCwh1Iw_UoMk5RGKEDc-6YVLsK6XCOUvxw"
            }).done(function (data) {
                if (data.status == 'OK') {
                    latLng = new google.maps.LatLng(data.results[0].geometry.location.lat, data.results[0].geometry.location.lng);

                    marker = new google.maps.Marker({
                        position: latLng,
                        map: map,
                        title: address,
                        animation: google.maps.Animation.DROP
                    });

                    marker.addListener('click', toggleBounce);

                    map.setZoom(13);
                    map.setCenter(latLng);
                    marker.setMap(map);

                    $("#lat").val(data.results[0].geometry.location.lat);
                    $("#long").val(data.results[0].geometry.location.lng);
                } else {
                    modal.hidePleaseWait();
                    toogleWarinngModal('<h3>Google no encontro su dirección</h3>', 'Opssss...', 'Aceptar');

                }


            })
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

        $("#btnSetMarker").click(function (e) {
            e.preventDefault();
            modal.showPleaseWait();
            $.when(setMarker()).always(function () {
                modal.hidePleaseWait();
            });

        });

        var selectedMediosPagoId = [];

        function updateMediosPagoArray() {
            var hiddens = "";
            $.each(selectedMediosPagoId, function (key, value) {
                hiddens += '<input type="hidden" name=medioDePagoIds[' + key + '] value="' + value.id + '"/>'
            });

            $("#selectedMediosPago").html(hiddens);
        }

        $("#btnAddMedioPago").click(function () {
            var medioPagoId = $("#optMedioPago").val();
            if (!alreadySelectedMedioPago(medioPagoId)) {
                selectedMediosPagoId.push({id: medioPagoId});

                $("#tableMediosPago tr:last").after('<tr id="' + medioPagoId + '"><td>' + $("#optMedioPago option:selected").text() + '</td><td><button  class="btnEliminar btn btn-danger" type="button" medioPagoId=' + medioPagoId + '><i class="fa fa-minus"></i></button> </td></tr>');

                updateMediosPagoArray();
            }
        });

        $('#tableMediosPago').on('click', ".btnEliminar", function () {
            $(this).closest('tr').remove();

            var idToremove = $(this).attr("medioPagoId");
            var filtered = $.grep(selectedMediosPagoId, function (e) {
                return e.id != idToremove;
            });
            selectedMediosPagoId = filtered;

            updateMediosPagoArray();
        });

        function alreadySelectedMedioPago(id) {
            var exists = false;
            $.each(selectedMediosPagoId, function (key, value) {
                if (value.id === id) {
                    exists = true;
                }
            });

            return exists
        }


        <c:if test="${!empty(restaurant.medioDePagoIds)}">
        var text;
        var id;
        <c:forEach var="mediopago" items="${restaurant.medioDePagoIds}">
        selectedMediosPagoId.push({id: "${mediopago}"});
        <c:forEach items="${medioPagos}" var="item">
        <c:if test="${item.id eq mediopago}">
        $("#tableMediosPago tr:last").after('<tr id="' + '${item.id}' + '"><td>' + '${item.descripcion}' + '</td><td><button  class="btnEliminar btn btn-danger" type="button" medioPagoId=' + '${item.id}' + '><i class="fa fa-minus"></i></button> </td></tr>');
        </c:if>
        </c:forEach>
        </c:forEach>
        updateMediosPagoArray();
        </c:if>
        <c:choose>
        <c:when test="${!empty(restaurant.domicilio.provinciaId) && !empty(restaurant.domicilio.departamentoId) && !empty(restaurant.domicilio.localidadId)}">
        modal.showPleaseWait();




        var provinciaId = '${restaurant.domicilio.provinciaId}';
        var departamentoId = '${restaurant.domicilio.departamentoId}';
        var localidadId = '${restaurant.domicilio.localidadId}';

        $.when(getDepartamentos(provinciaId), getLocalidades(departamentoId))
            .done(function (deptos, localidades) {
                $("#provinciaId").val(provinciaId);
                $("#localidadId").val(localidadId);
                $("#departamentoId").val(departamentoId);
                $.when(setMarker()).always(function () {
                    modal.hidePleaseWait();
                });
            }).always(function () {
            modal.hidePleaseWait();
        });

        </c:when>

        <c:when test="${empty(restaurant.domicilio.provinciaId) && empty(restaurant.domicilio.departamentoId) && empty(restaurant.domicilio.localidadId)}">
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };

                map.setCenter(pos);
            });
        }
        </c:when>
        </c:choose>
    });


</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBwsdz2QoD3Bk4JhQNShw1GZ2cTsuY61vE&callback=initMap"
        async defer></script>
