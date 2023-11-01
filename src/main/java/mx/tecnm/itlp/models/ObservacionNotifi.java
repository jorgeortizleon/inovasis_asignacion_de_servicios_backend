package mx.tecnm.itlp.models;

public class ObservacionNotifi {
	 int IdObservacion;
	 int IdServicio;
	 int IdUsuario;
	 String Observacion;
	 String FechaRegistro;
	 String UserName;
	 
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getIdObservacion() {
		return IdObservacion;
	}
	public void setIdObservacion(int idObservacion) {
		IdObservacion = idObservacion;
	}
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
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	 
}
