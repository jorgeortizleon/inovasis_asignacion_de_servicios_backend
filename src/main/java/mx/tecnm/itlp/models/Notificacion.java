package mx.tecnm.itlp.models;

public class Notificacion {
	
	int idnotificaciones;
	int usuario_id;
	String contenido;
	int leida;
	int servicio_id;
	String fecha;

	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdnotificaciones() {
		return idnotificaciones;
	}
	public void setIdnotificaciones(int idnotificaciones) {
		this.idnotificaciones = idnotificaciones;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public int getLeida() {
		return leida;
	}
	public void setLeida(int leida) {
		this.leida = leida;
	}
	public int getServicio_id() {
		return servicio_id;
	}
	public void setServicio_id(int servicio_id) {
		this.servicio_id = servicio_id;
	}

}
