<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Mesas</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading"><h1 class="panel-title text-center">Añadir nueva mesa</h1></div>
						<div class="panel-body">
							<form:form method="POST" action="registrar-mesa" modelAttribute="mesaNueva" cssClass="form form-horizontal">
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
									<a href="mesas" class="btn btn-danger">Cancelar</a>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>