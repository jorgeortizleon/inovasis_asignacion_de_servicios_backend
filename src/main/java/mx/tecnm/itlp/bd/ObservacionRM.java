package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Observacion;

public class ObservacionRM implements RowMapper<Observacion>{

	@Override
	public Observacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Observacion observacion = new Observacion();
		observacion.setIdObservacion(rs.getInt("IdObservacion"));
		observacion.setNombreCompleto(rs.getString("NombreCompleto"));
		observacion.setObservacion(rs.getString("Observacion"));
		observacion.setFechaRegistro(rs.getString("FechaRegistro"));
		observacion.setVisto(rs.getInt("Visto"));
		return observacion;
	}
}
