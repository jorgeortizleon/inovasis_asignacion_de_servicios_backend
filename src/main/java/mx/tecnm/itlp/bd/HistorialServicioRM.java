package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.HistorialServicio;

public class HistorialServicioRM implements RowMapper<HistorialServicio>{

	@Override
	public HistorialServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		HistorialServicio historialservicio = new HistorialServicio();
		historialservicio.setIdHistorial(rs.getInt("IdHistorial"));
		historialservicio.setNombreCompleto(rs.getString("NombreCompleto"));
		historialservicio.setDescripcion(rs.getString("Descripcion"));
		historialservicio.setDescripcionCambio(rs.getString("DescripcionCambio"));
		historialservicio.setFechaCambio(rs.getString("FechaCambio"));
		return historialservicio;
	}
	
}
