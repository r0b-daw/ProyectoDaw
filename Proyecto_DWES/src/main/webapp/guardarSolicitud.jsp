<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="solicitud.datos.SolicitudDAO,solicitud.vo.SolicitudVO"%>  





  
<%

SolicitudVO solicitud = new SolicitudVO();


solicitud.setNombre(request.getParameter("nombre"));
solicitud.setDni(request.getParameter("dni"));
solicitud.setDni(request.getParameter("dni"));
solicitud.setDni(request.getParameter("dni"));
solicitud.setDni(request.getParameter("dni"));




    int i=SolicitudDAO.guardar(solicitud);  
        if(i>0){  
        response.sendRedirect("exitoGrabarEmpleado.jsp");  
        }else{  
        response.sendRedirect("errorGrabarEmpleado.jsp");  
        }
    %>  