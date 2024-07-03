package unsm.archivo.request;

import org.springframework.web.multipart.MultipartFile;

public class GradoTituloRequest 
{
	String nombreapellido;
	String dni;
	String fechaexpedicion;
	String facultadescuela;
	String gradotitulo;
    String idresolucion;
	MultipartFile pdf;
	
	public String getNombreapellido() {
		return nombreapellido;
	}
	public void setNombreapellido(String nombreapellido) {
		this.nombreapellido = nombreapellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFacultadescuela() {
		return facultadescuela;
	}
	public void setFacultadescuela(String facultadescuela) {
		this.facultadescuela = facultadescuela;
	}
	public String getGradotitulo() {
		return gradotitulo;
	}
	public void setGradotitulo(String gradotitulo) {
		this.gradotitulo = gradotitulo;
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
	public String getFechaexpedicion() {
		return fechaexpedicion;
	}
	public void setFechaexpedicion(String fechaexpedicion) {
		this.fechaexpedicion = fechaexpedicion;
	}
}
