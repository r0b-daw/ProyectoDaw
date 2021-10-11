<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<jsp:include page="comun.jsp" />
<title>View Users</title>
</head>
<body>

	<%@page import="solicitud.datos.SolicitudDAO,solicitud.vo.SolicitudVO"%>
	<%@ page import="java.util.List"%>

	<div class="container mt-3">
		<h1>Lista Empleados</h1>

		<%
		List<SolicitudVO> list = SolicitudDAO.obtenerSolicitud();
		request.setAttribute("list", list);
		%>

		<table class="table" width="90%">
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Materia</th>
				<th>Fecha Permiso</th>
				<th>Motivo</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.getNombre()}</td>
					<td>${u.getDni()}</td>
					<td>${u.getMateria()}</td>
					<td>${u.getFechaPermiso()}</td>
					<td>${u.getMotivo()}</td>
					<td><a class="btn btn-success btn-sm rounded-0"
						href="formularioEditarSolicitud.jsp?id=${u.getId()}"> Editar</a>
					</td>
					<td><a class="btn btn-danger btn-sm rounded-0"
						href="formularioEliminar.jsp?id=${u.getId()}"><i
							class="fa fa-trash"></i>Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a class="btn btn-primary" href="formularioNuevaSolicitud.jsp">Nueva
			Solicitud</a>

	</div>

</body>
</html>