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

import unsm.archivo.DTO.ResolucionDTO;
import unsm.archivo.entitys.Resolucion;
import unsm.archivo.request.ResolucionRequest;
import unsm.archivo.services.ResolucionService;

@RestController
@RequestMapping("/resolucion")
public class ResolucionController 
{
    @Autowired
    ResolucionService service;

    @GetMapping("/verresolucion/")
    public List<ResolucionDTO> verResoluciones()
    {
        return service.verDocumentos();
    }

    @GetMapping("/verresolucion/{id}")
    public ResolucionDTO verResolucion(@PathVariable String id)
    {
        return service.verUnDocumento(id);
    }
    
    @GetMapping("/verresolucion/{id}/pdf")
    public ResponseEntity<byte[]> verResolucionPdf(@PathVariable String id) {
        Resolucion documento = service.verDocumentoPdf(id);
        byte[] pdfContent = documento.getPdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", documento.getTitulo() + ".pdf");
        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }

    @GetMapping("/verresolucion/criterio/{id}")
    public List<ResolucionDTO> verResolucionesPorCriterio(@PathVariable Integer id)
    {
        return service.verDocumentosporCriterio(id);
    }
    
    @GetMapping("/verresolucion/criteriomayor/{id}")
    public List<ResolucionDTO> verResolucionesPorCriterioMayor(@PathVariable Integer id)
    {
        return service.verDocumentosporCriterioMayor(id);
    }

    @PostMapping("/nuevaresolucion")
    public void nuevaResolucion(@ModelAttribute ResolucionRequest request) throws IOException
    {
        service.nuevoDocumento(request);
    }    
}
