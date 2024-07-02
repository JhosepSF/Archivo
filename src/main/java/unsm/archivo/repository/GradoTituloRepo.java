package unsm.archivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.GradoTitulo;
import unsm.archivo.entitys.Resolucion;

public interface GradoTituloRepo extends JpaRepository<GradoTitulo, String>
{
	GradoTitulo findByDni(String dni);
	List<GradoTitulo> findByIdresolucion(Resolucion resolucion);
}
