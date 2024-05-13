package unsm.archivo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import unsm.archivo.DTO.usuarioDTO;
import unsm.archivo.entitys.cargo;
import unsm.archivo.entitys.usuario;
import unsm.archivo.repository.cargoRepo;
import unsm.archivo.repository.usuarioRepo;
import unsm.archivo.request.usuariorequest;

@Service
public class usuariosService 
{
	@Autowired
	usuarioRepo repousuario;
	
	@Autowired
	cargoRepo repocargo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public void nuevousuario (usuariorequest usuario) 
	{
		String encoded = passwordEncoder.encode(usuario.getPassword());
		
		usuario nuevousuario = new usuario();
		
		nuevousuario.setName(usuario.getName());
		nuevousuario.setLastname(usuario.getLastname());
		nuevousuario.setAddress(usuario.getAddress());
		nuevousuario.setPassword(encoded);
		nuevousuario.setUsername(usuario.getUsername());
		
		Set<cargo> cargos = new HashSet<>();
		
		cargo cargo = repocargo.findById(usuario.getCargoid())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
		
		cargos.add(cargo);
		
		nuevousuario.setCargoid(cargos);
		
		repousuario.save(nuevousuario);
	}
	
	public List<usuarioDTO> verusuarios () 
	{
		List <usuario> usuarios = repousuario.findAll();
		
		List <usuarioDTO> usuariosdto = new ArrayList<>();
		
		for (usuario user : usuarios) 
		{
			String cargoName = "";
		    if (user.getCargoid() != null && !user.getCargoid().isEmpty()) {
		        cargo cargo = user.getCargoid().iterator().next();
		        cargoName = cargo.getName();
		    }
		    
		    usuarioDTO dto = new usuarioDTO(
		    								user.getId(),
		    								user.getName(),
		    								user.getLastname(), 
		    								user.getAddress(), 
		    								cargoName);
		    usuariosdto.add(dto);
		}
		
		return usuariosdto;
	}
	
	public usuarioDTO verusuario (Integer iduser) 
	{
		usuario user = repousuario.findByIdUser(iduser);
		
		String cargoName = "";
	    if (user.getCargoid() != null && !user.getCargoid().isEmpty()) {
	        cargo cargo = user.getCargoid().iterator().next();
	        cargoName = cargo.getName();
	    }
	    
	    usuarioDTO dto = new usuarioDTO(
	    								user.getId(),
	    								user.getName(),
	    								user.getLastname(), 
	    								user.getAddress(), 
	    								cargoName);
		return dto;
	}
}
