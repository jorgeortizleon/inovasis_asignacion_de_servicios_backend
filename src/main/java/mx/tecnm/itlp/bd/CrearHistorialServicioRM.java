package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.CrearHistorialServicioDTO;

public class CrearHistorialServicioRM implements RowMapper<CrearHistorialServicioDTO>{

	@Override
	public CrearHistorialServicioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CrearHistorialServicioDTO crearhistorialservicio = new CrearHistorialServicioDTO();
		crearhistorialservicio.setIdServicio(rs.getInt("IdServicio"));
		crearhistorialservicio.setIdUsuario(rs.getInt("IdUsuario"));
		crearhistorialservicio.setIdEstadoServicio(rs.getInt("IdEstadoServicio"));
		crearhistorialservicio.setDescripcionCambio(rs.getString("DescripcionCambio"));
		return crearhistorialservicio;
	}
	
	
	
}
