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
	<section>
		<div class="container">
			<h1 class="text-center">Listado de mesas</h1>
			
			<div class="row">
				<a href="mesa-nueva/${idRestaurant}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-plus"></span>Agregar nueva mesa</a>
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
							<td>${mesa.getAfuera()}</td>
							<td>
								<a href="eliminar-mesa/${mesa.getId()}"><span class="glyphicon glyphicon-remove"></span></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>
</body>
</html>