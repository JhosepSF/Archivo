package unsm.archivo.DTO;

public class GradoTituloDTO 
{
	String nrodoc;
	String titulo;
	String dni;
    String idresolucion;
    String facultad;
    String escuela;

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
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
}
