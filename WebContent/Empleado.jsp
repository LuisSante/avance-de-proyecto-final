<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" ;charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<title>JSP </title>
	</head>
	<body>
		<div class="d-flex">
			<div class="card col-som-6">
				<div class="card-body">
					<form action="Controlador?menu=empleado" method="POST">
						<div class="form-group">
							<label>Dni</label>
							<input type=text value="${empleado.getDni()}" name="txtDni" class="form-control">
						</div>
						<div class="form-group">
							<label>Nombres</label>
							<input type=text value="${empleado.getNom()}" name="txtNombres" class="form-control">
						</div>
						<div class="form-group">
							<label>Telefono</label>
								<input type=text value="${empleado.getTel()}" name="txtTel" class="form-control">
						</div>
						<div class="form-group">
							<label>Estado</label>
							<input type=text value="${empleado.getEstado()}" name="txtestado" class="form-control">
						</div>
						<div class="form-group">
							<label>Usuario</label>
							<input type=text value="${empleado.getUser()}" name="txtUsuario" class="form-control">
						</div>
						<input type="submit" name="accion" value="Agregar" class="btn btn-info">
						<input type="submit" name="accion" value="Actualizar" class="btn btn-success">
					</form>
				</div>
			</div>
			<div class="col-sm-8">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>DNI</th>
							<th>NOMBRES</th>
							<th>TELEFONO</th>
							<th>ESTADO</th>
							<th>USER</th>
							<th>ACCIONES</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="em" items="${empleados}">
						<tr>
							<td>${em.getId(}</td>
							<td>${em.getDni()}</td>
							<td>${em.getNom()}</td>
							<td>${em.getTel()}</td>
							<td>${em.getEstado()}</td>
							<td>${em.getUser()}</td>
							<td>
								<a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id"=${em.getId()}>Editar</a>
								<a class="btn btn-danger"href="Controlador?menu=Empleado&accion=Delete&id"=${em.getId()}>Delete</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
		</div>
	</body>
</html>