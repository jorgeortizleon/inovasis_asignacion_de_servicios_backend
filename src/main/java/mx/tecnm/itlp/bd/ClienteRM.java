package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.Cliente;

public class ClienteRM implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(rs.getInt("IdCliente"));
		cliente.setCodigo(rs.getString("Codigo"));
		cliente.setRazonSocial(rs.getString("RazonSocial"));
		cliente.setCorreo(rs.getString("Correo"));
		cliente.setTelefono(rs.getString("Telefono"));
		cliente.setEstado(rs.getInt("Estado"));
		cliente.setFechaRegistro(rs.getString("FechaRegistro"));
		cliente.setActivo(rs.getInt("Activo"));
		return cliente;
	}
	
	
	
}
