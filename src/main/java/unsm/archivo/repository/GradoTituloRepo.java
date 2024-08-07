package unsm.archivo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import unsm.archivo.entitys.GradoTitulo;
import unsm.archivo.entitys.Resolucion;

public interface GradoTituloRepo extends PagingAndSortingRepository<GradoTitulo, Integer>
{
	List<GradoTitulo> findByIdresolucion(Resolucion resolucion);

    void save(GradoTitulo grado);

    Optional<GradoTitulo> findById(Integer idgradotitulo);

    List<GradoTitulo> findAll();

    
}
