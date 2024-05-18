package unsm.archivo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unsm.archivo.entitys.Documento;
import unsm.archivo.entitys.Tipocriterio;
import unsm.archivo.entitys.Tipodoc;
import unsm.archivo.repository.Documentorepo;
import unsm.archivo.repository.Tipocriteriorepo;
import unsm.archivo.repository.Tipodocrepo;
import unsm.archivo.request.Documentosrequest;

public class DocumentoService 
{
    @Autowired
    Documentorepo documentorepo;

    @Autowired
    Tipocriteriorepo criterio;

    @Autowired
    Tipodocrepo tipodoc;

    public void nuevoDocumento(Documentosrequest documentosrequest)
    {
        Documento doc = new Documento();
        doc.setTitulo(documentosrequest.getTitulo());
        doc.setEstado(documentosrequest.getEstado());
        doc.setDuracion(documentosrequest.getDuracion());

        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    LocalDate fecha = LocalDate.parse(documentosrequest.getFecha(), formatear);
        doc.setFecha(fecha);

        LocalDate vencimiento = LocalDate.parse(documentosrequest.getVencimiento(), formatear);
        doc.setVencimiento(vencimiento);

        Tipocriterio tipocriterio = criterio.findById(documentosrequest.getIdtipocriterio())
        .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + documentosrequest.getIdtipocriterio()));
        doc.setIdtipocriterio(tipocriterio);

        Tipodoc tipodocumento = tipodoc.findById(documentosrequest.getIdtipo())
        .orElseThrow(() -> new IllegalArgumentException("Invalid Criterio Id:" + documentosrequest.getIdtipo()));
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
