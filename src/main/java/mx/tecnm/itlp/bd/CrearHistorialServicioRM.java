package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.CrearHistorialServicio;

public class CrearHistorialServicioRM implements RowMapper<CrearHistorialServicio>{

	@Override
	public CrearHistorialServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		CrearHistorialServicio crearhistorialservicio = new CrearHistorialServicio();
		crearhistorialservicio.setIdServicio(rs.getInt("IdServicio"));
		crearhistorialservicio.setIdUsuario(rs.getInt("IdUsuario"));
		crearhistorialservicio.setIdEstadoServicio(rs.getInt("IdEstadoServicio"));
		crearhistorialservicio.setDescripcionCambio(rs.getString("DescripcionCambio"));
		return crearhistorialservicio;
	}
	
	
	
}
