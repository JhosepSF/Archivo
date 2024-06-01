package unsm.archivo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>
{
	Optional <Usuario> findByUsername (String username);
}
