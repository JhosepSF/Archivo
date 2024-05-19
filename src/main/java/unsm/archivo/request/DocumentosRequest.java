package unsm.archivo.request;

public class DocumentosRequest 
{
	String titulo;
	String estado;
	String fecha;
	Integer duracion;
	String vencimiento;
	Integer idtipo;
	Integer idtipocriterio;
	
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
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	public Integer getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}
	public Integer getIdtipocriterio() {
		return idtipocriterio;
	}
	public void setIdtipocriterio(Integer idtipocriterio) {
		this.idtipocriterio = idtipocriterio;
	}
	
}