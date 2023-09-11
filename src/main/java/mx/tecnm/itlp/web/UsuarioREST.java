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

import mx.tecnm.itlp.bd.UsuarioJDBC;
import mx.tecnm.itlp.models.Usuario;
import mx.tecnm.itlp.models.UsuarioTable;

@RestController
@RequestMapping("/usuarios")

@CrossOrigin(origins = "http://localhost:8080", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class UsuarioREST {
    private final UsuarioJDBC usuarioJDBC; // Agrega esta línea


	@Autowired
	UsuarioJDBC repo;
	public UsuarioREST(UsuarioJDBC usuarioJDBC) { // Agrega este constructor
        this.usuarioJDBC = usuarioJDBC;
    }


	//read
	@GetMapping
	
	public ResponseEntity<?> recuperarUsuarios(){
	    List<UsuarioTable> resultado = repo.consultarUsuariosParaTable();
	    return new ResponseEntity<List<UsuarioTable>>(resultado, HttpStatus.OK);
	}
	/*public ResponseEntity<?> recuperarUsuarios(){
		List<Usuario> resultado = null;
		resultado = repo.consultarUsuarios();
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}*/
	///////////////////////////////////////////////////////////////////////////
	/*@GetMapping("/{id}")
	public ResponseEntity<?> buscarUsuario(@PathVariable int id){
		Usuario resultado = null;
		resultado = repo.buscarUsuario(id);
		return new ResponseEntity<Usuario>(resultado, HttpStatus.OK);
	}*/
	
	/*//"delete"
	@GetMapping("borrar/{id}")
	public ResponseEntity<?> desactivarUsuario(@PathVariable int id) {
		repo.desactivarUsuario(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}*/
	
	/*@PostMapping
	public ResponseEntity<?> agregarUsuario1(@RequestBody Usuario user) {
		repo.agregarUsuario1(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}*/
	
	/*//login
	@PostMapping("/login")
	public ResponseEntity<?> autenticar(@RequestParam String usuario, @RequestParam String passwd){	
		if (repo.autenticar(usuario, passwd)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
	}*/
	
	/*//create
	@PostMapping("/crearusuario")
	public ResponseEntity<?> crearUsuario(@RequestParam String nombre, @RequestParam String correo, @RequestParam String contrasena){	
		repo.crearUsuario(nombre, correo, contrasena);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//obtener info individual
	@GetMapping("/obtenerdatos/{correo}")
	public ResponseEntity<?> obtenerId(@PathVariable String correo){
		Usuario resultado = null;
		resultado = repo.obtenerId(correo);
		return new ResponseEntity<Usuario>(resultado, HttpStatus.OK);
	}*/
	
	 @PostMapping("/login")
		public ResponseEntity<?> autenticar2(@RequestParam String username, @RequestParam String password){	
			try{
	            Usuario usuario = repo.autenticar2(username, password);
				return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
			} catch (Exception e){
				System.out.println(e);
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}	
		}
	 
	 //crear
	 @PostMapping("/crear")
	 public ResponseEntity<Void> crearUsuario(@RequestBody UsuarioTable usuario) {
	     usuarioJDBC.crearUsuario(usuario.getUserName(), usuario.getNombreCompleto(), usuario.getCorreo(), usuario.getIdRol(), usuario.getContrasena());
	     return ResponseEntity.status(HttpStatus.CREATED).build();
	 }
	 
	 //edit
	 @PutMapping("/{id}")
	 public ResponseEntity<Void> editarUsuario(@PathVariable int id, @RequestBody UsuarioTable usuario) {
	     try {
	         // Llama al método editarUsuario de UsuarioJDBC para actualizar el usuario en la base de datos
	         usuarioJDBC.editarUsuario(usuario, id);

	         return ResponseEntity.ok().build();
	     } catch (Exception e) {
	         // Manejo de errores
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }
	 
	 //delate
	 
	 @PutMapping("/borrar/{id}")
	 public ResponseEntity<Void> borrarUsuario(@PathVariable int id) {
	     try {
	         // Marcar al usuario como inactivo (activo=0)
	         usuarioJDBC.marcarUsuarioComoInactivo(id);

	         return ResponseEntity.ok().build();
	     } catch (Exception e) {
	         // Manejo de errores
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }


	 
}
