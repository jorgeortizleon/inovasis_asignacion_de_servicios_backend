package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.itlp.models.UsuarioTable;

public class UsuarioTableRM implements RowMapper<UsuarioTable> {
    @Override
    public UsuarioTable mapRow(ResultSet rs, int rowNum) throws SQLException {
	 UsuarioTable userTable = new UsuarioTable();
     userTable.setUserName(rs.getString("UserName"));
     userTable.setNombreCompleto(rs.getString("NombreCompleto"));
     userTable.setCorreo(rs.getString("Correo"));
     userTable.setNombreRol(rs.getString("nombreRol"));
     userTable.setEstado(rs.getInt("Estado"));
     userTable.setIdUsuario(rs.getInt("IdUsuario"));
     userTable.setClave(rs.getString("Clave"));
     userTable.setEstado(rs.getInt("Estado"));
     userTable.setFechaRegistro(rs.getString("FechaRegistro"));
     userTable.setContrasena(rs.getString("Contrasena"));
     
     
     
     return userTable;
 }
	

}
