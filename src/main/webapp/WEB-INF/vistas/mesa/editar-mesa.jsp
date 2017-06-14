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
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<div class="panel panel-default">
						<div class="panel-heading"><h1 class="panel-title text-center">Editar mesa</h1></div>
							<div class="panel-body">
								<form:form method="POST" action="${context}/modificar-mesa/${idRestaurant}/${idMesa}" modelAttribute="mesa" cssClass="form form-horizontal">
									<form:input path="id" type="hidden"></form:input>
									<label class="col-xs-9">Ingrese número de mesa</label>
									<div class="form-group col-xs-3">
										<form:input path="numero" cssClass="form-control"/>
									</div>
									<!-- comensales no se puede agregar aun, debo poder modificar la db para implamentarlo -->
									<label class="col-xs-8">Seleccione Ubicación</label>
									<div class="form-group col-xs-4">
										<form:select path="afuera" placeholder="3" cssClass="form-control">
											<form:option value="true">Afuera</form:option>
											<form:option value="false">Adentro</form:option>
										</form:select>
									</div>
									<div class="btn-group btn-sm">
										<button class="btn btn-success">Añadir mesa</button>
										<a href="${context}/mesas/${idRestaurant}" class="btn btn-danger">Cancelar</a>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    </jsp:body>

</t:layout>