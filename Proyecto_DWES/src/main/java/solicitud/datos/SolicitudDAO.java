package solicitud.datos;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import solicitud.vo.DiurnoVO;
import solicitud.vo.SolicitudVO;


public class SolicitudDAO {

	public static Connection getConnection(){
		Connection con=null;
		try{
			
			// CARGAR EL FICHERO DE PROPIEDADES
			Properties properties = new Properties();
			InputStream input = SolicitudDAO.class.getResourceAsStream("/configuracion/configuracion.properties");
	        properties.load(input);

			String driver = properties.getProperty("driver");
			String urlConexion = properties.getProperty("urlConexion");
			String usuario = properties.getProperty("usuario");
			String password = properties.getProperty("password");
			
			Class.forName(driver);
			con=DriverManager.getConnection(urlConexion,usuario, password);
			
			
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int guardar(SolicitudVO e){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Solicitudes(Nombre,DNI,Tlf,Materia,FechaPermiso,Motivo,FechaEntrega,DiaCompleto,DiaNoCompleto,Firma,Denegado,Concedido,Constancias) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,e.getNombre());
			ps.setString(2,e.getDNI());
			ps.setInt(3,e.getTlf());
			ps.setString(4,e.getMateria());
			ps.setString(5,e.getFechaPermiso());
			ps.setString(6,e.getMotivo());
			ps.setString(7,e.getFechaEntrega());
			ps.setBoolean(8,e.isDiaCompleto());
			ps.setBoolean(9,e.isDiaNoCompleto());
			ps.setString(10,e.getFirma());
			ps.setBoolean(11,e.isConcedido());
			ps.setBoolean(12,e.isDenegado());
			ps.setString(13,e.getConstancias());
		
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int modificar(SolicitudVO e){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update empleados set Nombre=?,DNI=?,Tlf=?,Materia=?,FechaPermiso=?,Motivo=?,FechaEntrega=?,DiaCompleto=?,DiaNocompleto=?,Firma=?,Concedido=?,Denegado=?,Constancias=?,where Id=?");
			ps.setString(1,e.getNombre());
			ps.setString(2,e.getDNI());
			ps.setInt(3,e.getTlf());
			ps.setString(4,e.getMateria());
			ps.setString(5,e.getFechaPermiso());
			ps.setString(6,e.getMotivo());
			ps.setString(7,e.getFechaEntrega());
			ps.setBoolean(8,e.isDiaCompleto());
			ps.setBoolean(9,e.isDiaNoCompleto());
			ps.setString(10,e.getFirma());
			ps.setBoolean(11,e.isConcedido());
			ps.setBoolean(12,e.isDenegado());
			ps.setString(13,e.getConstancias());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int eliminar(int id){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Solicitudes where Id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	public static int eliminar(SolicitudVO Solicitudes){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Solicitudes where Id=?");
			ps.setInt(1,Solicitudes.getId());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static SolicitudVO obtenerEmpleadoPorId(int Id){
		SolicitudVO e=new SolicitudVO();
		
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Solicitudes where Id=?");
			ps.setInt(1,Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				e.setNombre(rs.getString(1));
				e.setDNI(rs.getString(2));
				e.setTlf(rs.getInt(3));
				e.setMateria(rs.getString(4));
				e.setFechaPermiso(rs.getString(5));
				e.setMotivo(rs.getString(6));
				e.setFechaEntrega(rs.getString(7));
				e.setDiaCompleto(rs.getBoolean(8));
				e.setDiaNoCompleto(rs.getBoolean(9));
				e.setFirma(rs.getString(10));
				e.setDenegado(rs.getBoolean(11));
				e.setConcedido(rs.getBoolean(12));
				e.setConstancias(rs.getString(13));
			
				
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<SolicitudVO> obtenerSolicitud(){
		List<SolicitudVO> list=new ArrayList<SolicitudVO>();
		
		
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Solicitudes");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SolicitudVO e=new SolicitudVO();
				e.setNombre(rs.getString(1));
				e.setDNI(rs.getString(2));
				e.setTlf(rs.getInt(3));
				e.setMateria(rs.getString(4));
				e.setFechaPermiso(rs.getString(5));
				e.setMotivo(rs.getString(6));
				e.setFechaEntrega(rs.getString(7));
				e.setDiaCompleto(rs.getBoolean(8));
				e.setDiaNoCompleto(rs.getBoolean(9));
				e.setFirma(rs.getString(10));
				e.setDenegado(rs.getBoolean(11));
				e.setConcedido(rs.getBoolean(12));
				e.setConstancias(rs.getString(13));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
