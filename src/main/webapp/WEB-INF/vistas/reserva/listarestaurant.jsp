<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<t:layout>
     <jsp:attribute name="scripts">
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#tableReservas").on("click", ".btnCarta", function () {
                        var contenido = $("#" + $(this).attr("menuId")).html();
                        $("#cartaModalBody").html(contenido);
                        $("#cartaModal").modal("show");

                    })
                });
            </script>
        </jsp:attribute>
    <jsp:body>

        <div class="container">
            <div class="row">
                <c:if test="${reservas.isEmpty()}">

                    <div class="alert alert-info text-center">
                        <h1><i class="fa fa-info"></i> <strong>No tiene reservas por el momento</strong></h1>
                    </div>
                </c:if>
                <c:if test="${!reservas.isEmpty()}">


                    <table class="table table-striped" id="tableReservas">
                        <tr>
                            <th>Cliente</th>
                            <th>Mesa</th>
                            <th>Menu</th>
                            <th>Confirmar</th>
                            <th>Cancelar</th>
                        </tr>
                        <c:forEach var="item" items="${reservas}">
                            <tr>
                                <td>${item.cliente}</td>
                                <td>${item.mesa}</td>
                                <td>
                                    <button type="button" class="btn btn-info btnCarta" menuId="menu${item.id}"><i
                                            class="fa fa-eye"></i></button>
                                    <div class="hidden" id="menu${item.id}">
                                        <table class="table table-striped">
                                            <tr>
                                                <th>Tipo</th>
                                                <th>Plato</th>
                                                <th>Descripción</th>
                                            </tr>
                                            <c:forEach var="plato" items="${item.platos}">
                                                <tr>
                                                    <td>${plato.tipoProducto}</td>
                                                    <td>${plato.titulo}</td>
                                                    <td>${plato.descripcion}</td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </div>

                                </td>
                                <td>
                                    <th:form action="${context}/reserva/restaurant/confirmar" method="post">
                                        <input type="hidden" name="id" value="${item.id}">
                                        <button type="submit" class="btn btn-success"><i class="fa fa-check"></i>
                                        </button>
                                    </th:form>
                                </td>
                                <td>
                                    <th:form action="${context}/reserva/restaurant/cancelar" method="post">
                                        <input type="hidden" name="id" value="${item.id}">
                                        <button type="submit" class="btn btn-danger"><i class="fa fa-remove"></i>
                                        </button>
                                    </th:form>
                                </td>
                            </tr>

                        </c:forEach>


                    </table>
                </c:if>
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
                    <div class="modal-body" id="cartaModalBody">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>