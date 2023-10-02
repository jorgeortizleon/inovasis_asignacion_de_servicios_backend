package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.CrearServicioDTO;

public class CrearServicioDTORM implements RowMapper<CrearServicioDTO>{

	@Override
	public CrearServicioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CrearServicioDTO crearserviciodto = new CrearServicioDTO();
		crearserviciodto.setIdUsuario(rs.getInt("IdUsuario"));
		crearserviciodto.setIdUAsignado(rs.getInt("IdUAsignado"));
		crearserviciodto.setIdCliente(rs.getInt("IdCliente"));
		crearserviciodto.setFactura(rs.getInt("Factura"));
		crearserviciodto.setHojaServicio(rs.getInt("HojaServicio"));
		crearserviciodto.setDescripcion(rs.getString("Descripcion"));
		crearserviciodto.setHojaRemision(rs.getInt("HojaRemision"));
		crearserviciodto.setEmpresaPoliza(rs.getInt("EmpresaPoliza"));
		crearserviciodto.setTituloServicio(rs.getString("TituloServicio"));
		return crearserviciodto;
	}
}
