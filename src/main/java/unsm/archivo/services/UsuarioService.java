package unsm.archivo.services;

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
import unsm.archivo.request.Usuariorequest;

@Service
public class UsuarioService 
{
	@Autowired
	UsuarioRepo repousuario;
	
	@Autowired
	CargoRepo repocargo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public void nuevousuario (Usuariorequest usuario) 
	{
		String encoded = passwordEncoder.encode(usuario.getPassword());
		
		Usuario nuevousuario = new Usuario();
		
		nuevousuario.setName(usuario.getName());
		nuevousuario.setLastname(usuario.getLastname());
		nuevousuario.setAddress(usuario.getAddress());
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
		    								cargoName);
		    usuariosdto.add(dto);
		}
		
		return usuariosdto;
	}
	
	public UsuarioDTO verusuario (Integer iduser) 
	{
		Usuario user = repousuario.findbyIdUser(iduser);
		
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
	    								cargoName);
		return dto;
	}
}
