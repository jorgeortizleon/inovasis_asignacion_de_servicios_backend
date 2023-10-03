package mx.tecnm.itlp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.bd.HistorialServicioJDBC;
import mx.tecnm.itlp.models.CrearHistorialServicioDTO;
import mx.tecnm.itlp.models.HistorialServicio;


@RestController
@RequestMapping("/historialServicio")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class HistorialServicioREST {
	
	@Autowired
	HistorialServicioJDBC repo;
	

	@PostMapping
	public ResponseEntity<?> CrearHistorialServicio(@RequestBody CrearHistorialServicioDTO crearhistorialservicio) {
		try {
		repo.CrearHistorialServicio(crearhistorialservicio);
		return new ResponseEntity<CrearHistorialServicioDTO>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@PostMapping("/crear")
	public ResponseEntity<?> CrearHistorialServicio2(@RequestParam int IdServicio, @RequestParam int IdUsuario, @RequestParam int IdEstadoServicio, @RequestParam String DescripcionCambio) {
		try {
		repo.CrearHistorialServicio2(IdServicio, IdUsuario, IdEstadoServicio, DescripcionCambio);
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@GetMapping
	public ResponseEntity<?> recuperarHistorialServicio(@RequestParam int idServicio){
		List<HistorialServicio> resultado = null;
		resultado = repo.recuperarHistorialServicio(idServicio);
		return new ResponseEntity<List<HistorialServicio>>(resultado, HttpStatus.OK);
	}
	
}
 