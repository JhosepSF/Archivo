package unsm.archivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Documento;

public interface DocumentoRepo extends JpaRepository<Documento, Integer>
{

}
