package mx.tecnm.itlp.models;

public class Usuario {
	int IdUsuario;
	String UserName;
	String NombreCompleto;
	String Correo;
	String Clave;
	int IdRol;
	int Estado;
	String FechaRegistro;
	String Contrasena;
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public int getIdRol() {
		return IdRol;
	}
	public void setIdRol(int idRol) {
		IdRol = idRol;
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
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	
	
	
}
