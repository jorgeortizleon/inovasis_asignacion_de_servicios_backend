package mx.tecnm.itlp.models;

import java.time.LocalDateTime;

public class TiempoServicio {
    private int idServicio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinalizacion;
    private int tiempoTotal;
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public int getTiempoTotal() {
		return tiempoTotal;
	}
	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

    // Getters y setters
}

