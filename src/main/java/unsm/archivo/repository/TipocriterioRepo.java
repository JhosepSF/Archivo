package unsm.archivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Tipocriterio;

public interface TipocriterioRepo extends JpaRepository<Tipocriterio, Integer>
{
	List<Tipocriterio> findBySubcriteryid(Tipocriterio criterio);
}
