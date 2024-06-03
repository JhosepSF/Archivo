package unsm.archivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.request.TipocriterioRequest;
import unsm.archivo.services.TipocriterioService;

@RestController
@RequestMapping("/tipocriterio")
public class TipocriterioController
{
    @Autowired
    private TipocriterioService tipocriterioService;

    @GetMapping("/vercriterio/tipocriterios")
    public List<Tipocriterio> getTipocriterios()
    {
        return tipocriterioService.getTipocriterios();
    }

    @GetMapping("/vercriterio/tipocriterio/{id}")
    public Tipocriterio VerUnTipoCriterio(@PathVariable Integer id)
    {
        return tipocriterioService.VerUnTipoCriterio(id);
    }
    
    @GetMapping("/vercriterio/criteriomayor/{id}")
    public List<Tipocriterio> getCriterioMayor(@PathVariable Integer id)
    {
    	return tipocriterioService.getTipocriterioMayor(id);
    }

    @PostMapping("/nuevocriterio")
    public void nuevoCriterio(@RequestBody TipocriterioRequest tipocriterio)
    {
        tipocriterioService.nuevoTipocriterio(tipocriterio);
    }
}
