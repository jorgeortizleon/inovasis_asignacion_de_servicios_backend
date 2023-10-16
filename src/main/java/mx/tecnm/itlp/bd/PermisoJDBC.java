package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Permiso;

@Repository
public class PermisoJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	
	public List<Permiso> recuperarPermisos(int id) {
	    String sql = "SELECT * "
                + "from permiso "
                + "where IdRol = ?";
	    return conexion.query(sql, new PermisoRM(), id);
	}
	
	// obtener permiso a menu usuarios
	public int permisoMenuUsuarios(int id) {
	    String sql = "select Estado "
	                 + "from permiso  "
	                 + "where NombreMenu = \"menuUsuario\" and IdRol = ?";
	    return conexion.queryForObject(sql, Integer.class, id);
	}
	
	// obtener permiso a menu servicio
	public int permisoMenuServicios(int id) {
		   String sql = "select Estado "
		                + "from permiso  "
		                + "where NombreMenu = \"menuServicio\" and IdRol = ?";
		   return conexion.queryForObject(sql, Integer.class, id);
	}
	
	// obtener permiso a menu clientes
	public int permisoMenuClientes(int id) {
		   String sql = "select Estado "
		                + "from permiso  "
		                + "where NombreMenu = \"menuClientes\" and IdRol = ?";
		   return conexion.queryForObject(sql, Integer.class, id);
	}
	
	// obtener permiso a menu reportes
	public int permisoMenuReportes(int id) {
		   String sql = "select Estado "
		                + "from permiso  "
		                + "where NombreMenu = \"menuReportes\" and IdRol = ?";
			  return conexion.queryForObject(sql, Integer.class, id);
	}
	
	// obtener permiso a menu config
	public int permisoMenuConfig(int id) {
		   String sql = "select Estado "
		                + "from permiso  "
		                + "where NombreMenu = \"menuConfiguracion\" and IdRol = ?";
			  return conexion.queryForObject(sql, Integer.class, id);
	}
	
	// obtener permiso a menu acerca de
	public int permisoMenuAcercade(int id) {
			  String sql = "select Estado "
			               + "from permiso  "
			               + "where NombreMenu = \"menuAcercade\" and IdRol = ?";
			  return conexion.queryForObject(sql, Integer.class, id);
	}
	
	//update permisos
	public void modificarpermisos(int estado, String permiso, int idrol) {
		String sql = "UPDATE permiso SET estado=? WHERE NombreMenu = ? and idrol=?;";
		conexion.update(sql, estado, permiso, idrol );
	}
	
	//crear permisos, para cuando se crea un rol, tambien se crean sus permisos
	public void crearPermiso(int IdRol, String NombreMenu, int Estado) {
		String sql = "INSERT INTO permiso(IdRol, NombreMenu, Estado) VALUES(?, ?, ?);";
		conexion.update(sql, IdRol, NombreMenu, Estado);
	}

	
}
