package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.NombreIdUsuarioDTO;
import mx.tecnm.itlp.models.Usuario;
import mx.tecnm.itlp.models.UsuarioTable;

@Repository
public class UsuarioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//read
	public List<UsuarioTable> consultarUsuariosParaTable() {
	    String sql = "SELECT u.IdUsuario, u.UserName, u.NombreCompleto, u.Correo, u.Clave, u.IdRol, r.Descripcion AS nombreRol, u.Estado, u.FechaRegistro, u.Contrasena, u.Activo "
                + "FROM Usuario u "
                + "JOIN Rol r ON u.IdRol = r.IdRol";
	    return conexion.query(sql, new UsuarioTableRM());
	}
	
	// Método para editar un usuario por su ID
	public void editarUsuario(UsuarioTable usuarioTable, int id) {
	    String sql = "UPDATE usuario SET UserName = ?, NombreCompleto = ?, Correo = ?, IdRol = ?, Contrasena = ?, Estado = ? WHERE IdUsuario = ?";
	    conexion.update(sql, usuarioTable.getUserName(), usuarioTable.getNombreCompleto(), usuarioTable.getCorreo(), usuarioTable.getIdRol(), usuarioTable.getContrasena(),usuarioTable.getEstado() ,id);
	}
	
	//delate
	public void marcarUsuarioComoInactivo(int idUsuario) {
	    String sql = "UPDATE Usuario SET Activo = 0 WHERE IdUsuario = ?";
	    conexion.update(sql, idUsuario);
	}

	
	
	/*/////////////////////////////////////////////////////////////
	public List<Usuario> consultarUsuarios(){
		String sql = "SELECT u.IdUsuario, u.UserName, u.NombreCompleto, u.Correo, u.Clave, r.Descripcion AS IdRol, u.Estado, u.FechaRegistro, u.Contrasena\r\n"
				+ "FROM Usuario u\r\n"
				+ "JOIN Rol r ON u.IdRol = r.IdRol;\r\n";
		return conexion.query(sql, new UsuarioRM());
	}
*/
	//////////////////////////////////////////////////////
	/*public Usuario buscarUsuario(int id) {
		String sql = "SELECT * FROM usuarios WHERE idusuario = ?";
		return conexion.queryForObject(sql,new UsuarioRM(), id);
	}*/

	/*//"delete"
	public void desactivarUsuario(int id) {
		String sql = "UPDATE usuarios SET activo = 0 WHERE idusuario = ?";
		conexion.update(sql,id);
	}*/

	/*public void agregarUsuario1(Usuario user) {
		String sql = "INSERT INTO usuario(usuario, contrasena) VALUES(?, ?)";
		conexion.update(sql, user.getUsuario(), user.getContrasena());
	}*/
	
	/*public boolean autenticaor(String usuario, String passwd) {
		String sql = "SELECT COUNT(*)\r\n" + 
				"FROM usuarios \r\n" + 
				"WHERE correo_usuario = ? AND `contrasenia`=? AND activo=1";
		
		return conexion.queryForObject(sql, Integer.class, usuario, passwd) != 0;
	}

	//create
	public void crearUsuario( String correo, String contrasena,String nombre) {
		String sql = "INSERT INTO usuarios (correo_usuario, contrasenia, nombre_usuario) VALUES (?, ?, ?)";
		conexion.update(sql, correo,contrasena, nombre);
	}
	
	//obtener info individual 
		public Usuario obtenerId(String correo) {
		String sql = "SELECT * FROM usuarios WHERE correo_usuario = ?";
		return conexion.queryForObject(sql,new UsuarioRM(), correo);
	}*/
		
	public Usuario autenticar2(String username, String password) {
		String sql = "SELECT * FROM usuario WHERE UserName=? AND Contrasena=?";
		return conexion.queryForObject(sql,new UsuarioRM(), username, password);
	}
	
	public void crearUsuario(String userName, String nombreCompleto, String correo, int idRol, String contrasena, int estado) {
	    String sql = "INSERT INTO usuario (UserName, NombreCompleto, Correo, IdRol, Contrasena, estado) VALUES (?, ?, ?, ?, ?, ?)";
	    conexion.update(sql, userName, nombreCompleto, correo, idRol, contrasena, estado);
	}
	
	// obtener numero total de clientes activos (no borrados)
	public int numTotalUsuarios() {
		String sql = "SELECT COUNT(*) as total_usuarios \r\n" + 
				"FROM usuario \r\n" + 
				"WHERE activo = 1;";
		return conexion.queryForObject(sql, Integer.class);
	}
				
	// obtener numero de clientes activos (estado === 1)
	public int numUsuariossActivos() {
	    String sql = "SELECT COUNT(*) as total_usuarios "
	                 + "FROM usuario "
		                + "WHERE activo = 1 AND Estado = 1;";
	    return conexion.queryForObject(sql, Integer.class);
	}
				
	// obtener el numerod e clintes borrados 
	public int numUsuariosBorrados() {
	    String sql = "SELECT COUNT(*) as total_usuarios "
	                 + "FROM usuario "
	                 + "WHERE activo = 0;";
		   return conexion.queryForObject(sql, Integer.class);
	}
				
	// retorna el nombre del ultimo cliente que se registro
	public String nombreUsuarioReciente() {
	    String sql = "SELECT u.UserName "
	                 + "FROM usuario u "
	                 + "WHERE FechaRegistro = (SELECT MAX(FechaRegistro) FROM usuario);";
	    return conexion.queryForObject(sql, String.class);
	}
	
	public List<NombreIdUsuarioDTO> consultarNombreIdUsuario() {
	    String sql = "select IdUsuario, UserName from usuario;";
	    return conexion.query(sql, new NombreIdUsuarioDTORM());
	}

}
