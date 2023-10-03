package mx.tecnm.itlp.models;

public class CrearHistorialServicioDTO {
	int IdServicio;
	int IdUsuario; 
	int IdEstadoServicio; 
	String DescripcionCambio;
	
	public int getIdServicio() {
		return IdServicio;
	}
	public void setIdServicio(int idServicio) {
		IdServicio = idServicio;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public int getIdEstadoServicio() {
		return IdEstadoServicio;
	}
	public void setIdEstadoServicio(int idEstadoServicio) {
		IdEstadoServicio = idEstadoServicio;
	}
	public String getDescripcionCambio() {
		return DescripcionCambio;
	}
	public void setDescripcionCambio(String descripcionCambio) {
		DescripcionCambio = descripcionCambio;
	}
	
}
