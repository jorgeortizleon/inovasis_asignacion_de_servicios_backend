package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.ServicioDTO;

public class ObservacionDTORM implements RowMapper<ServicioDTO>{
	
	
	@Override
	public ServicioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServicioDTO serviciodto = new ServicioDTO();
		serviciodto.setObservaciones(rs.getString("Observaciones"));
		
		return serviciodto;

}

}
