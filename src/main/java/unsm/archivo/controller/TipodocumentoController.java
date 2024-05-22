package unsm.archivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unsm.archivo.entitys.Tipodoc;
import unsm.archivo.request.TipodocRequest;
import unsm.archivo.services.TipodocumentoService;

@RestController
@RequestMapping("/tipodocumento")
public class TipodocumentoController
{
    @Autowired
    TipodocumentoService tipodoc;
    
    @GetMapping("/tipodocumentos")
    public List<Tipodoc> getTipocriterios()
    {
        return tipodoc.verTipodoc();
    }

    @GetMapping("/tipodocumento")
    public Tipodoc VerUnTipoCriterio(Integer id)
    {
        return tipodoc.verUnTipodoc(id);
    }

    @PostMapping("/nuevotipodocumento")
    public void nuevoCriterio(@RequestBody TipodocRequest tipo)
    {
        tipodoc.nuevoTipodoc(tipo);
    }
}
