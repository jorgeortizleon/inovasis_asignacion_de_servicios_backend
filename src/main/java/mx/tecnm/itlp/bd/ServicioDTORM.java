package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.ServicioDTO;

public class ServicioDTORM implements RowMapper<ServicioDTO>{

	@Override
	public ServicioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServicioDTO serviciodto = new ServicioDTO();
		serviciodto.setIdServicio(rs.getInt("IdServicio"));
		serviciodto.setCodigoServicio(rs.getString("CodigoServicio"));
		serviciodto.setCodigoCliente(rs.getString("Codigo"));
		serviciodto.setRazonSocial(rs.getString("RazonSocial"));
		serviciodto.setUsuarioCreado(rs.getString("UsuarioCreado"));
		serviciodto.setUsuarioAsignado(rs.getString("UsuarioAsignado"));
		serviciodto.setFecha(rs.getString("Fecha"));
		serviciodto.setTituloservicio(rs.getString("tituloservicio"));
		serviciodto.setEstado(rs.getString("Estado"));
		serviciodto.setDescripcion(rs.getString("Descripcion"));
		serviciodto.setHojaServicio(rs.getInt("HojaServicio"));
		serviciodto.setHojaRemision(rs.getInt("HojaRemision"));
		serviciodto.setFactura(rs.getInt("Factura"));
		serviciodto.setEmpresaPoliza(rs.getInt("EmpresaPoliza"));
		return serviciodto;
	}
	
	
	
}
