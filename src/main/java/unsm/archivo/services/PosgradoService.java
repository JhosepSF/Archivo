package unsm.archivo.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import unsm.archivo.DTO.PosgradoDTO;
import unsm.archivo.entitys.Posgrado;
import unsm.archivo.entitys.Resolucion;
import unsm.archivo.repository.PosgradoRepo;
import unsm.archivo.repository.ResolucionRepo;
import unsm.archivo.request.PosgradoRequest;

@Service
public class PosgradoService 
{
    @Autowired
    ResolucionRepo resolucionrepo;
    
    @Autowired
    PosgradoRepo posgradorepo;

    public void nuevoDocumento (PosgradoRequest request) throws IOException
    {
        Posgrado posgrado = new Posgrado();
        posgrado.setNombreapellido(request.getNombreapellido());
        posgrado.setDni(request.getDni());
        posgrado.setMaestriadoctorado(request.getMaestriadoctorado());
        
        Resolucion resolucion = resolucionrepo.findById(request.getIdresolucion())
               .orElseThrow(() -> new IllegalArgumentException("Invalid Resolucion Id: " + request.getIdresolucion()));
        posgrado.setIdresolucion(resolucion);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (request.getFechaexpedicion() != null) 
        {
            LocalDate fecha = LocalDate.parse(request.getFechaexpedicion(), formatter);
            posgrado.setFechaexpedicion(fecha);
        } 
        
        else 
        {
            throw new IllegalArgumentException("Fecha no puede ser nula");
        }
        
        MultipartFile pdfFile = request.getPdf();
        if (pdfFile != null && !pdfFile.isEmpty()) {
            posgrado.setPdf(pdfFile.getBytes()); 
        }
        
        posgradorepo.save(posgrado);
    }

    public List<PosgradoDTO> verDocumentos ()
    {
        List<Posgrado> documentos = posgradorepo.findAll();
        List<PosgradoDTO> documentosdto = new ArrayList<>();

        for(Posgrado posgrado : documentos)
        {
            PosgradoDTO documentoDTO = new PosgradoDTO();
            documentoDTO.setIdposgrado(posgrado.getIdposgrado()); 
            documentoDTO.setNombreapellido(posgrado.getNombreapellido()); 
            documentoDTO.setDni(posgrado.getDni());
            documentoDTO.setFechaexpedicion(posgrado.getFechaexpedicion().toString());
            documentoDTO.setMaestriadoctorado(posgrado.getMaestriadoctorado());
            documentoDTO.setIdresolucion(posgrado.getIdresolucion().getNrodoc());
            documentosdto.add(documentoDTO);
        }

        return documentosdto;
    }
    
    public PosgradoDTO verUnDocumento(Integer idposgrado) {
        Posgrado documento = posgradorepo.findById(idposgrado)
                .orElseThrow(() -> new RuntimeException("No se encontró el documento"));

        PosgradoDTO documentoDTO = new PosgradoDTO();
        documentoDTO.setIdposgrado(documento.getIdposgrado()); 
        documentoDTO.setNombreapellido(documento.getNombreapellido()); 
        documentoDTO.setDni(documento.getDni());
        documentoDTO.setFechaexpedicion(documento.getFechaexpedicion().toString());
        documentoDTO.setMaestriadoctorado(documento.getMaestriadoctorado());
        documentoDTO.setIdresolucion(documento.getIdresolucion().getNrodoc());
        return documentoDTO;
    }

    public Posgrado verDocumentoPdf(Integer idposgrado) {
        Posgrado documento = posgradorepo.findById(idposgrado)
                .orElseThrow(() -> new RuntimeException("No se encontró el documento"));

        return documento;
    }

    public List<PosgradoDTO> verDocumentosPorResolucion (String idresolucion)
    {
        Resolucion resolucion = resolucionrepo.findByNrodoc(idresolucion);

        List<Posgrado> documentos = posgradorepo.findByIdresolucion(resolucion);
        List<PosgradoDTO> documentosdto = new ArrayList<>();

        for(Posgrado posgrado : documentos)
        {
            PosgradoDTO documentoDTO = new PosgradoDTO();
            documentoDTO.setIdposgrado(posgrado.getIdposgrado()); 
            documentoDTO.setNombreapellido(posgrado.getNombreapellido()); 
            documentoDTO.setDni(posgrado.getDni());
            documentoDTO.setFechaexpedicion(posgrado.getFechaexpedicion().toString());
            documentoDTO.setMaestriadoctorado(posgrado.getMaestriadoctorado());
            documentoDTO.setIdresolucion(posgrado.getIdresolucion().getNrodoc());
            documentosdto.add(documentoDTO);
        }

        return documentosdto;
    }
}
