<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>

<t:layout>

    <jsp:attribute name="styles">
        <style type="text/css">
            /*SI FUERA NECESARIO AGREGAR JQUERY O ESTILOS ESTA ES LA MANERA USANDO LOS ATTRIBUTOS DEL LAYOUT*/
        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <script type="text/javascript">
            //SI FUERA NECESARIO AGREGAR JQUERY O ESTILOS ESTA ES LA MANERA USANDO LOS ATTRIBUTOS DEL LAYOUT
        </script>
    </jsp:attribute>

    <jsp:body>
		<section>
			<div class="container">
				<h1 class="text-center">Listado de mesas</h1>
				
				<div class="row">
					<a href="${context}/mesa-nueva/${idRestaurant}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-plus"></span>Agregar nueva mesa</a>
					<table class="table table-striped table-responsive">
						<tr>
							<th>Nro de mesa</th>
							<th>Cant. de comensales</th>
							<th>Ubicación</th>
							<th>acciones</th>
						</tr>
						<c:forEach items="${listadoDeMesas}" var="mesa">
							<tr>
								<td>${mesa.getNumero()}</td>
								<td></td>
								<td>
									${mesa.getAfuera()}
								</td>
								<td>
									<a href="${context}/editar-mesa/${idRestaurant}/${mesa.getId()}"><span class="glyphicon glyphicon-pencil"></span></a>
									<a href="${context}/eliminar-mesa/${idRestaurant}/${mesa.getId()}"><span class="glyphicon glyphicon-remove"></span></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</section>
    </jsp:body>

</t:layout>