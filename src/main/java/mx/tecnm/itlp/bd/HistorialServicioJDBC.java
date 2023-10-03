package mx.tecnm.itlp.bd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.CrearHistorialServicioDTO;
import mx.tecnm.itlp.models.HistorialServicio;

@Repository
public class HistorialServicioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//Create
	public void CrearHistorialServicio(CrearHistorialServicioDTO crearhistorialservicio) {
		String sql = "INSERT INTO historialservicio(IdServicio, IdUsuario, IdEstadoServicio, DescripcionCambio) VALUES(?, ?, ?, ?);";
		conexion.update(sql, crearhistorialservicio.getIdServicio(), crearhistorialservicio.getIdUsuario(), crearhistorialservicio.getIdEstadoServicio(), crearhistorialservicio.getDescripcionCambio());
	}
	
	//Create
	public void CrearHistorialServicio2(int IdServicio, int IdUsuario, int IdEstadoServicio, String DescripcionCambio ) {
		String sql = "INSERT INTO historialservicio(IdServicio, IdUsuario, IdEstadoServicio, DescripcionCambio) VALUES(?, ?, ?, ?);";
		conexion.update(sql, IdServicio, IdUsuario, IdEstadoServicio, DescripcionCambio);
	}
	
	//read
	public List<HistorialServicio> recuperarHistorialServicio(int idServicio){
		String sql = "select h.IdHistorial, u.NombreCompleto, e.Descripcion, h.DescripcionCambio, h.FechaCambio "
                + "from historialservicio h  "
                + "LEFT JOIN estadoservicio e ON h.IdEstadoServicio = e.IdEstadoServicio LEFT JOIN usuario u ON h.IdUsuario = u.IdUsuario where IdServicio = ? ; ";
		return conexion.query(sql, new HistorialServicioRM(), idServicio);
	}
}
