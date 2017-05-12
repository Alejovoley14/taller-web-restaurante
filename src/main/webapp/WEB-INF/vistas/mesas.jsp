<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
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
	<section>
	<div class="container">
		<h1 class="text-center">Listado de mesas</h1>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<form:form method="POST" action="/registrar-mesa" modelAttribute="mesaNueva" cssClass="form form-horizontal">
					<label class="col-xs-9">Ingrese número de mesa</label>
					<div class="form-group col-xs-3">
						<form:input path="numero" placeholder="3" cssClass="form-control"/>
					</div>
					<label class="col-xs-8">Seleccione Ubicación</label>
					<div class="form-group col-xs-4">
						<form:select path="afuera" placeholder="3" cssClass="form-control">
							<form:option value="true">Afuera</form:option>
							<form:option value="false">Adentro</form:option>
						</form:select>
					</div>
					<button class="btn btn-success">Añadir mesa</button>
				</form:form>
			</div>
		</div>
		<div class="row">
			<table class="table table-striped table-responsive">
				<tr>
					<th>Nro de mesa</th>
					<th>Cant. de comensales</th>
					<th>Ubicación</th>
					<th>acciones</th>
				</tr>
				
				
				
			</table>
		</div>
	</div>

	</section>
</body>
</html>