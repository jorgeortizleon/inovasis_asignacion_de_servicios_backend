package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Usuario;

public class UsuarioRM implements RowMapper<Usuario>{

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario user = new Usuario();
        user.setIdUsuario(rs.getInt("IdUsuario"));
        user.setUserName(rs.getString("UserName"));
        user.setNombreCompleto(rs.getString("NombreCompleto"));
        user.setCorreo(rs.getString("Correo"));
        user.setClave(rs.getString("Clave"));
        user.setIdRol(rs.getInt("IdRol"));
        user.setEstado(rs.getInt("Estado"));
        user.setFechaRegistro(rs.getString("FechaRegistro"));
        user.setContrasena(rs.getString("Contrasena"));
        user.setNombreRol(rs.getString("Descripcion")); 
        return user;
    }
}
