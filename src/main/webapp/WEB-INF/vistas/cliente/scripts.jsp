<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

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

        $('.input-group.date').datepicker({
            format: "yyyy-mm-dd",
            language: "es"
        });

        function getLocalidades(departamentoId) {
            return $.get("/localidad/" + departamentoId + "/departamento").done(function (data) {
                var localidades = '<option>Seleccione una localidad...</option>';
                for (i = 0; i < data.length; i++) {
                    localidades = localidades + '<option value="' + data[i].id + '">' + data[i].descripcion + '</option>';
                }
                $("#localidad_id").html(localidades);
            });
        }


        function getDepartamentos(provinciaId) {

            return $.get("/departamento/" + provinciaId + "/provincia").done(function (data) {
                var deptos = '<option>Seleccione un departamento...</option>';
                ;
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
        };


        function setMarker() {

            if (marker != undefined)
                marker.setMap(null);

            var address = $("#provinciaId option:selected").text() + ',' +
                $("#departamentoId option:selected").text() + ',' +
                $("#localidad_id option:selected").text() + ',' + $("#calle").val() + ' ' + $("#numero").val();
            var latLng;
            return $.get("https://maps.googleapis.com/maps/api/geocode/json", {
                address: address,
                key: "AIzaSyDzfaxwXl0xql_XMHVs7e2m62Evn8avK3U"
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

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#img').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#photo").change(function () {
            readURL(this);
        });


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

        <c:choose>
        <c:when test="!${empty(cliente.provinciaId) && !empty(cliente.departamentoId) && !empty(cliente.localidadId)}">
        modal.showPleaseWait();
        $.when(getDepartamentos(${cliente.provinciaId}), getLocalidades(${cliente.departamentoId}))
            .done(function (deptos, localidades) {
                $("#provinciaId").val(${cliente.provinciaId});
                $("#localidad_id").val(${cliente.localidadId});
                $("#departamentoId").val(${cliente.departamentoId});
                $.when(setMarker()).always(function () {
                    modal.hidePleaseWait();
                });
            }).always(function () {
            modal.hidePleaseWait();
        });


        map.setCenter(new google.maps.LatLng('{{$domicilio->lat}}', '{{$domicilio->long}}'));

        </c:when>
        <c:when test="${empty(cliente.provinciaId) && empty(cliente.departamentoId) && empty(cliente.localidadId)}">
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


