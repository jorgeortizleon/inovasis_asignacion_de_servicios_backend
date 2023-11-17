package mx.tecnm.itlp.models;

import java.time.LocalDateTime;

public class HistorialServicio {
	int IdHistorial;
	String NombreCompleto;
	String Descripcion;
	String DescripcionCambio;
	String FechaCambio;
	private LocalDateTime fechaInicioEnProceso;
    private LocalDateTime fechaFin;

    
	public LocalDateTime getFechaInicioEnProceso() {
		return fechaInicioEnProceso;
	}
	public void setFechaInicioEnProceso(LocalDateTime fechaInicioEnProceso) {
		this.fechaInicioEnProceso = fechaInicioEnProceso;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}
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
