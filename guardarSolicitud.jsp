<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="solicitud.datos.SolicitudDAO,solicitud.vo.SolicitudVO,solicitud.vo.HorarioVO"%>






<%
SolicitudVO solicitud = new SolicitudVO();
HorarioVO horario = new HorarioVO();

solicitud.setNombre(request.getParameter("nombre"));
solicitud.setDni(request.getParameter("dni"));
solicitud.setTelefono(Integer.parseInt(request.getParameter("telefono")));
solicitud.setMateria(request.getParameter("materia"));
solicitud.setFechaPermiso(request.getParameter("FechaPermiso"));
solicitud.setMotivo(request.getParameter("motivo"));
solicitud.setDiaCompleto("completo".equals(request.getParameter("Dia")));
solicitud.setDiaNoCompleto("nocompleto".equals(request.getParameter("Dia")));
solicitud.setFechaEntrega(request.getParameter("FechaEntrega"));

solicitud.setDenegado("denegado".equals(request.getParameter("resolucion")));
solicitud.setConcedido("concedido".equals(request.getParameter("resolucion")));

if ("diurno".equals(request.getParameter("tipoHorario"))) {
	horario.setTipo("diurno");
} else {
	horario.setTipo("nocturno");
}

horario.setGrupo1(request.getParameter("grupo1"));
horario.setGrupo2(request.getParameter("grupo2"));
horario.setGrupo3(request.getParameter("grupo3"));
horario.setGrupo4(request.getParameter("grupo4"));
horario.setGrupo5(request.getParameter("grupo5"));
horario.setGrupo6(request.getParameter("grupo6"));

horario.setAula1(request.getParameter("aula1"));
horario.setAula2(request.getParameter("aula2"));
horario.setAula3(request.getParameter("aula3"));
horario.setAula4(request.getParameter("aula4"));
horario.setAula5(request.getParameter("aula5"));
horario.setAula6(request.getParameter("aula6"));

solicitud.setHorario(horario);

int i = SolicitudDAO.guardar(solicitud);
if (i > 0) {
	response.sendRedirect("exitoGrabarSolicitud.jsp");
} else {
	response.sendRedirect("errorGrabarSolicitud.jsp");
}
%>
