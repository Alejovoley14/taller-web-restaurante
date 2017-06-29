<script type="text/javascript">
    $(document).ready(function () {

        var comensales = [];
        $("#btnConfirmarComensales").click(function () {

            for (var i = 0; $(this).val() - 1 === i; i++) {
                comensales.push({index: i})
                var html = '<tr><td><input type="text" class="form-control"></td><td><button class="btn btn-success btnMenu" index="' + i + '"><i class="fa fa-plus"></i></button></td></tr>'
                $("#comensalesTable tr:last").after(html);
            }
            $(this).addClass('disabled');
        });


        $("#comensalesTable").on("click", ".btnMenu", function () {
            $("#menuModal").modal("show");
        });


    });
</script>
