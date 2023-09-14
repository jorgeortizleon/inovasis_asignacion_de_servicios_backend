package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Cliente;
import mx.tecnm.itlp.models.ClienteDTO;

@Repository
public class ClienteJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//read
	public List<Cliente> recuperarClientes(){
		String sql = "select * from cliente where Activo = 1 ";
		return conexion.query(sql, new ClienteRM());
	}
	
	//Create
	public void crearCliente(ClienteDTO clientedto) {
		String sql = "INSERT INTO cliente(Codigo, RazonSocial, Correo, Telefono, Estado) VALUES(?, ?, ?, ?, ?);";
		conexion.update(sql, clientedto.getCodigo(), clientedto.getRazonSocial(), clientedto.getCorreo(), clientedto.getTelefono(), clientedto.getEstado() );
	}
	
	//delete
	public void desactivarCliente(int id) {
		String sql = "update cliente set activo = 0 WHERE IdCliente = ?";
		conexion.update(sql,id);
	}
	
	//update
	public void modificarCliente(ClienteDTO clientedto, int id) {
		String sql = "UPDATE cliente SET Codigo = ?, RazonSocial = ?, Correo = ?, Telefono = ?, Estado = ? WHERE IdCliente = ?;";
		conexion.update(sql, clientedto.getCodigo(), clientedto.getRazonSocial(), clientedto.getCorreo(), clientedto.getTelefono(), clientedto.getEstado(), id );
	}
		
	// obtener numero total de clientes activos (no borrados)
	public int numTotalClientes() {
		String sql = "SELECT COUNT(*) as total_clientes \r\n" + 
				"FROM cliente \r\n" + 
				"WHERE activo = 1;";
		return conexion.queryForObject(sql, Integer.class);
	}
	
	// obtener numero de clientes activos (estado === 1)
	public int numClientesActivos() {
	    String sql = "SELECT COUNT(*) as total_clientes "
	                 + "FROM cliente "
	                 + "WHERE activo = 1 AND estado = 1;";
	    return conexion.queryForObject(sql, Integer.class);
	}
	
	// obtener el numerod e clintes borrados 
	public int numClientesBorrados() {
	    String sql = "SELECT COUNT(*) as total_clientes "
	                 + "FROM cliente "
	                 + "WHERE activo = 0;";
	    return conexion.queryForObject(sql, Integer.class);
	}
	
	// retorna el nombre del ultimo cliente que se registro
	public String razonsocialClienteReciente() {
	    String sql = "SELECT c.RazonSocial "
	                 + "FROM cliente c "
	                 + "WHERE FechaRegistro = (SELECT MAX(FechaRegistro) FROM cliente);";
	    return conexion.queryForObject(sql, String.class);
	}
			
}
