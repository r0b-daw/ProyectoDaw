<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="solicitud.datos.SolicitudDAO,solicitud.vo.SolicitudVO,solicitud.datos.HorarioDAO,solicitud.vo.HorarioVO"%>
<jsp:useBean id="ed" class="solicitud.vo.SolicitudVO"></jsp:useBean>
<jsp:setProperty property="*" name="ed"/>

<% 
	int id = ed.getId();
System.out.println("El valor del id a modificar "+id);

SolicitudVO e = SolicitudDAO.obtenerSolicitudPorId(id);
HorarioVO horario = HorarioDAO.obtenerHorarioPorId(id);
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="comun.jsp" />
<title>Solicitud de Permiso</title>
<link rel="stylesheet" href="estilo.css">
</head>
<body>

	

	<div class="contenedor">
		<header>
			<nav>
				<img src="logo.jpg">
			</nav>
		</header>

		<section class="main">
			<form action="formularioModificar.jsp" method="POST">
			<input type="hidden" name="Id"  value="<%=e.getId() %>">
				<label for="nombre">Don/Doña </label> 
				<input type="text" size="60"
					id="Nombre" name="Nombre" value="<%=e.getNombre()%>" ><br>
				<br> 
				<label for="dni">con D.N.I.:</label>
				 <input type="text"
					id="DNI" name="DNI" value="<%=e.getDni()%>"
					pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Z]{1}))"
					required> <label for="telefono">y teléfono de
					contacto</label> <input type="tel" id="Tlf" name="telefono" minlength="9"
					maxlength="9" value="<%=e.getTelefono()%>"><br>
				<br> <label for="profesor">Profesor/a de:</label> <input
					type="text" id="Materia" name="materia"
					value="<%=e.getMateria()%>"> <label>en el IES
					Augustóbriga de Navalmoral de la Mata,</label><br>
				<br> <label for="solicitud"><h3>SOLICITA:</h3>conforme
					al artículo 70 de la ley de funcionarios civiles del estado, le sea<br>
					concedido un permiso para el/los día/s</label> <input type="text"
					id="FechaPermiso" name="FechaPermiso"
					value="<%=e.getFechaPermiso()%>"> <label for="motivos">por
					los motivos justificados<br>que se indican a continuación:<br>
				</labe> <input type="text" size="130" id="Motivo" name="motivo"
					value="<%=e.getMotivo()%>">

					<p>
						<div class="dia">
						<input type="radio" id="opt1" name="Dia" value="completo"  value="<%=e.isDiaCompleto()%>" class="dia">
    <label for="opt1">Día completo (No es necesario cumplimentar la tabla)<br><br></label>
    
    <input type="radio" id="opt2" name="Dia" value="nocompleto" value="<%=e.isDiaNoCompleto()%>" class="dia">
    
    <label for="opt2">Día no completo (Es necesaria la cumplimentación de la tabla)<br>Horas lectivas y grupos afectados</label>
</div>   
</p>

<br>

<label>Horario</label>

<select name="tipoHorario" size="1">
	<option value="diurno">DIURNO</option>
	<option value="nocturno">NOCTURNO</option>    
</select><br><br>

<table>
	<tr>
		<th>hora</th>
		<th>GRUPO</th>
		<th>AULA</th>
	</tr>
<tr>  
	<th>1ª</th>    
	    <th><label for="grupo"></label><input type="text" id="grupo"
									name="grupo1" size="40" value="<%=horario.getGrupo1()%>"></th> 
	    <th><label for="aula"></label><input type="text" id="aula"
									name="aula1" value="<%=horario.getAula1()%>"></th> 
	</tr>
	<tr>
	<th>2ª</th>
	    <th><label for="grupo"></label><input type="text" id="grupo"
									name="grupo2" size="40" value="<%=horario.getGrupo2()%>"></th>
	    <th><label for="aula"></label><input type="text" id="aula"
									name="aula2" value="<%=horario.getAula2()%>"></th>    
	</tr>
	<tr>
	    <th>3ª</th>
	    <th><label for="grupo"></label><input type="text" id="grupo"
									name="grupo3" size="40" value="<%=horario.getGrupo3()%>"></th>
	    <th><label for="aula"></label><input type="text" id="aula"
									name="aula3" value="<%=horario.getAula3()%>"></th>    
	    </tr>
	<tr>  
	    <th>4ª</th>
	    <th><label for="grupo"></label><input type="text" id="grupo"
									name="grupo4" size="40" value="<%=horario.getGrupo4()%>"></th>
	    <th><label for="aula"></label><input type="text" id="aula"
									name="aula4" value="<%=horario.getAula4()%>"></th>    
	</tr>
	<tr>
	    <th>5ª</th>
	    <th><label for="grupo"></label><input type="text" id="grupo"
									name="grupo5" size="40" value="<%=horario.getGrupo5()%>"></th>
	    <th><label for="aula"></label><input type="text" id="aula"
									name="aula5" value="<%=horario.getAula5()%>"></th>    
	</tr>
	<tr>
	    <th>6ª</th>
	    <th><label for="grupo"></label><input type="text" id="grupo"
									name="grupo6" size="40" value="<%=horario.getGrupo6()%>"></th>
	    <th><label for="aula"></label><input type="text" id="aula"
									name="aula6" value="<%=horario.getAula6()%>"></th>    
</tr>
</table>


<br><br><br>

<label for="fecha">Navalmoral de la Mata a
<input type="date" id="FechaEntrega" name="FechaEntrega"
						value="<%=e.getFechaEntrega()%>">
 </label>

 <br>
 <br>
 <label for="firma">Firma del Solicitante</label><br>        
 Fdo:<input type="text" id="Firma" name="firma"
					value="<%=e.getFirma()%>">      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Firma de la Directora <br> &nbsp;  &nbsp;  &nbsp;&nbsp;  &nbsp;  &nbsp;
  &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;  &nbsp; &nbsp;
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Fdo: Marta Víctor Vega                

<br><br>         
<fieldset>
<label class="decision"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <input type="radio" id="Denegado" name="resolucion" value="denegado"
							value="<%=e.isDenegado()%>" class="decision">
    DENEGADO
  </label>  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<label class="decision">
    <input type="radio" id="Concedido" name="resolucion"
							value="concedido" value="<%=e.isConcedido()%>" class="decision">  
    CONCEDIDO
</label>    
</fieldset><br><br>

<label for="motivos">
Se adjuntan como constancia justificativa los siguientes documentos:
<input type="file" name="file" id="Constancia" >     
</label>

<br><br>
	<p>
					<pre>Delegación Provincial de Educación Cáceres</pre>
	</p>
<br><br>
<input type="submit" value="Enviar Solicitud">
<input type="reset" value="Borrar Datos Introducidos">
<a href="ListarSolicitud.jsp">
	<input type="button" value="Volver" >
</a>
			</form>

	</div>
</body>
</html>



























