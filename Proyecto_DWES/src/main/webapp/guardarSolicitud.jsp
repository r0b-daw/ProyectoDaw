<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="solicitud.datos.SolicitudDAO"%>  

<jsp:useBean id="sol" class="solicitud.vo.SolicitudVO"></jsp:useBean>  
<jsp:setProperty property="*" name="sol"/>  



  
<%
System.out.println(sol.getNombre());
System.out.println(sol.getDNI());
System.out.println(sol.getTlf());
System.out.println(sol.getMateria());
System.out.println(sol.getFechaPermiso());
System.out.println(sol.getMotivo());
System.out.println(sol.isDiaCompleto());
System.out.println(sol.isDiaNoCompleto());
System.out.println(sol.getNombre());

System.out.println(sol.getGrupo1());
System.out.println(sol.getGrupo2());
System.out.println(sol.getGrupo3());
System.out.println(sol.getGrupo4());
System.out.println(sol.getGrupo5());
System.out.println(sol.getGrupo6());

System.out.println(sol.getAula1());
System.out.println(sol.getAula2());
System.out.println(sol.getAula3());
System.out.println(sol.getAula4());
System.out.println(sol.getAula5());
System.out.println(sol.getAula6());






    int i=SolicitudDAO.guardar(sol);  
        if(i>0){  
        response.sendRedirect("exitoGrabarEmpleado.jsp");  
        }else{  
        response.sendRedirect("errorGrabarEmpleado.jsp");  
        }
    %>  