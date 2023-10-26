package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Observacion;

@Repository
public class ObservacionJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//read
	public List<Observacion> recuperarObservaciones(int id){
		String sql = "select o.IdObservacion, u.NombreCompleto, o.observacion, o.FechaRegistro, o.visto \r\n" + 
				"from observacion o \r\n" + 
				"LEFT JOIN usuario u ON o.IdUsuario = u.IdUsuario \r\n" +
				"LEFT JOIN servicio s ON o.IdServicio = s.IdServicio \r\n" +
				"where o.Estado=1 and o.IdServicio=?;";
		return conexion.query(sql, new ObservacionRM(), id);
	}
	
	//Create
	public void crearObservacion(int IdUsuario, int IdServicio, String Observacion) {
		String sql = "INSERT INTO observacion(IdUsuario, IdServicio, Observacion) VALUES(?, ?, ?);";
		conexion.update(sql, IdUsuario, IdServicio, Observacion );
	}
	
	// regresa la cantidad de observaciones aun no vistas
	public int numeroObservacionesNoVisto(int IdServicio) {
	    String sql = "select COUNT(*) from observacion where IdServicio = ? and visto = 0;";
	    return conexion.queryForObject(sql, Integer.class, IdServicio);
	}
	
	//poner en visto las observaciones
		public void observacionVisto(int IdServicio) {
			String sql = "UPDATE observacion SET visto=1 WHERE IdServicio=?;";
			conexion.update(sql, IdServicio );
		}
	
//	//delete
//	public void desactivarCliente(int id) {
//		String sql = "update cliente set activo = 0 WHERE IdCliente = ?";
//		conexion.update(sql,id);
//	}
			
}
