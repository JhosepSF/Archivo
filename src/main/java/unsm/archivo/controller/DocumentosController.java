package unsm.archivo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unsm.archivo.DTO.DocumentoDTO;
import unsm.archivo.entitys.Documento;
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
    
    @GetMapping("/verdocumento/{id}/pdf")
    public ResponseEntity<byte[]> verDocumentoPdf(@PathVariable String id) {
        Documento documento = service.verDocumentoPdf(id);
        byte[] pdfContent = documento.getPdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", documento.getTitulo() + ".pdf");
        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
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
    public void nuevoDocumento(@ModelAttribute DocumentosRequest request) throws IOException
    {
        service.nuevoDocumento(request);
    }    
}
