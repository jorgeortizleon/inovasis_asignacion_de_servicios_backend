package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.CrearServicioDTO;
import mx.tecnm.itlp.models.ServicioDTO;

@Repository
public class ServicioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//read
	public List<ServicioDTO> recuperarServiciosTabla(){
		String sql = "SELECT s.IdServicio, s.CodigoServicio, c.RazonSocial, u.UserName AS UsuarioCreado, us.UserName AS UsuarioAsignado, s.Fecha, s.tituloservicio, es.descripcion AS Estado \r\n" + 
				"FROM servicio s \r\n" + 
				"LEFT JOIN cliente c ON s.IdCliente = c.IdCliente \r\n" +
				"LEFT JOIN usuario u ON s.IdUsuario = u.IdUsuario \r\n" +
				"LEFT JOIN usuario us ON s.IdUAsignado = us.IdUsuario \r\n" +
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
				"ON hs.IdEstadoServicio = es.IdEstadoServicio;";
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
			
}
