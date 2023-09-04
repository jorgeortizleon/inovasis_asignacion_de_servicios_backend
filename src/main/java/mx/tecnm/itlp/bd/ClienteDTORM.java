package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.ClienteDTO;

public class ClienteDTORM implements RowMapper<ClienteDTO>{

	@Override
	public ClienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClienteDTO clientedto = new ClienteDTO();
		clientedto.setCodigo(rs.getString("Codigo"));
		clientedto.setRazonSocial(rs.getString("RazonSocial"));
		clientedto.setCorreo(rs.getString("Correo"));
		clientedto.setTelefono(rs.getString("Telefono"));
		clientedto.setEstado(rs.getInt("Estado"));
		return clientedto;
	}
	
	
	
}
