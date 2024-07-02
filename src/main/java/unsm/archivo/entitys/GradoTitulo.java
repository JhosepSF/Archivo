package unsm.archivo.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "GradoTitulo", uniqueConstraints = {@UniqueConstraint(columnNames = {"dni"})})
public class GradoTitulo
{
    @Id
	String nrodoc;
	
	@Column
	String titulo;
	String dni;
	String facultad;
	String escuela;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "idresolucion")
	Resolucion idresolucion;

	@Lob
	@Column(name = "pdf", columnDefinition = "LONGBLOB")
	byte[] pdf;

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

	public Resolucion getIdresolucion() {
		return idresolucion;
	}

	public void setIdresolucion(Resolucion idresolucion) {
		this.idresolucion = idresolucion;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
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