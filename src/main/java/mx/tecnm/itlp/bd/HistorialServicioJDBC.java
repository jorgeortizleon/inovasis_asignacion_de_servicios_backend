package mx.tecnm.itlp.bd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.CrearHistorialServicioDTO;
import mx.tecnm.itlp.models.HistorialServicio;
import mx.tecnm.itlp.models.TiempoServicio;

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
	public TiempoServicio calcularTiempoServicio(int idServicio) {
        String sql = "SELECT IdServicio, MIN(FechaCambio) AS FechaInicio, MAX(FechaCambio) AS FechaFinalizacion, " +
                     "SUM(TIME_TO_SEC(TIMEDIFF(ProximaFechaCambio, FechaCambio))) AS TiempoTotal " +
                     "FROM (SELECT IdServicio, FechaCambio, LEAD(FechaCambio) OVER (PARTITION BY IdServicio ORDER BY FechaCambio) AS ProximaFechaCambio, IdEstadoServicio " +
                     "FROM historialservicio WHERE IdServicio = ?) AS Subconsulta " +
                     "WHERE IdEstadoServicio = 3 GROUP BY IdServicio";

        return conexion.queryForObject(sql, new Object[]{idServicio}, (resultSet, rowNum) -> {
            TiempoServicio tiempoServicio = new TiempoServicio();
            tiempoServicio.setIdServicio(resultSet.getInt("IdServicio"));
            tiempoServicio.setFechaInicio(resultSet.getTimestamp("FechaInicio").toLocalDateTime());
            tiempoServicio.setFechaFinalizacion(resultSet.getTimestamp("FechaFinalizacion").toLocalDateTime());
            tiempoServicio.setTiempoTotal(resultSet.getInt("TiempoTotal"));
            return tiempoServicio;
        });
    }
	
}
