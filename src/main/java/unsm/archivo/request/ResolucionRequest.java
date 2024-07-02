package unsm.archivo.request;

import org.springframework.web.multipart.MultipartFile;

public class ResolucionRequest 
{
	String nrodoc;
	String titulo;
	String estado;
	String fecha;
	Integer duracion;
	String tipoResolucion;
	Integer idtipocriterio;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public String getTipoResolucion() {
		return tipoResolucion;
	}
	public void setTipoResolucion(String tipoResolucion) {
		this.tipoResolucion = tipoResolucion;
	}
	public Integer getIdtipocriterio() {
		return idtipocriterio;
	}
	public void setIdtipocriterio(Integer idtipocriterio) {
		this.idtipocriterio = idtipocriterio;
	}
	public MultipartFile getPdf() {
		return pdf;
	}
	public void setPdf(MultipartFile pdf) {
		this.pdf = pdf;
	}
}