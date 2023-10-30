package mx.tecnm.itlp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import mx.tecnm.itlp.bd.ServicioJDBC;
import mx.tecnm.itlp.models.CheckboxServicio;
import mx.tecnm.itlp.models.CrearServicioDTO;
import mx.tecnm.itlp.models.Notificacion;
import mx.tecnm.itlp.models.ServicioDTO;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ServicioREST {
	
	@Autowired
	ServicioJDBC repo;
	
	 @Autowired
	    private ServicioJDBC servicioJDBC;

	
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
		
		 // Crear una notificación
        String contenidoNotificacion = "Se ha creado un nuevo servicio con ID: " + repo.ultimoServicioAgregadoId();
        int usuarioIdAsignado = IdUAsignado; // Accedes al valor del parámetro IdUAsignado
        int servicioId = repo.ultimoServicioAgregadoId();
        repo.crearNotificacion(usuarioIdAsignado, contenidoNotificacion, servicioId);
       
		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
	     e.printStackTrace();
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerServicioPorId(@PathVariable int id) {
	    ServicioDTO servicio = repo.obtenerServicioPorId(id);
	    
	    if (servicio != null) {
	        return new ResponseEntity<>(servicio, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Servicio no encontrado", HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editarObservacion(@PathVariable int id, @RequestBody ServicioDTO serviciodto) {
	    try {
	        // Llama al método de ServicioJDBC para editar las observaciones
	        repo.insertarObservacion(id, serviciodto.getObservaciones());
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	        // Manejo de errores
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/{id}/observaciones")
	public ResponseEntity<?> obtenerObservaciones(@PathVariable int id) {
	    String observaciones = repo.obtenerObservacionesPorIdServicio(id);

	    if (!observaciones.isEmpty()) {
	        Map<String, String> observacionesMap = new HashMap<>();
	        observacionesMap.put("IdServicio", String.valueOf(id));
	        observacionesMap.put("Observaciones", observaciones);
	        return new ResponseEntity<>(observacionesMap, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Observaciones no encontradas", HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/idUltimoServicio")
	public ResponseEntity<?> ultimoServicioAgregadoId() {
	    int idServicio = repo.ultimoServicioAgregadoId();
	    return new ResponseEntity<>(idServicio, HttpStatus.OK);
	}
	
	@GetMapping("obtenerCheckboxServicio/{id}")
	public ResponseEntity<?> obtenerCheckboxServicio(@PathVariable int id) {
	    CheckboxServicio checkboxservicio = repo.obtenerCheckboxServicio(id);
	    if (checkboxservicio != null) {
	        return new ResponseEntity<>(checkboxservicio, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("descripcionServicio/{id}")
	public ResponseEntity<?> descripcionServicio(@PathVariable int id) {
	    String descripcion = repo.descripcionServicio(id);
	    return new ResponseEntity<>(descripcion, HttpStatus.OK);
	}
	
	@PutMapping("/editarRequisitos")
	public ResponseEntity<?> editarRequsitos(@RequestParam int Factura, @RequestParam int HojaServicio, @RequestParam int HojaRemision, @RequestParam int EmpresaPoliza, @RequestParam int idServicio) {
	    try {
	        repo.editarRequsitos(Factura, HojaServicio, HojaRemision, EmpresaPoliza, idServicio);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}
	@PostMapping("/marcarComoLeida/{idNotificacion}")
    public ResponseEntity<String> marcarNotificacionComoLeida(@PathVariable int idNotificacion) {
        servicioJDBC.marcarNotificacionComoLeida(idNotificacion);
        return new ResponseEntity<>("Notificación marcada como leída.", HttpStatus.OK);
    }
	 
	@GetMapping("/notificaciones/{IdUAsignado}")
	public ResponseEntity<List<Notificacion>> getNotificacionesNoLeidasUsuario(@PathVariable int IdUAsignado) {
	    List<Notificacion> notificaciones = repo.getNotificacionesNoLeidasPorUsuario(IdUAsignado);
	    return new ResponseEntity<>(notificaciones, HttpStatus.OK);
	}
	@GetMapping("/servicio/{servicioId}")
	public ResponseEntity<String> getTituloServicio(@PathVariable int servicioId) {
	    try {
	        String tituloServicio = servicioJDBC.getTituloServicio(servicioId);
	        return new ResponseEntity<>(tituloServicio, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error al obtener el título del servicio", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}



}
 