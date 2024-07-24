package unsm.archivo.request;

import org.springframework.web.multipart.MultipartFile;

public class PosgradoRequest 
{
    String nombreapellido;
	String dni;
	String fechaexpedicion;
	String maestriadoctorado;
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
	public String getFechaexpedicion() {
		return fechaexpedicion;
	}
	public void setFechaexpedicion(String fechaexpedicion) {
		this.fechaexpedicion = fechaexpedicion;
	}
	public String getMaestriadoctorado() {
		return maestriadoctorado;
	}
	public void setMaestriadoctorado(String maestriadoctorado) {
		this.maestriadoctorado = maestriadoctorado;
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
}
