<%@page import="solicitud.datos.SolicitudDAO"%>
<jsp:useBean id="e" class="solicitud.vo.SolicitudVO"></jsp:useBean>
<jsp:setProperty property="*" name="e"/>

<%
SolicitudDAO.eliminar(e);
response.sendRedirect("ListarSolicitud.jsp");
%>