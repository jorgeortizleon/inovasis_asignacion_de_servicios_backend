package mx.tecnm.itlp.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.bd.RolJDBC;
import mx.tecnm.itlp.models.Rol;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class RolREST {
	
	@Autowired
	RolJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> recuperarClientes(){
		List<Rol> resultado = null;
		resultado = repo.recuperarRoles();
		return new ResponseEntity<List<Rol>>(resultado, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> CrearHistorialServicio2(@RequestParam String Nombre) {
		try {
		repo.crearRol(Nombre);
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@GetMapping("/totalRoles")
	public ResponseEntity<?> numRoles() {
	    int totalClientesInactivos = repo.numRoles();
	    return new ResponseEntity<>(totalClientesInactivos, HttpStatus.OK);
	}
	
	@GetMapping("/ultimoRolAgregado")
	public ResponseEntity<?> ultimoRolAgregado() {
	    String razonsocialCliente = repo.ultimoRolAgregado();
	    return new ResponseEntity<>(razonsocialCliente, HttpStatus.OK);
	}
	
	@GetMapping("/nombreRol/{id}")
	public ResponseEntity<?> nombreRol(@PathVariable int id) {
	    String nombrerol = repo.nombreRol(id);
	    return new ResponseEntity<>(nombrerol, HttpStatus.OK);
	}
	
	@GetMapping("/idUltimoRol")
	public ResponseEntity<?> ultimoRolAgregadoId() {
	    int idRol = repo.ultimoRolAgregadoId();
	    return new ResponseEntity<>(idRol, HttpStatus.OK);
	}
	
	 
}
 