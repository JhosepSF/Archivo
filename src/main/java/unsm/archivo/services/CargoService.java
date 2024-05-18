package unsm.archivo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unsm.archivo.entitys.Cargo;
import unsm.archivo.repository.CargoRepo;
import unsm.archivo.request.Cargorequest;

public class CargoService
{
    @Autowired
    CargoRepo cargorepo;

    public void nuevoCargo(Cargorequest cargorequest)
    {
        Cargo cargo = new Cargo();

        cargo.setName(cargorequest.getName());

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