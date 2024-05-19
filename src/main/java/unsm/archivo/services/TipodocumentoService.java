package unsm.archivo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unsm.archivo.entitys.Tipodoc;
import unsm.archivo.repository.TipodocRepo;
import unsm.archivo.request.TipodocRequest;

@Service
public class TipodocumentoService 
{
    @Autowired
    TipodocRepo tipodocRepo;
    
    public void nuevoTipodoc(TipodocRequest tipodoc)
    {
        Tipodoc tipo = new Tipodoc();
        tipo.setTiponame(tipodoc.getTiponame());

        tipodocRepo.save(tipo);
    }

    public List<Tipodoc> verTipodoc()
    {
        return tipodocRepo.findAll();
    }

    public Tipodoc verUnTipodoc(Integer idtipodoc)
    {
        return tipodocRepo.findById(idtipodoc).get();
    }
}
