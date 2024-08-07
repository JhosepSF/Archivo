package unsm.archivo.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import unsm.archivo.DTO.ResolucionDTO;
import unsm.archivo.entitys.Resolucion;
import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.repository.ResolucionRepo;
import unsm.archivo.repository.TipocriterioRepo;
import unsm.archivo.request.ResolucionRequest;

@Service
public class ResolucionService 
{
    @Autowired
    ResolucionRepo documentorepo;

    @Autowired
    TipocriterioRepo criterio;

    public void nuevoDocumento(ResolucionRequest documentosRequest) throws IOException {
        Resolucion doc = new Resolucion();
        doc.setNrodoc(documentosRequest.getNrodoc());
        doc.setTitulo(documentosRequest.getTitulo());
        doc.setEstado(documentosRequest.getEstado());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (documentosRequest.getFecha() != null) {
            LocalDate fecha = LocalDate.parse(documentosRequest.getFecha(), formatter);
            doc.setFecha(fecha);
            
            if (documentosRequest.getTipoResolucion().equals("Temporal")) {
                int duracion = documentosRequest.getDuracion();
                doc.setDuracion(duracion);
                LocalDate fechaVencimiento = fecha.plus(duracion, ChronoUnit.YEARS);
                doc.setVencimiento(fechaVencimiento);
            }
        } else {
            throw new IllegalArgumentException("Fecha no puede ser nula");
        }

        Tipocriterio tipocriterio = criterio.findById(documentosRequest.getIdtipocriterio())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + documentosRequest.getIdtipocriterio()));
        doc.setIdtipocriterio(tipocriterio);

        MultipartFile pdfFile = documentosRequest.getPdf();
        if (pdfFile != null && !pdfFile.isEmpty()) {
            doc.setPdf(pdfFile.getBytes());
        }

        documentorepo.save(doc);
    }
    
    public Page<ResolucionDTO> verDocumentos(Pageable pageable) {
    Page<Resolucion> documentos = documentorepo.findAll(pageable);
    return documentos.map(documento -> {
        ResolucionDTO documentoDTO = new ResolucionDTO();
        documentoDTO.setNrodoc(documento.getNrodoc());
        documentoDTO.setTitulo(documento.getTitulo());
        documentoDTO.setEstado(documento.getEstado());
        documentoDTO.setFecha(documento.getFecha().toString());

        if (documento.getDuracion() != null) {
            documentoDTO.setDuracion(documento.getDuracion());
        } else {
            documentoDTO.setDuracion(0);
        }

        if (documento.getVencimiento() != null) {
            documentoDTO.setVencimiento(documento.getVencimiento().toString());
        } else {
            documentoDTO.setVencimiento("Permanente");
        }

        documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
        return documentoDTO;
    });
}

    public ResolucionDTO verUnDocumento(String doc) {
    	Resolucion documento = documentorepo.findById(doc)
                .orElseThrow(() -> new RuntimeException("No se encontro el documento"));

        ResolucionDTO documentoDTO = new ResolucionDTO();
        documentoDTO.setNrodoc(documento.getNrodoc());
        documentoDTO.setTitulo(documento.getTitulo());
        documentoDTO.setEstado(documento.getEstado());
        documentoDTO.setFecha(documento.getFecha().toString());
        
        if (documento.getDuracion() != null) {
            documentoDTO.setDuracion(documento.getDuracion());
        } else {
            documentoDTO.setDuracion(0);
        }
        
        if (documento.getVencimiento() != null) {
            documentoDTO.setVencimiento(documento.getVencimiento().toString());
        } else {
            documentoDTO.setVencimiento("Permanente");
        }
        
        documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());

        return documentoDTO;
    }

    public Resolucion verDocumentoPdf(String id) {
    	Resolucion documento = documentorepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el documento"));
        return documento;
    }

    public List<ResolucionDTO> verDocumentosporCriterio(Integer idcriterio) {
        Tipocriterio tipocriterio = criterio.findById(idcriterio)
                .orElseThrow(() -> new RuntimeException("No se encontro el criterio"));

        List<Resolucion> documentos = documentorepo.findByIdtipocriterio(tipocriterio);
        List<ResolucionDTO> documentosdto = new ArrayList<>();

        for (Resolucion documento : documentos) {
        	ResolucionDTO documentoDTO = new ResolucionDTO();
            documentoDTO.setNrodoc(documento.getNrodoc());
            documentoDTO.setTitulo(documento.getTitulo());
            documentoDTO.setEstado(documento.getEstado());
            documentoDTO.setFecha(documento.getFecha().toString());
            
            if (documento.getDuracion() != null) {
                documentoDTO.setDuracion(documento.getDuracion());
            } else {
                documentoDTO.setDuracion(0);
            }
            
            if (documento.getVencimiento() != null) {
                documentoDTO.setVencimiento(documento.getVencimiento().toString());
            } else {
                documentoDTO.setVencimiento("Permanente");
            }
            
            documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
            documentosdto.add(documentoDTO);
        }
        return documentosdto;
    }

    public List<ResolucionDTO> verDocumentosporCriterioMayor(Integer idcriterio) {
        Tipocriterio tipocriterio = criterio.findById(idcriterio)
                .orElseThrow(() -> new RuntimeException("No se encontro el criterio"));
        
        List<Tipocriterio> subcriterios = criterio.findBySubcriteryid(tipocriterio);
        List<Tipocriterio> newSubcriterios = new ArrayList<>();

        for (Tipocriterio subcriterio : subcriterios) 
        {
            List<Tipocriterio> subsubcriterios = criterio.findBySubcriteryid(subcriterio);
            newSubcriterios.addAll(subsubcriterios);
        }

        subcriterios.addAll(newSubcriterios);
        
        List<Resolucion> documentos = new ArrayList<>();
        List<ResolucionDTO> documentosdto = new ArrayList<>();

        for (Tipocriterio subcriterio : subcriterios) {
            documentos = documentorepo.findByIdtipocriterio(subcriterio);

            for (Resolucion documento : documentos) {
            	ResolucionDTO documentoDTO = new ResolucionDTO();
                documentoDTO.setNrodoc(documento.getNrodoc());
                documentoDTO.setTitulo(documento.getTitulo());
                documentoDTO.setEstado(documento.getEstado());
                documentoDTO.setFecha(documento.getFecha().toString());
                
                if (documento.getDuracion() != null) {
                    documentoDTO.setDuracion(documento.getDuracion());
                } else {
                    documentoDTO.setDuracion(0);
                }
                
                if (documento.getVencimiento() != null) {
                    documentoDTO.setVencimiento(documento.getVencimiento().toString());
                } else {
                    documentoDTO.setVencimiento("Permanente");
                }
                
                documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
                documentosdto.add(documentoDTO);
            }
        }
        return documentosdto;
    }
}
