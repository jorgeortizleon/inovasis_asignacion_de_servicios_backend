package mx.tecnm.itlp.models;

public class Observacion {
	 int IdObservacion;
	 String NombreCompleto;
	 String observacion;
	 String FechaRegistro;
	 int visto;
	 
	public int getIdObservacion() {
		return IdObservacion;
	}
	public void setIdObservacion(int idObservacion) {
		IdObservacion = idObservacion;
	}
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public int getVisto() {
		return visto;
	}
	public void setVisto(int visto) {
		this.visto = visto;
	}
	
}
