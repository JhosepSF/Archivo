package unsm.archivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Documento;

public interface Documentorepo extends JpaRepository<Documento, Integer>
{

}
