package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.NombreIdClienteDTO;

public class NombreIdClienteDTORM implements RowMapper<NombreIdClienteDTO>{

	@Override
	public NombreIdClienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NombreIdClienteDTO clientedto = new NombreIdClienteDTO();
		clientedto.setIdCliente(rs.getInt("IdCliente"));
		clientedto.setRazonSocial(rs.getString("RazonSocial"));
		return clientedto;
	}
}
