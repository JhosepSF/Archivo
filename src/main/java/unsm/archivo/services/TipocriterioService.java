package unsm.archivo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.repository.Tipocriteriorepo;
import unsm.archivo.request.Tipocriteriorequest;

public class TipocriterioService 
{
    @Autowired
    Tipocriteriorepo tipocriteriorepo;

    public void nuevoTipocriterio(Tipocriteriorequest tipocriterio)
    {
        Tipocriterio criterio = new Tipocriterio();
        criterio.setCriteryname(tipocriterio.getCriteryname());

        if (tipocriterio.getSubcriteryid() != null && tipocriterio.getSubcriteryid() != 0)
        {
            Tipocriterio subcritery = tipocriteriorepo.findById(tipocriterio.getSubcriteryid()).get();
            criterio.setSubcriteryid(subcritery);
        }
        else
        {
            criterio.setSubcriteryid(null);
        }
        
        tipocriteriorepo.save(criterio);
    }

    public List<Tipocriterio> getTipocriterios()
    {
        return tipocriteriorepo.findAll();
    }
    
    public Tipocriterio VerUnTipoCriterio(Integer id)
    {
        return tipocriteriorepo.findById(id).get();
    }
}
