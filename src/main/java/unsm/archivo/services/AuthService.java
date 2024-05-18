package unsm.archivo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.proyecto.marketin.controller.AuthResponse;

import unsm.archivo.repository.usuarioRepo;
import unsm.archivo.request.LoginRequest;
import unsm.archivo.entitys.usuario;

@Service
public class AuthService 
{	
	private usuarioRepo usuario;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;

	public AuthResponse login(LoginRequest request) 
	{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		usuario usua = usuario.findByUsername(request.getUsername());
		AuthResponse authResponse = new AuthResponse();
	    authResponse.setToken(jwtService.getToken((UserDetails) usua));
	    return authResponse; 
	}
}