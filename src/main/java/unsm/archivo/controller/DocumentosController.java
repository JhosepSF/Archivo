package unsm.archivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unsm.archivo.DTO.DocumentoDTO;
import unsm.archivo.request.DocumentosRequest;
import unsm.archivo.services.DocumentoService;

@RestController
@RequestMapping("/documentos")
public class DocumentosController 
{
    @Autowired
    DocumentoService service;

    @GetMapping("/verdocumentos")
    public List<DocumentoDTO> verdocumentos()
    {
        return service.verDocumentos();
    }

    @GetMapping("/verdocumento")
    public DocumentoDTO verdocumento(String id)
    {
        return service.verUnDocumento(id);
    }

    @GetMapping("/verdocumentosporcriterio")
    public List<DocumentoDTO> verdocumentosporcriterio(Integer id)
    {
        return service.verDocumentosporCriterio(id);
    }

    @GetMapping("/verdocumentosportipo")
    public List<DocumentoDTO> verdocumentosportipo(Integer id)
    {
        return service.verDocumentosporTipo(id);
    }

    @PostMapping("/nuevodocumento")
    public void nuevodocumento(@RequestBody DocumentosRequest request)
    {
        service.nuevoDocumento(request);
    }    
}
