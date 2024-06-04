package unsm.archivo.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import unsm.archivo.DTO.DocumentoDTO;
import unsm.archivo.entitys.Documento;
import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.repository.DocumentoRepo;
import unsm.archivo.repository.TipocriterioRepo;
import unsm.archivo.request.DocumentosRequest;

@Service
public class DocumentoService 
{
    @Autowired
    DocumentoRepo documentorepo;

    @Autowired
    TipocriterioRepo criterio;

    public void nuevoDocumento(DocumentosRequest documentosRequest) throws IOException {
        Documento doc = new Documento();
        doc.setNrodoc(documentosRequest.getNrodoc());
        doc.setTitulo(documentosRequest.getTitulo());
        doc.setEstado(documentosRequest.getEstado());
        doc.setDuracion(documentosRequest.getDuracion());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(documentosRequest.getFecha(), formatter);
        doc.setFecha(fecha);
        LocalDate vencimiento = LocalDate.parse(documentosRequest.getVencimiento(), formatter);
        doc.setVencimiento(vencimiento);

        Tipocriterio tipocriterio = criterio.findById(documentosRequest.getIdtipocriterio())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + documentosRequest.getIdtipocriterio()));
        doc.setIdtipocriterio(tipocriterio);

        MultipartFile pdfFile = documentosRequest.getPdf();
        if (pdfFile != null && !pdfFile.isEmpty()) {
            doc.setPdf(pdfFile.getBytes());
        }

        documentorepo.save(doc);
    }
    
    public List<DocumentoDTO> verDocumentos()
    {
    	List<Documento> documentos = documentorepo.findAll();
    	List<DocumentoDTO> documentosdto = new ArrayList<>();
    	
    	for (Documento documento : documentos) 
    	{
    		DocumentoDTO documentoDTO = new DocumentoDTO();
    	    documentoDTO.setNrodoc(documento.getNrodoc());
    	    documentoDTO.setTitulo(documento.getTitulo());
    	    documentoDTO.setEstado(documento.getEstado());
    	    documentoDTO.setFecha(documento.getFecha().toString());
    	    documentoDTO.setDuracion(documento.getDuracion());
    	    documentoDTO.setVencimiento(documento.getVencimiento().toString()); 
    	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
    	    documentosdto.add(documentoDTO);
    	}
    	return documentosdto;
    }

    public DocumentoDTO verUnDocumento(String doc)
    {
        Documento documento = documentorepo.findById(doc)
        		.orElseThrow(()->new RuntimeException("No se encontro el documento"));
        
    	DocumentoDTO documentoDTO = new DocumentoDTO();
	    documentoDTO.setNrodoc(documento.getNrodoc());
	    documentoDTO.setTitulo(documento.getTitulo());
	    documentoDTO.setEstado(documento.getEstado());
	    documentoDTO.setFecha(documento.getFecha().toString());
	    documentoDTO.setDuracion(documento.getDuracion());
	    documentoDTO.setVencimiento(documento.getVencimiento().toString()); 
	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
	    
	    return documentoDTO;
    }
    
    public Documento verDocumentoPdf(String id) {
        Documento documento = documentorepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el documento"));
        return documento;
    }

    public List<DocumentoDTO> verDocumentosporCriterio(Integer idcriterio)
    {
        Tipocriterio tipocriterio = criterio.findById(idcriterio)
                            .orElseThrow(()->new RuntimeException("No se encontro el criterio"));
        
        List<Documento> documentos = documentorepo.findByIdtipocriterio(tipocriterio);
        List<DocumentoDTO> documentosdto = new ArrayList<>();
    	
    	for (Documento documento : documentos) 
    	{
    		DocumentoDTO documentoDTO = new DocumentoDTO();
    	    documentoDTO.setNrodoc(documento.getNrodoc());
    	    documentoDTO.setTitulo(documento.getTitulo());
    	    documentoDTO.setEstado(documento.getEstado());
    	    documentoDTO.setFecha(documento.getFecha().toString());
    	    documentoDTO.setDuracion(documento.getDuracion());
    	    documentoDTO.setVencimiento(documento.getVencimiento().toString());  
    	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
    	    documentosdto.add(documentoDTO);
    	}
    	return documentosdto;
    }
    
    public List<DocumentoDTO> verDocumentosporCriterioMayor(Integer idcriterio)
    {
        Tipocriterio tipocriterio = criterio.findById(idcriterio)
                            .orElseThrow(()->new RuntimeException("No se encontro el criterio"));
        
        List<Tipocriterio> subcriterios = criterio.findBySubcriteryid(tipocriterio);
        List<Documento> documentos = new ArrayList<>();
        List<DocumentoDTO> documentosdto = new ArrayList<>();
        
        for(Tipocriterio subcriterio : subcriterios) 
        {
        	documentos = documentorepo.findByIdtipocriterio(subcriterio);
        	
        	for (Documento documento : documentos) 
        	{
        		DocumentoDTO documentoDTO = new DocumentoDTO();
        	    documentoDTO.setNrodoc(documento.getNrodoc());
        	    documentoDTO.setTitulo(documento.getTitulo());
        	    documentoDTO.setEstado(documento.getEstado());
        	    documentoDTO.setFecha(documento.getFecha().toString());
        	    documentoDTO.setDuracion(documento.getDuracion());
        	    documentoDTO.setVencimiento(documento.getVencimiento().toString());  
        	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
        	    documentosdto.add(documentoDTO);
        	}
        }
    	return documentosdto;
    }

}
