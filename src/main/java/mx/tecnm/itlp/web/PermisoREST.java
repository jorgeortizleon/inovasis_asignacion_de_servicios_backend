package mx.tecnm.itlp.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.bd.PermisoJDBC;
import mx.tecnm.itlp.models.Permiso;

@RestController
@RequestMapping("/permisos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class PermisoREST {
	
	@Autowired
	PermisoJDBC repo;
	
	@GetMapping("/rol/{id}")
	public ResponseEntity<?> recuperarClientes(@PathVariable int id){
		List<Permiso> resultado = null;
		resultado = repo.recuperarPermisos(id);
		return new ResponseEntity<List<Permiso>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/menuUsuarios/{id}")
	public ResponseEntity<?> permisoMenuUsuarios(@PathVariable int id) {
	    int permisoMenu = repo.permisoMenuUsuarios(id);
	    return new ResponseEntity<>(permisoMenu, HttpStatus.OK);
	}
	
	@GetMapping("/menuServicios/{id}")
	public ResponseEntity<?> permisoMenuServicios(@PathVariable int id) {
	    int permisoMenu = repo.permisoMenuServicios(id);
	    return new ResponseEntity<>(permisoMenu, HttpStatus.OK);
	}
	
	@GetMapping("/menuClientes/{id}")
	public ResponseEntity<?> permisoMenuClientes(@PathVariable int id) {
	    int permisoMenu = repo.permisoMenuClientes(id);
	    return new ResponseEntity<>(permisoMenu, HttpStatus.OK);
	}
	
	@GetMapping("/menuReportes/{id}")
	public ResponseEntity<?> permisoMenuReportes(@PathVariable int id) {
	    int permisoMenu = repo.permisoMenuReportes(id);
	    return new ResponseEntity<>(permisoMenu, HttpStatus.OK);
	}
	
	@GetMapping("/menuConfig/{id}")
	public ResponseEntity<?> permisoMenuConfig(@PathVariable int id) {
	    int permisoMenu = repo.permisoMenuConfig(id);
	    return new ResponseEntity<>(permisoMenu, HttpStatus.OK);
	}
	
	@GetMapping("/menuAcercade/{id}")
	public ResponseEntity<?> permisoMenuAcercade(@PathVariable int id) {
	    int permisoMenu = repo.permisoMenuAcercade(id);
	    return new ResponseEntity<>(permisoMenu, HttpStatus.OK);
	}

}
 