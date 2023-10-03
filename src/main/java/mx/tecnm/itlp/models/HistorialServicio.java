package mx.tecnm.itlp.models;

public class HistorialServicio {
	int IdHistorial;
	String NombreCompleto;
	String Descripcion;
	String DescripcionCambio;
	String FechaCambio;
	public int getIdHistorial() {
		return IdHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		IdHistorial = idHistorial;
	}
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getDescripcionCambio() {
		return DescripcionCambio;
	}
	public void setDescripcionCambio(String descripcionCambio) {
		DescripcionCambio = descripcionCambio;
	}
	public String getFechaCambio() {
		return FechaCambio;
	}
	public void setFechaCambio(String fechaCambio) {
		FechaCambio = fechaCambio;
	}
	
}
