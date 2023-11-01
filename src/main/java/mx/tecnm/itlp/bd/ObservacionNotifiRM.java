package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.ObservacionNotifi;

public class ObservacionNotifiRM implements RowMapper<ObservacionNotifi>{
	
	
	@Override
	public ObservacionNotifi mapRow(ResultSet rs, int rowNum) throws SQLException {
		ObservacionNotifi observacionnotifi = new ObservacionNotifi();
		observacionnotifi.setIdObservacion(rs.getInt("IdObservacion"));
		observacionnotifi.setIdServicio(rs.getInt("IdServicio"));
		observacionnotifi.setIdUsuario(rs.getInt("IdUsuario"));
		observacionnotifi.setObservacion(rs.getString("Observacion"));
		observacionnotifi.setFechaRegistro(rs.getString("FechaRegistro"));
		observacionnotifi.setUserName(rs.getString("UserName"));
		return observacionnotifi;

}

}
