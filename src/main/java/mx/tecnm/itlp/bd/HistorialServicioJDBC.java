package mx.tecnm.itlp.bd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.CrearHistorialServicio;

@Repository
public class HistorialServicioJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	
	
}
