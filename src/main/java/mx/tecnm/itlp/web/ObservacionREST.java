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

import mx.tecnm.itlp.bd.ObservacionJDBC;
import mx.tecnm.itlp.models.ClienteDTO;
import mx.tecnm.itlp.models.Observacion;

@RestController
@RequestMapping("/observaciones")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ObservacionREST {
	
	@Autowired
	ObservacionJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> recuperarObservaciones(@RequestParam int id){
		List<Observacion> resultado = null;
		resultado = repo.recuperarObservaciones(id);
		return new ResponseEntity<List<Observacion>>(resultado, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> crearObservacion(@RequestParam int IdUsuario, @RequestParam int IdServicio, @RequestParam String Observacion) {
		try {
		repo.crearObservacion(IdUsuario, IdServicio, Observacion);
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@GetMapping("/numeroObservacionesNoVisto")
    public ResponseEntity<?> numeroObservacionesNoVisto(@RequestParam int IdServicio) {
        int resultado = repo.numeroObservacionesNoVisto(IdServicio);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
	
	@PutMapping("/observacionVisto")
	public ResponseEntity<?> observacionVisto(@RequestParam int IdServicio) {
		try {
		repo.observacionVisto(IdServicio);
		return new ResponseEntity<ClienteDTO>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
//	
//	@GetMapping("borrar/{id}")
//	public ResponseEntity<?> desactivarUsuario(@PathVariable int id) {
//		try {
//		repo.desactivarCliente(id);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//		} catch (Exception e) {
//		e.printStackTrace();
//        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//	}
	
}
 