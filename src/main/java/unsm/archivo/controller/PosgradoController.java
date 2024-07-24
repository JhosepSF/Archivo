package unsm.archivo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unsm.archivo.DTO.PosgradoDTO;
import unsm.archivo.entitys.Posgrado;
import unsm.archivo.request.PosgradoRequest;
import unsm.archivo.services.PosgradoService;

@RestController
@RequestMapping("/posgrado")
public class PosgradoController 
{
    @Autowired
    PosgradoService service;

    @GetMapping("/verposgrados/")
    public List<PosgradoDTO> verDocumentos() {
        return service.verDocumentos();
    }

    @GetMapping("/verposgrado/{id}")
    public PosgradoDTO verposgrado(@PathVariable Integer id) {
        return service.verUnDocumento(id);
    }

    @GetMapping("/verposgrado/{id}/pdf")
    public ResponseEntity<byte[]> verPosgradoPdf(@PathVariable Integer id) {
        Posgrado documento = service.verDocumentoPdf(id);
        byte[] pdfContent = documento.getPdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", documento.getIdposgrado() + ".pdf");
        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }

    @GetMapping("/verposgrado/resolucion/{id}")
    public List<PosgradoDTO> verPorResolucion(@PathVariable String id) {
        return service.verDocumentosPorResolucion(id);
    }

    @PostMapping("/nuevoposgrado")
    public void nuevoo(@ModelAttribute PosgradoRequest request) throws IOException {
        service.nuevoDocumento(request);
    }
}
