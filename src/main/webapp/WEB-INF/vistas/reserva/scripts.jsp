<script type="text/javascript">
    $(document).ready(function () {

        var selectedPlatosId = [];

        $('#fechaPicker').datetimepicker({
            locale: 'es',
            minDate: new Date(),
            showTodayButton:true,
            format:'DD/MM/YYYY'
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
            selectedPlatosId.push({id: platoId,precio:precio});


            $("#tablePlatos tr:last").after('<tr><td>' + $("#optPlatos option:selected").text() + '</td><td>' + precio + '$</td><td><button  class="btnEliminar btn btn-danger" type="button" platoId=' + platoId + '><i class="fa fa-minus"></i></button> </td></tr>');
            updatePlatosArray();

        });

        $('#tablePlatos').on('click', ".btnEliminar", function () {
            $(this).closest('tr').remove();

            var idToremove = $(this).attr("platoId");

            $.each(selectedPlatosId, function(key, value) {
                if (value.id == idToremove ) {
                    selectedPlatosId.splice(key, 1);
                    return false;
                }
            });

            updatePlatosArray();
        });

        $("#fechaPicker").change(function(){
            var fecha = $(this).date();
           $.get("${context}//reserva/mesas/${restaurant.id}/"+ fecha).done(function (data) {

           });
        });
    });
</script>
