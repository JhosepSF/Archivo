package unsm.archivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Cargo;

public interface CargoRepo extends JpaRepository<Cargo, Integer>
{

}
