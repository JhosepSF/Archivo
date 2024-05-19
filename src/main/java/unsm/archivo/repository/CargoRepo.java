package unsm.archivo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unsm.archivo.entitys.Cargo;

public interface CargoRepo extends JpaRepository<Cargo, Integer>
{
	Optional<Cargo> findByName(String name);
}
