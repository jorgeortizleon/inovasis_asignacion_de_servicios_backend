package mx.tecnm.itlp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioTable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUsuario;
	int IdRol;
	String UserName;
	String NombreCompleto;
	String Correo;
	String Clave;
	int Estado;
	String FechaRegistro;
	String Contrasena;
	int Activo;
	private String nombreRol;
    private String confirmarContrasena; 
    
    public int getIdUsuario() {
        return IdUsuario;
    }
	public int getIdRol() {
		return IdRol;
	}

	public void setIdRol(int idRol) {
		IdRol = idRol;
	}
    public void setIdUsuario(int idUsuario) {
        this.IdUsuario = idUsuario;
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
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getConfirmarContrasena() {
		return confirmarContrasena;
	}
	public void setConfirmarContrasena(String confirmarContrasena) {
		this.confirmarContrasena = confirmarContrasena;
	}
	public int getActivo() {
        return Activo;
    }
	public void setActivo(int activo) {
		Activo = activo;
	}



}