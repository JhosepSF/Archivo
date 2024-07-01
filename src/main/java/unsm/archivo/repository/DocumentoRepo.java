package unsm.archivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Documento;
import unsm.archivo.entitys.Tipocriterio;

public interface DocumentoRepo extends JpaRepository<Documento, String>
{
	List<Documento> findByIdtipocriterio(Tipocriterio criterio);
	List<Documento> findByDni(String dni);
}
