package unsm.archivo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import unsm.archivo.DTO.UsuarioDTO;
import unsm.archivo.entitys.Cargo;
import unsm.archivo.entitys.Usuario;
import unsm.archivo.repository.CargoRepo;
import unsm.archivo.repository.UsuarioRepo;
import unsm.archivo.request.UsuarioRequest;

@Service
public class UsuarioService 
{
	@Autowired
	UsuarioRepo repousuario;
	
	@Autowired
	CargoRepo repocargo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public void nuevousuario (UsuarioRequest usuario) throws IOException 
	{
		String encoded = passwordEncoder.encode(usuario.getPassword());
		
		Usuario nuevousuario = new Usuario();
		
		nuevousuario.setName(usuario.getName());
		nuevousuario.setLastname(usuario.getLastname());
		nuevousuario.setAddress(usuario.getAddress());
	    nuevousuario.setPhone(usuario.getPhone());
		nuevousuario.setPassword(encoded);
		nuevousuario.setUsername(usuario.getUsername());
		
		Set<Cargo> Cargos = new HashSet<>();
		
		Cargo Cargo = repocargo.findById(usuario.getCargoid())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
		
		Cargos.add(Cargo);
		
		nuevousuario.setCargos(Cargos);
		
		repousuario.save(nuevousuario);
	}
	
	public List<UsuarioDTO> verusuarios () 
	{
		List <Usuario> Usuarios = repousuario.findAll();
		
		List <UsuarioDTO> usuariosdto = new ArrayList<>();
		
		for (Usuario user : Usuarios) 
		{
			String cargoName = "";
		    if (user.getCargos() != null && !user.getCargos().isEmpty()) {
		        Cargo Cargo = user.getCargos().iterator().next();
		        cargoName = Cargo.getName();
		    }
		    
		    UsuarioDTO dto = new UsuarioDTO(
		    								user.getId(),
		    								user.getName(),
		    								user.getLastname(), 
		    								user.getAddress(),
		    								user.getPhone(),
		    								cargoName);
		    usuariosdto.add(dto);
		}
		
		return usuariosdto;
	}
	
	public UsuarioDTO verusuario (Integer id) 
	{
		Usuario user = repousuario.findById(id).orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
		
		String cargoName = "";
	    if (user.getCargos() != null && !user.getCargos().isEmpty()) {
	        Cargo Cargo = user.getCargos().iterator().next();
	        cargoName = Cargo.getName();
	    }
	    
	    UsuarioDTO dto = new UsuarioDTO(
							    		user.getId(),
										user.getName(),
										user.getLastname(), 
										user.getAddress(),
										user.getPhone(),
										cargoName);
		return dto;
	}
	
	public UsuarioDTO findByUsername (String username) 
	{
		Usuario user = repousuario.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("No se encontro al usuario"));
		
		String cargoName = "";
	    if (user.getCargos() != null && !user.getCargos().isEmpty()) {
	        Cargo Cargo = user.getCargos().iterator().next();
	        cargoName = Cargo.getName();
	    }
	    
	    UsuarioDTO dto = new UsuarioDTO(
							    		user.getId(),
										user.getName(),
										user.getLastname(), 
										user.getAddress(),
										user.getPhone(),
										cargoName);
		return dto;
	}
	
	public boolean cambiarContrasena(String username, String newPassword)
	{
		Usuario user = repousuario.findByUsername(username)
				.orElseThrow(()->new RuntimeException("No se encontro al usuario"));
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            repousuario.save(user);
            return true;
        }
        
        return false;
    }
}
