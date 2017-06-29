<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<t:layout>
    <jsp:attribute name="scripts">
        <jsp:include page="scripts.jsp"></jsp:include>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="page-header">
                <div class="panel panel-info">
                    <div class="panel-heading">
                            ${restaurant.nombreFantasia}
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>Domicilio :
                                <strong>${restaurant.domicilio.calle} ${restaurant.domicilio.numero} ${restaurant.domicilio.localidad.descripcion}</strong>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="txtComensales" class="col-md-2">Cantidad de comensales</label>
                        <div class="col-md-3"><input type="number" id="txtComensales" class="form-control"></div>
                        <button type="button" id="btnConfirmarComensales" class="btn btn-primary">Confirmar</button>
                    </div>
                </div>
            </div>
            <div class="row">
                <table class="table table-striped" id="comensalesTable">
                    <tr>
                        <th>Comensal</th>
                        <th>Menu</th>
                        <th>Total</th>
                    </tr>
                </table>
            </div>


        </div>

        <div class="modal fade" tabindex="-1" role="dialog" id="menuModal"
             aria-labelledby="modalMenu">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Menu</h4>
                    </div>
                    <div class="modal-body">
                       <div class="form-horizontal">
                           <div class="form-group">
                               <label class="col-md-2">Item</label>
                               <div class="col-md-10">
                                   <select class="form-control">
                                       <c:forEach var="item" items="${restaurant.carta}">
                                           <option value="${item.id}">${item.descripcion}</option>
                                       </c:forEach>
                                   </select>
                               </div>

                           </div>
                       </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>