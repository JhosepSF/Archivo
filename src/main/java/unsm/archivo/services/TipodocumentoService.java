package unsm.archivo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unsm.archivo.entitys.Tipodoc;
import unsm.archivo.repository.Tipodocrepo;
import unsm.archivo.request.Tipodocrequest;

public class TipodocumentoService 
{
    @Autowired
    Tipodocrepo tipodocrepo;
    
    public void nuevoTipodoc(Tipodocrequest tipodoc)
    {
        Tipodoc tipo = new Tipodoc();
        tipo.setTiponame(tipodoc.getTiponame());

        tipodocrepo.save(tipo);
    }

    public List<Tipodoc> verTipodoc()
    {
        return tipodocrepo.findAll();
    }

    public Tipodoc verUnTipodoc(Integer idtipodoc)
    {
        return tipodocrepo.findById(idtipodoc).get();
    }
}
