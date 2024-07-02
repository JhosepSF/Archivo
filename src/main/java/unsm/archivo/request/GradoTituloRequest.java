package unsm.archivo.request;

import org.springframework.web.multipart.MultipartFile;

public class GradoTituloRequest 
{
    String nrodoc;
	String titulo;
	String dni;
    String idresolucion;
    String escuela;
    String facultad;
	MultipartFile pdf;
	public String getNrodoc() {
		return nrodoc;
	}
	public void setNrodoc(String nrodoc) {
		this.nrodoc = nrodoc;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getIdresolucion() {
		return idresolucion;
	}
	public void setIdresolucion(String idresolucion) {
		this.idresolucion = idresolucion;
	}
	public MultipartFile getPdf() {
		return pdf;
	}
	public void setPdf(MultipartFile pdf) {
		this.pdf = pdf;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
}
