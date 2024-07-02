package unsm.archivo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import unsm.archivo.DTO.GradoTituloDTO;
import unsm.archivo.entitys.GradoTitulo;
import unsm.archivo.entitys.Resolucion;
import unsm.archivo.repository.GradoTituloRepo;
import unsm.archivo.repository.ResolucionRepo;
import unsm.archivo.request.GradoTituloRequest;

@Service
public class GradoTituloService 
{
    @Autowired
    GradoTituloRepo gradorepo;

    @Autowired
    ResolucionRepo resolucionrepo;

    public void nuevoDocumento (GradoTituloRequest request) throws IOException
    {
        GradoTitulo grado = new GradoTitulo();
        grado.setNrodoc(request.getNrodoc());
        grado.setDni(request.getDni());
        grado.setEscuela(request.getEscuela());
        grado.setFacultad(request.getFacultad());

        Resolucion resolucion = resolucionrepo.findById(request.getIdresolucion())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Resolucion Id:" + request.getIdresolucion()));
        grado.setIdresolucion(resolucion);

        MultipartFile pdfFile = request.getPdf();
        if (pdfFile != null && !pdfFile.isEmpty()) {
            grado.setPdf(pdfFile.getBytes());
        }

        gradorepo.save(grado);
    }
    
    public List<GradoTituloDTO> verDocumentos() {
        List<GradoTitulo> documentos = gradorepo.findAll();
        List<GradoTituloDTO> documentosdto = new ArrayList<>();

        for (GradoTitulo documento : documentos) {
            GradoTituloDTO documentoDTO = new GradoTituloDTO();
            documentoDTO.setNrodoc(documento.getNrodoc());
            documentoDTO.setDni(documento.getDni());
            documentoDTO.setEscuela(documento.getEscuela());
            documentoDTO.setFacultad(documento.getFacultad());
            documentoDTO.setIdresolucion(documento.getIdresolucion().getNrodoc());

            documentosdto.add(documentoDTO);
        }
        return documentosdto;
    }

    public GradoTituloDTO verUnDocumento(String doc) {
        GradoTitulo documento = gradorepo.findById(doc)
                .orElseThrow(() -> new RuntimeException("No se encontró el documento"));

        GradoTituloDTO documentoDTO = new GradoTituloDTO();
        documentoDTO.setNrodoc(documento.getNrodoc());
        documentoDTO.setDni(documento.getDni());
        documentoDTO.setEscuela(documento.getEscuela());
        documentoDTO.setFacultad(documento.getFacultad());
        documentoDTO.setIdresolucion(documento.getIdresolucion().getNrodoc());

        return documentoDTO;
    }

    public GradoTitulo verDocumentoPdf(String id) {
        GradoTitulo documento = gradorepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el documento"));
        return documento;
    }

    public List<GradoTituloDTO> verDocumentosPorResolucion(String idresolucion) {
        Resolucion resolucion = resolucionrepo.findByNrodoc(idresolucion);

        List<GradoTitulo> documentos = gradorepo.findByIdresolucion(resolucion);
        List<GradoTituloDTO> documentosdto = new ArrayList<>();

        for (GradoTitulo documento : documentos) {
            GradoTituloDTO documentoDTO = new GradoTituloDTO();
            documentoDTO.setNrodoc(documento.getNrodoc());
            documentoDTO.setDni(documento.getDni());
            documentoDTO.setEscuela(documento.getEscuela());
            documentoDTO.setFacultad(documento.getFacultad());
            documentoDTO.setIdresolucion(documento.getIdresolucion().getNrodoc());

            documentosdto.add(documentoDTO);
        }
        return documentosdto;
    }
}