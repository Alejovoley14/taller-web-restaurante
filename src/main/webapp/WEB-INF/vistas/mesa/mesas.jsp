<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>

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
				<div class="page-header">
					<div class="row">
						<h1>Restaurant: ${restaurant.nombreFantasia}</h1> <small>Mesas</small>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="btn-group">
								<a href="${context}/restaurant" class="btn btn-primary"><i class="fa fa-backward"></i> </a>
								<a class="btn btn-success" type="submit" href="${context}/mesa-nueva/${restaurant.id}">Agregar <i class="fa fa-plus"></i></a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<table class="table table-striped table-responsive">
						<tr>
							<th>Nro de mesa</th>
							<th>Ubicación</th>
							<th>acciones</th>
						</tr>
						<c:forEach items="${listadoDeMesas}" var="mesa">
							<tr>
								<td>${mesa.getNumero()}</td>

								<td>
									<c:choose>
										<c:when test="${mesa.getAfuera()}">
											Afuera
										</c:when>
										<c:when test="${!mesa.getAfuera()}">
											Adentro
										</c:when>
									</c:choose>
								</td>
								<td>
									<a href="${context}/editar-mesa/${restaurant.id}/${mesa.getId()}"><span class="glyphicon glyphicon-pencil"></span></a>
									<a href="${context}/eliminar-mesa/${restaurant.id}/${mesa.getId()}"><span class="glyphicon glyphicon-remove"></span></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</section>
    </jsp:body>

</t:layout>