package unsm.archivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.usuario;

public interface usuarioRepo extends JpaRepository<usuario, Integer>
{
	public usuario findByUsername (String name);
	public usuario findByIdUser (Integer iduser);
}
