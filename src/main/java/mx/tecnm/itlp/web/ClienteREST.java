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
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.bd.ClienteJDBC;
import mx.tecnm.itlp.models.Cliente;
import mx.tecnm.itlp.models.ClienteDTO;
import mx.tecnm.itlp.models.NombreIdClienteDTO;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ClienteREST {
	
	@Autowired
	ClienteJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> recuperarClientes(){
		List<Cliente> resultado = null;
		resultado = repo.recuperarClientes();
		return new ResponseEntity<List<Cliente>>(resultado, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> crearCliente(@RequestBody ClienteDTO clientedto) {
		try {
		repo.crearCliente(clientedto);
		return new ResponseEntity<ClienteDTO>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@GetMapping("borrar/{id}")
	public ResponseEntity<?> desactivarUsuario(@PathVariable int id) {
		try {
		repo.desactivarCliente(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
		e.printStackTrace();
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarCliente(@RequestBody ClienteDTO clientedto, @PathVariable int id) {
		try {
		repo.modificarCliente(clientedto, id);
		return new ResponseEntity<ClienteDTO>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@GetMapping("/numTotalClientes")
    public ResponseEntity<?> numTotalClientes() {
        int totalClientes = repo.numTotalClientes();
        return new ResponseEntity<>(totalClientes, HttpStatus.OK);
    }
	
	@GetMapping("/clientesActivos")
	public ResponseEntity<?> clientesActivos() {
	    int totalClientesActivos = repo.numClientesActivos();
	    return new ResponseEntity<>(totalClientesActivos, HttpStatus.OK);
	}
	
	@GetMapping("/clientesBorrados")
	public ResponseEntity<?> clientesInactivos() {
	    int totalClientesInactivos = repo.numClientesBorrados();
	    return new ResponseEntity<>(totalClientesInactivos, HttpStatus.OK);
	}
	
	@GetMapping("/razonsocialClienteReciente")
	public ResponseEntity<?> razonsocialClienteReciente() {
	    String razonsocialCliente = repo.razonsocialClienteReciente();
	    return new ResponseEntity<>(razonsocialCliente, HttpStatus.OK);
	}
	
	@GetMapping("/NombreId")
	public ResponseEntity<?> recuperarNombreIdClientes(){
		List<NombreIdClienteDTO> resultado = null;
		resultado = repo.recuperarNombreIdClientes();
		return new ResponseEntity<List<NombreIdClienteDTO>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/holaServer")
	public String hola() {
		return "Hola mundo desde el Backend de Inovasis";
	}
}
 