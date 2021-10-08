<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="comun.jsp" />
<title>Edit Form</title>
</head>
<body>
<%@page import="solicitud.datos.SolicitudDAO,solicitud.vo.SolicitudVO"%>

<%
String Id=request.getParameter("id");
SolicitudVO e=SolicitudDAO.obtenerSolicitudPorId(Integer.parseInt(Id));
%>
<div class="container mt-3">
<h1>Editar Empleado</h1>
<form action="formularioModificar.jsp" method="post">
<input type="hidden" name="dni" value="<%=e.getDni() %>"/>
<table>
<tr><td>Don/Doña</td><td><input type="text" name="nombre" value="<%= e.getNombre()%>"/></td></tr>
<tr><td>D.N.I</td><td><input type="text" name="dni" value="<%= e.getDni()%>"/></td></tr>
<tr><td>Teléfono</td><td><input type="tlf" name="telefono" value="<%= e.getTelefono()%>"/></td></tr>
<tr><td>Materia:</td><td><input type="text" name="materia" value="<%= e.getMateria()%>"/></td></tr>
<tr><td>Fecha permiso:</td><td><input type="text" name="FechaPermiso" value="<%= e.getFechaPermiso()%>"/></td></tr>
<tr><td>Motivo/Días y Horas a Modificar</td><td><input type="text" name="motivo" value="<%= e.getMotivo()%>"/></td></tr>

<tr><td colspan="2"><input type="submit" class="btn btn-primary"  value="Grabar"/></td></tr>
</table>
</form>
</div>
</body>
</html>