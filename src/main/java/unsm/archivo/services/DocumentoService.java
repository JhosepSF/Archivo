package unsm.archivo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unsm.archivo.entitys.Documento;
import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.entitys.Tipodoc;
import unsm.archivo.repository.DocumentoRepo;
import unsm.archivo.repository.TipocriterioRepo;
import unsm.archivo.repository.TipodocRepo;
import unsm.archivo.request.DocumentosRequest;

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

    public List<Documento> verDocumentos()
    {
        return documentorepo.findAll();
    }

    public Documento verUnDocumento(Integer iddoc)
    {
        return documentorepo.findById(iddoc)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + iddoc));
    }

}
