package mx.tecnm.itlp.bd;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.CheckboxServicio;
import mx.tecnm.itlp.models.CrearServicioDTO;
import mx.tecnm.itlp.models.Notificacion;
import mx.tecnm.itlp.models.ServicioDTO;
import mx.tecnm.itlp.models.UsuarioTable;

@Repository
public class ServicioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ServicioJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	//read
	public List<ServicioDTO> recuperarServiciosTabla(){

		String sql = "SELECT s.IdServicio, s.CodigoServicio, c.Codigo, c.RazonSocial, u.NombreCompleto AS UsuarioCreado, nc.NombreCompleto AS UsuarioAsignado, s.Fecha, s.tituloservicio, IFNULL(es.descripcion, 'Inicio') AS Estado, s.Descripcion, s.Factura, s.HojaServicio, s.HojaRemision, s.EmpresaPoliza \r\n" + 
				"FROM servicio s \r\n" + 
				"LEFT JOIN cliente c ON s.IdCliente = c.IdCliente \r\n" +
				"LEFT JOIN usuario u ON s.IdUsuario = u.IdUsuario \r\n" +
				"LEFT JOIN usuario nc ON s.IdUAsignado = nc.IdUsuario \r\n" +
				"LEFT JOIN estadoservicio e ON s.IdEstadoServicio = e.IdEstadoServicio \r\n" +
				"LEFT JOIN \r\n" +
				"( \r\n" +
				"SELECT hs.IdServicio, MAX(hs.fechacambio) AS UltimaFechaCambio \r\n" +
				"FROM historialservicio hs \r\n" +
				"GROUP BY hs.IdServicio \r\n" +
				") AS ultima_fecha \r\n" +
				"ON s.IdServicio = ultima_fecha.IdServicio \r\n" +
				"LEFT JOIN historialservicio hs \r\n" +
				"ON s.IdServicio = hs.IdServicio AND ultima_fecha.UltimaFechaCambio = hs.fechacambio \r\n" +
				"LEFT JOIN estadoservicio es \r\n" +
				"ON hs.IdEstadoServicio = es.IdEstadoServicio ORDER BY s.IdServicio DESC;";
		return conexion.query(sql, new ServicioDTORM());
	}
	
	//Create
	public void crearServicio(CrearServicioDTO crearserviciodto) {
		String sql = "INSERT INTO servicio(IdUsuario, IdUAsignado,IdCliente, Factura, HojaServicio, Descripcion, HojaRemision, EmpresaPoliza, TituloServicio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		conexion.update(sql, crearserviciodto.getIdUsuario(), crearserviciodto.getIdUAsignado(), crearserviciodto.getIdCliente(), crearserviciodto.getFactura(), crearserviciodto.getHojaServicio(), crearserviciodto.getDescripcion(), crearserviciodto.getHojaRemision(), crearserviciodto.getEmpresaPoliza(), crearserviciodto.getTituloServicio() );
	}
	
	public void crearServicio2(int IdUsuario, int IdUAsignado,int IdCliente, int Factura, int HojaServicio, String Descripcion, int HojaRemision, int EmpresaPoliza, String TituloServicio) {
		String sql = "INSERT INTO servicio(IdUsuario, IdUAsignado,IdCliente, Factura, HojaServicio, Descripcion, HojaRemision, EmpresaPoliza, TituloServicio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		conexion.update(sql, IdUsuario, IdUAsignado,IdCliente, Factura, HojaServicio, Descripcion, HojaRemision, EmpresaPoliza, TituloServicio );
	}
	
	public ServicioDTO obtenerServicioPorId(int id) {
	    String sql = "SELECT s.IdServicio, s.CodigoServicio, c.Codigo, c.RazonSocial, u.NombreCompleto AS UsuarioCreado, nc.NombreCompleto AS UsuarioAsignado, s.Fecha, s.tituloservicio, IFNULL(es.descripcion, 'Inicio') AS Estado, s.Descripcion, s.Factura, s.HojaServicio, s.HojaRemision, s.EmpresaPoliza " +
	                 "FROM servicio s " +
	                 "LEFT JOIN cliente c ON s.IdCliente = c.IdCliente " +
	                 "LEFT JOIN usuario u ON s.IdUsuario = u.IdUsuario " +
	                 "LEFT JOIN usuario nc ON s.IdUAsignado = nc.IdUsuario " +
	                 "LEFT JOIN estadoservicio e ON s.IdEstadoServicio = e.IdEstadoServicio " +
	                 "LEFT JOIN ( " +
	                 "    SELECT hs.IdServicio, MAX(hs.fechacambio) AS UltimaFechaCambio " +
	                 "    FROM historialservicio hs " +
	                 "    GROUP BY hs.IdServicio " +
	                 ") AS ultima_fecha " +
	                 "ON s.IdServicio = ultima_fecha.IdServicio " +
	                 "LEFT JOIN historialservicio hs " +
	                 "ON s.IdServicio = hs.IdServicio AND ultima_fecha.UltimaFechaCambio = hs.fechacambio " +
	                 "LEFT JOIN estadoservicio es " +
	                 "ON hs.IdEstadoServicio = es.IdEstadoServicio " +
	                 "WHERE s.IdServicio = ?"; // Agrega la cláusula WHERE para filtrar por ID
	                 
	    return conexion.queryForObject(sql, new Object[]{id}, new ServicioDTORM());
	}
	// Método para insertar observaciones en un servicio por su ID
	public void insertarObservacion(int idServicio, String observaciones) {
	    String sql = "UPDATE servicio SET Observaciones = ? WHERE IdServicio = ?";
	    conexion.update(sql, observaciones, idServicio);
	}

	public String obtenerObservacionesPorIdServicio(int idServicio) {
	    String sql = "SELECT Observaciones FROM servicio WHERE IdServicio = ?";
	    try {
	        return conexion.queryForObject(sql, new Object[]{idServicio}, String.class);
	    } catch (EmptyResultDataAccessException e) {
	        // En caso de que el servicio no tenga observaciones o no exista
	        return "";
	    }
	}
	
	// retorna el id del ultimo servicio creado
	public int ultimoServicioAgregadoId() {
		String sql = "select MAX(IdServicio) from servicio;";
		return conexion.queryForObject(sql, Integer.class);
	}
	
	//regresar facturacion, las hojas y remision
	public CheckboxServicio obtenerCheckboxServicio(int id) {
	    String sql = "select Factura, HojaServicio, HojaRemision, EmpresaPoliza from servicio where IdServicio = ?;";  
	    return conexion.queryForObject(sql, new CheckboxServicioRM(), id);
	}
	
	// retorna la descripcion de un servicio
	public String descripcionServicio(int id) {
		String sql = "select Descripcion from servicio where IdServicio=?;";
		return conexion.queryForObject(sql, String.class, id);
	}
	
	// Método para crear una notificación
	public void crearNotificacion(int usuarioId, String contenido, int servicioId) {
	    String sql = "INSERT INTO notificaciones(usuario_id, contenido, servicio_id) VALUES(?, ?, ?);";
	    conexion.update(sql, usuarioId, contenido, servicioId);
	}
	
	public void marcarNotificacionComoLeida(int idNotificacion) {
	    String sql = "UPDATE notificaciones SET leida = 1 WHERE idnotificaciones = ?;";
	    conexion.update(sql, idNotificacion);
	}
	public List<Notificacion> getNotificacionesNoLeidasPorUsuario(int IdUAsignado) {
	    String sql = "SELECT * FROM notificaciones WHERE usuario_id = ? AND leida = 0";
	    List<Notificacion> notificaciones = conexion.query(sql, new BeanPropertyRowMapper<>(Notificacion.class), IdUAsignado);
	    return notificaciones;
	}
	
	public String getTituloServicio(int servicioId) {
	    String sql = "SELECT TituloServicio FROM servicio WHERE IdServicio = ?";
	    try {
	        return jdbcTemplate.queryForObject(sql, String.class, servicioId);
	    } catch (Exception e) {
	        throw new RuntimeException("Error al obtener el título del servicio", e);
	    }
	}

	// agregar o editar los requisitos
		public void editarRequsitos(int Factura, int HojaServicio, int HojaRemision, int EmpresaPoliza, int idServicio ) {
		    String sql = "UPDATE servicio SET Factura = ?, HojaServicio = ?, hojaRemision = ?, EmpresaPoliza = ? WHERE IdServicio = ?;";
		    conexion.update(sql, Factura, HojaServicio, HojaRemision, EmpresaPoliza, idServicio);
		}
		public List<ServicioDTO> recuperarServiciosPorFecha(String fecha) {
		    try {
		        LocalDate fechaFormateada = LocalDate.parse(fecha);

		        String sql = "SELECT s.IdServicio, s.CodigoServicio, c.Codigo, c.RazonSocial, u.NombreCompleto AS UsuarioCreado, nc.NombreCompleto AS UsuarioAsignado, s.Fecha, s.tituloservicio, IFNULL(es.descripcion, 'Inicio') AS Estado, s.Descripcion, s.Factura, s.HojaServicio, s.HojaRemision, s.EmpresaPoliza " +
		                     "FROM servicio s " +
		                     "LEFT JOIN cliente c ON s.IdCliente = c.IdCliente " +
		                     "LEFT JOIN usuario u ON s.IdUsuario = u.IdUsuario " +
		                     "LEFT JOIN usuario nc ON s.IdUAsignado = nc.IdUsuario " +
		                     "LEFT JOIN estadoservicio e ON s.IdEstadoServicio = e.IdEstadoServicio " +
		                     "LEFT JOIN ( " +
		                     "    SELECT hs.IdServicio, MAX(hs.fechacambio) AS UltimaFechaCambio " +
		                     "    FROM historialservicio hs " +
		                     "    GROUP BY hs.IdServicio " +
		                     ") AS ultima_fecha " +
		                     "ON s.IdServicio = ultima_fecha.IdServicio " +
		                     "LEFT JOIN historialservicio hs " +
		                     "ON s.IdServicio = hs.IdServicio AND ultima_fecha.UltimaFechaCambio = hs.fechacambio " +
		                     "LEFT JOIN estadoservicio es " +
		                     "ON hs.IdEstadoServicio = es.IdEstadoServicio " +
		                     "WHERE DATE(s.Fecha) = ? " +
		                     "ORDER BY s.IdServicio DESC;";

		        return conexion.query(sql, new ServicioDTORM(), fechaFormateada);
		    } catch (DateTimeParseException e) {
		        throw new RuntimeException("Formato de fecha incorrecto. Utiliza 'yyyy-MM-dd'.", e);
		    } catch (Exception e) {
		        throw new RuntimeException("Error al recuperar servicios por fecha.", e);
		    }
		}

			
}
