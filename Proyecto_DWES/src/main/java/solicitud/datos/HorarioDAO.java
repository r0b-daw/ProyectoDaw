package solicitud.datos;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import solicitud.vo.HorarioVO;
import solicitud.vo.SolicitudVO;


public class HorarioDAO {

	public static Connection getConnection(){
		Connection con=null;
		try{
			
			// CARGAR EL FICHERO DE PROPIEDADES
			Properties properties = new Properties();
			InputStream input = HorarioDAO.class.getResourceAsStream("/configuracion.properties");
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
	
	
	public static int guardar(HorarioVO e,int idSolicitud){
		int status=0;
		try{
			Connection con=HorarioDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into HORAS_GRUPOS (Hora,Grupo,Aula,Tipo,Permiso) values (?,?,?,?,?)");
			ps.setInt(5,idSolicitud);
			ps.setString(2,e.getGrupo1());
			ps.setString(2,e.getGrupo2());
			ps.setString(2,e.getGrupo3());
			ps.setString(2,e.getGrupo4());
			ps.setString(2,e.getGrupo5());
			ps.setString(2,e.getGrupo6());
			ps.setString(3,e.getAula1());
			ps.setString(3,e.getAula2());
			ps.setString(3,e.getAula3());
			ps.setString(3,e.getAula4());
			ps.setString(3,e.getAula5());
			ps.setString(3,e.getAula6());
			ps.setString(4,e.getTipo());

			status=ps.executeUpdate();
			
		
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	
	public static int modificarHorario(HorarioVO e,int idSolicitud){
		int status=0;
		try{
			Connection con=HorarioDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into HORAS_GRUPOS (Hora,Grupo,Aula,Tipo,Permiso) values (?,?,?,?,?)");
			ps.setInt(5,idSolicitud);
			ps.setString(2,e.getGrupo1());
			ps.setString(2,e.getGrupo2());
			ps.setString(2,e.getGrupo3());
			ps.setString(2,e.getGrupo4());
			ps.setString(2,e.getGrupo5());
			ps.setString(2,e.getGrupo6());
			ps.setString(3,e.getAula1());
			ps.setString(3,e.getAula2());
			ps.setString(3,e.getAula3());
			ps.setString(3,e.getAula4());
			ps.setString(3,e.getAula5());
			ps.setString(3,e.getAula6());
			ps.setString(4,e.getTipo());

			status=ps.executeUpdate();
			
		
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int eliminarHorario(int id){
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
	public static SolicitudVO obtenerSolicitudPorId(int Id){
		SolicitudVO e=new SolicitudVO();
		
		try{
			Connection con=SolicitudDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Solicitudes where Id=?");
			ps.setInt(1,Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				e.setNombre(rs.getString(1));
				e.setDni(rs.getString(2));
				e.setTelefono(rs.getInt(3));
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
				e.setDni(rs.getString(2));
				e.setTelefono(rs.getInt(3));
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

