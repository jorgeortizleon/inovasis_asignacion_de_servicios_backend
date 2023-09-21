package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Permiso;

public class PermisoRM implements RowMapper<Permiso>{

    @Override
    public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Permiso permiso = new Permiso();
    	permiso.setIdPermiso(rs.getInt("IdPermiso"));
    	permiso.setIdRol(rs.getInt("IdRol"));
    	permiso.setNombreMenu(rs.getString("NombreMenu"));
    	permiso.setEstado(rs.getInt("Estado"));
    	permiso.setFechaRegistro(rs.getString("FechaRegistro"));
        return permiso;
    }
}
