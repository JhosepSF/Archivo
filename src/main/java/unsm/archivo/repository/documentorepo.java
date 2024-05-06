package unsm.archivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.documentos;

public interface documentorepo extends JpaRepository<documentos, Integer>
{

}
