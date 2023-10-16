package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.itlp.models.CheckboxServicio;

public class CheckboxServicioRM implements RowMapper<CheckboxServicio>{

	@Override
	public CheckboxServicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		CheckboxServicio checkboxservicio = new CheckboxServicio();
		checkboxservicio.setFactura(rs.getInt("Factura"));
		checkboxservicio.setHojaServicio(rs.getInt("HojaServicio"));
		checkboxservicio.setHojaRemision(rs.getInt("HojaRemision"));
		checkboxservicio.setEmpresaPoliza(rs.getInt("EmpresaPoliza"));
		return checkboxservicio;
	}
	
	
	
}
