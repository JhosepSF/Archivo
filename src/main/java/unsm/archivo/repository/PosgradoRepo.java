package unsm.archivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Posgrado;
import unsm.archivo.entitys.Resolucion;

public interface PosgradoRepo extends JpaRepository<Posgrado, Integer>
{
	List<Posgrado> findByIdresolucion(Resolucion resolucion);
}
