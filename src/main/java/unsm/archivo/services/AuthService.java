package unsm.archivo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import unsm.archivo.repository.UsuarioRepo;
import unsm.archivo.request.AuthResponse;
import unsm.archivo.request.LoginRequest;
import unsm.archivo.entitys.Usuario;


@Service
public class AuthService 
{	
	private UsuarioRepo usuario;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;

	public AuthResponse login(LoginRequest request) 
	{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		Usuario usua = usuario.findByUsername(request.getUsername()).orElseThrow();
		AuthResponse authResponse = new AuthResponse();
	    authResponse.setToken(jwtService.getToken((UserDetails) usua));
	    return authResponse; 
	}
}
