<script type="text/javascript">
    $(document).ready(function () {

        var selectedPlatosId = [];
        var context = "${context}";

        $("#divMesaNoDisponible").hide();
        $("#divMesas").hide();

        $('#fechaPicker').datetimepicker({
            locale: 'es',
            minDate: new Date(),
            showTodayButton: true,
            format: 'DD/MM/YYYY'
        });

        function updatePlatosArray() {
            var hiddens = "";
            var totalPagar = 0;
            $.each(selectedPlatosId, function (key, value) {
                hiddens += '<input type="hidden" name=platosSeleccionados[' + key + '] value="' + value.id + '"/>'
                totalPagar = parseInt(totalPagar) + parseInt(value.precio);
            });

            $("#totalPrecio").html(totalPagar + "$");
            $("#selectedPlatos").html(hiddens);
        }

        $("#btnAddPlato").click(function () {
            var platoId = $("#optPlatos").val();
            var precio = $("#optPlatos option:selected").attr("precio");
            selectedPlatosId.push({id: platoId, precio: precio});


            $("#tablePlatos tr:last").after('<tr><td>' + $("#optPlatos option:selected").text() + '</td><td>' + precio + '$</td><td><button  class="btnEliminar btn btn-danger" type="button" platoId=' + platoId + '><i class="fa fa-minus"></i></button> </td></tr>');
            updatePlatosArray();

        });

        $('#tablePlatos').on('click', ".btnEliminar", function () {
            $(this).closest('tr').remove();

            var idToremove = $(this).attr("platoId");

            $.each(selectedPlatosId, function (key, value) {
                if (value.id == idToremove) {
                    selectedPlatosId.splice(key, 1);
                    return false;
                }
            });

            updatePlatosArray();
        });

        $("#fechaPicker").on("dp.change",function (e) {
            var restuaurant = "${restaurant.id}";
            var test = e.date.format("DDMMYYYY");

            modal.showPleaseWait();
            var fecha =  + "" + (e.date.toDate().getMonth() + 1) +  ""  + e.date.toDate().getFullYear();

            $.get(context + "/reserva/mesas/" + restuaurant + "/" +  e.date.format("DDMMYYYY")).done(function (data) {
                if (data.length > 0) {
                    var html = "";
                    $.each(data, function (key, value) {
                        html += '<option value="' + value.id + '">' + value.numero + ' (' + value.ubicacion + ')</option>';
                    });
                    $("#selectMesa").html(html);
                    $("#divMesas").show();
                    $("#divmesanodisponible").hide();
                } else {
                    $("#divMesas").hide();
                    $("#divmesanodisponible").show();
                }
            })
                .always(function(){
                    modal.hidePleaseWait();
                });
        });
    });
</script>
