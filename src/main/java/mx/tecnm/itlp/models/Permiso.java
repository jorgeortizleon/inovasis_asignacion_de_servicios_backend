package mx.tecnm.itlp.models;

public class Permiso {
	int IdPermiso;
	int IdRol;
	String NombreMenu;
	int Estado;
	String FechaRegistro;
	
	public int getIdPermiso() {
		return IdPermiso;
	}
	public void setIdPermiso(int idPermiso) {
		IdPermiso = idPermiso;
	}
	public int getIdRol() {
		return IdRol;
	}
	public void setIdRol(int idRol) {
		IdRol = idRol;
	}
	public String getNombreMenu() {
		return NombreMenu;
	}
	public void setNombreMenu(String nombreMenu) {
		NombreMenu = nombreMenu;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	
	
}
