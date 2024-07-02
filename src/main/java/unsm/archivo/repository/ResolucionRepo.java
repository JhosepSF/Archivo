package unsm.archivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Resolucion;
import unsm.archivo.entitys.Tipocriterio;

public interface ResolucionRepo extends JpaRepository<Resolucion, String>
{
	List<Resolucion> findByIdtipocriterio(Tipocriterio criterio);
	Resolucion findByNrodoc(String nrodoc);
}
