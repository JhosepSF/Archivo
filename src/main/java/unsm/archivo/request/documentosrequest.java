package unsm.archivo.request;

public class documentosrequest 
{
	String titulo;
	String estado;
	String fecha;
	Integer duracion;
	String vencimiento;
	String idtipo;
	String idtipocriterio;
	
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
	public String getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}
	public String getIdtipocriterio() {
		return idtipocriterio;
	}
	public void setIdtipocriterio(String idtipocriterio) {
		this.idtipocriterio = idtipocriterio;
	}
	
}