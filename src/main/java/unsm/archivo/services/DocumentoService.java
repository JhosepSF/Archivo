package unsm.archivo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unsm.archivo.DTO.DocumentoDTO;
import unsm.archivo.entitys.Documento;
import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.entitys.Tipodoc;
import unsm.archivo.repository.DocumentoRepo;
import unsm.archivo.repository.TipocriterioRepo;
import unsm.archivo.repository.TipodocRepo;
import unsm.archivo.request.DocumentosRequest;

@Service
public class DocumentoService 
{
    @Autowired
    DocumentoRepo documentorepo;

    @Autowired
    TipocriterioRepo criterio;

    @Autowired
    TipodocRepo tipodoc;

    public void nuevoDocumento(DocumentosRequest documentosRequest)
    {
        Documento doc = new Documento();
        doc.setNrodoc(documentosRequest.getNrodoc());
        doc.setTitulo(documentosRequest.getTitulo());
        doc.setEstado(documentosRequest.getEstado());
        doc.setDuracion(documentosRequest.getDuracion());

        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    LocalDate fecha = LocalDate.parse(documentosRequest.getFecha(), formatear);
        doc.setFecha(fecha);

        LocalDate vencimiento = LocalDate.parse(documentosRequest.getVencimiento(), formatear);
        doc.setVencimiento(vencimiento);

        Tipocriterio tipocriterio = criterio.findById(documentosRequest.getIdtipocriterio())
        .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + documentosRequest.getIdtipocriterio()));
        doc.setIdtipocriterio(tipocriterio);

        Tipodoc tipodocumento = tipodoc.findById(documentosRequest.getIdtipo())
        .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + documentosRequest.getIdtipo()));
        doc.setIdtipo(tipodocumento);

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
    	    documentoDTO.setTipodocumento(documento.getIdtipo().getTiponame()); 
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
	    documentoDTO.setTipodocumento(documento.getIdtipo().getTiponame()); 
	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
	    
	    return documentoDTO;
        
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
    	    documentoDTO.setTipodocumento(documento.getIdtipo().getTiponame()); 
    	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
    	    documentosdto.add(documentoDTO);
    	}
    	return documentosdto;
    }

    public List<DocumentoDTO> verDocumentosporTipo(Integer idtipo)
    {
        Tipodoc tipo = tipodoc.findById(idtipo)
                            .orElseThrow(()->new RuntimeException("No se encontro el tipo"));
        
        List<Documento> documentos = documentorepo.findByIdtipo(tipo);
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
    	    documentoDTO.setTipodocumento(documento.getIdtipo().getTiponame()); 
    	    documentoDTO.setTipocriterio(documento.getIdtipocriterio().getCriteryname());
    	    documentosdto.add(documentoDTO);
    	}
    	return documentosdto;
    }

}
