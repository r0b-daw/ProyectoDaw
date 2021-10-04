package solicitud.datos;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
	public static int guardar(DiurnoVO e){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into solicitud(Nombre,DNI,Tlf,Materia,FechaPermiso,Motivo,FechaEntrega,DiaCompleto,DiaNoCompleto,Firma,Denegado,Concedido,Constancias) values (?,?,?,?)");
			ps.setString(1,e.getNombre());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getZona());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int modificar(SolicitudVO e){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("update empleados set nombre=?,password=?,email=?,zona=? where id=?");
			ps.setString(1,e.getNombre());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getZona());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int eliminar(int id){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from empleados where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	public static int eliminar(SolicitudVO empleado){
		int status=0;
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from empleados where id=?");
			ps.setInt(1,empleado.getId());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static SolicitudVO obtenerEmpleadoPorId(int id){
		SolicitudVO e=new SolicitudVO();
		
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from empleados where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setZona(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<SolicitudVO> obtenerEmpleados(){
		List<SolicitudVO> list=new ArrayList<SolicitudVO>();
		
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from empleados");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SolicitudVO e=new SolicitudVO();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setZona(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
