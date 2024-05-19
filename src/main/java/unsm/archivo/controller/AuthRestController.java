package unsm.archivo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import unsm.archivo.request.AuthResponse;
import unsm.archivo.request.LoginRequest;
import unsm.archivo.services.AuthService;

import unsm.archivo.repository.UsuarioRepo;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
	private final AuthService authService;
	private final UsuarioRepo usuarioRepository;
	
	public AuthRestController(AuthService authService, UsuarioRepo usuarioRepository) {
		super();
		this.authService = authService;
		this.usuarioRepository = usuarioRepository;
	}
	
	@PostMapping("/login")
	public ResponseEntity <AuthResponse> login(@RequestBody LoginRequest request){
		return ResponseEntity.ok(authService.login(request));
	}
}
