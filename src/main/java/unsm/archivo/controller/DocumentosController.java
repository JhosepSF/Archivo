package unsm.archivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/verdocumento/")
    public List<DocumentoDTO> verdocumentos()
    {
        return service.verDocumentos();
    }

    @GetMapping("/verdocumento/{id}")
    public DocumentoDTO verdocumento(@PathVariable String id)
    {
        return service.verUnDocumento(id);
    }

    @GetMapping("/verdocumento/criterio/{id}")
    public List<DocumentoDTO> verdocumentosporcriterio(@PathVariable Integer id)
    {
        return service.verDocumentosporCriterio(id);
    }
    
    @GetMapping("/verdocumento/criteriomayor/{id}")
    public List<DocumentoDTO> verdocumentosporcriterioMayor(@PathVariable Integer id)
    {
        return service.verDocumentosporCriterioMayor(id);
    }

    @PostMapping("/nuevodocumento")
    public void nuevodocumento(@RequestBody DocumentosRequest request)
    {
        service.nuevoDocumento(request);
    }    
}
