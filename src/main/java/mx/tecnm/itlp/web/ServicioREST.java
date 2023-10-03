package mx.tecnm.itlp.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.bd.ServicioJDBC;
import mx.tecnm.itlp.models.CrearServicioDTO;
import mx.tecnm.itlp.models.ServicioDTO;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ServicioREST {
	
	@Autowired
	ServicioJDBC repo;
	
	@GetMapping
	public ResponseEntity<?> recuperarServiciosTabla(){
		List<ServicioDTO> resultado = null;
		resultado = repo.recuperarServiciosTabla();
		return new ResponseEntity<List<ServicioDTO>>(resultado, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> crearServicio(@RequestBody CrearServicioDTO crearserviciodto) {
		try {
			System.out.println(crearserviciodto.getIdUsuario());
		repo.crearServicio(crearserviciodto);
		return new ResponseEntity<CrearServicioDTO>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@PostMapping("/crear")
	public ResponseEntity<?> crearServicio2(@RequestParam int IdUsuario, @RequestParam int IdUAsignado,@RequestParam int IdCliente, @RequestParam int Factura, @RequestParam int HojaServicio, @RequestParam String Descripcion, @RequestParam int HojaRemision, @RequestParam int EmpresaPoliza, @RequestParam String TituloServicio) {
		try {
		repo.crearServicio2(IdUsuario, IdUAsignado,IdCliente, Factura, HojaServicio, Descripcion, HojaRemision, EmpresaPoliza, TituloServicio);
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
}
 