package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Rol;

public class RolRM implements RowMapper<Rol>{

	@Override
	public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
		Rol rol = new Rol();
		rol.setIdRol(rs.getInt("IdRol"));
		rol.setDescripcion(rs.getString("Descripcion"));
		rol.setFechaRegistro(rs.getString("FechaRegistro"));
		return rol;
	}
}
