package solicitud.vo;

public class SolicitudVO {
	private int id;
	private String Nombre,DNI,Materia,FechaPermiso,Motivo,FechaEntrega,Firma,Constancias;
	private int Tlf;
	private boolean DiaCompleto,DiaNoCompleto,Denegado,Concedido;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getMateria() {
		return Materia;
	}
	public void setMateria(String materia) {
		Materia = materia;
	}
	public String getFechaPermiso() {
		return FechaPermiso;
	}
	public void setFechaPermiso(String fechaPermiso) {
		FechaPermiso = fechaPermiso;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getFechaEntrega() {
		return FechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}
	public String getFirma() {
		return Firma;
	}
	public void setFirma(String firma) {
		Firma = firma;
	}
	public String getConstancias() {
		return Constancias;
	}
	public void setConstancias(String constancias) {
		Constancias = constancias;
	}
	public int getTlf() {
		return Tlf;
	}
	public void setTlf(int tlf) {
		Tlf = tlf;
	}
	public boolean isDiaCompleto() {
		return DiaCompleto;
	}
	public void setDiaCompleto(boolean diaCompleto) {
		DiaCompleto = diaCompleto;
	}
	public boolean isDiaNoCompleto() {
		return DiaNoCompleto;
	}
	public void setDiaNoCompleto(boolean diaNoCompleto) {
		DiaNoCompleto = diaNoCompleto;
	}
	public boolean isDenegado() {
		return Denegado;
	}
	public void setDenegado(boolean denegado) {
		Denegado = denegado;
	}
	public boolean isConcedido() {
		return Concedido;
	}
	public void setConcedido(boolean concedido) {
		Concedido = concedido;
	}

	
	
	
}
