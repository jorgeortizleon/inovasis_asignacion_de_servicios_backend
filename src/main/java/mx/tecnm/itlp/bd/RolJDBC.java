package mx.tecnm.itlp.bd;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Rol;

@Repository
public class RolJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	//read
	public List<Rol> recuperarRoles(){
		String sql = "select IdRol, Descripcion, FechaRegistro from rol;";
		return conexion.query(sql, new RolRM());
	}
	
	//Create
	public void crearRol(String Nombre ) {
		String sql = "INSERT INTO rol( Descripcion) VALUES(?);";
		conexion.update(sql, Nombre);
	}
	
	// obtener el numerod e roles borraos 
	public int numRoles() {
	    String sql = "select COUNT(*) from rol;";
	    return conexion.queryForObject(sql, Integer.class);
	}
	
	// retorna el nombre del ultimo rol creado
	public String ultimoRolAgregado() {
	    String sql = "SELECT Descripcion "
	                 + "FROM rol "
	                 + "WHERE FechaRegistro = (SELECT MAX(FechaRegistro) FROM rol);";
	    return conexion.queryForObject(sql, String.class);
	}
	
	// obtener nombre de un rol
	public String nombreRol(int id) {
		String sql = "select Descripcion from rol where IdRol=?;";
		return conexion.queryForObject(sql, String.class, id);
	}
	
	// retorna el id del ultimo rol creado
	public int ultimoRolAgregadoId() {
		   String sql = "select MAX(IdRol) from rol;";
		   return conexion.queryForObject(sql, Integer.class);
	}
			
}
