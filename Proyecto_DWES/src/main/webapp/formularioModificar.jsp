<%@page import="solicitud.datos.SolicitudDAO"%>
<jsp:useBean id="e" class="solicitud.vo.SolicitudVO"></jsp:useBean>
<jsp:setProperty property="*" name="e"/>

<%
int i=SolicitudDAO.modificar(e);
response.sendRedirect("ListarSolicitud.jsp");
%>