package unsm.archivo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unsm.archivo.entitys.Cargo;
import unsm.archivo.repository.CargoRepo;
import unsm.archivo.request.CargoRequest;

@Service
public class CargoService
{
    @Autowired
    CargoRepo cargorepo;

    public void nuevoCargo(CargoRequest cargoRequest)
    {
        Cargo cargo = new Cargo();

        cargo.setName(cargoRequest.getName());

        cargorepo.save(cargo);
    }

    public List<Cargo> vercargos()
    {
        return cargorepo.findAll();
    }

    public Cargo vercargo(Integer id)
    {
        return cargorepo.findById(id).get();
    }
}