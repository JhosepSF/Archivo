package unsm.archivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unsm.archivo.entitys.Documento;
import unsm.archivo.request.DocumentosRequest;
import unsm.archivo.services.DocumentoService;

@RestController
@RequestMapping("/documentos")
public class DocumentosController 
{
    @Autowired
    DocumentoService service;

    @GetMapping("/verdocumentos")
    public List<Documento> verdocumentos()
    {
        return service.verDocumentos();
    }

    @GetMapping("/verdocumento")
    public Documento verdocumento(Integer id)
    {
        return service.verUnDocumento(id);
    }

    @PostMapping("/nuevodocumento")
    public void nuevodocumento(DocumentosRequest request)
    {
        service.nuevoDocumento(request);
    }
}
