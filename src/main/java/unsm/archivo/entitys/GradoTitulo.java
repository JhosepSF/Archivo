package unsm.archivo.entitys;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class GradoTitulo
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	Integer idgradotitulo;
	
	@Column
	String nombreapellido;
	String dni;
	LocalDate fechaexpedicion;
	String facultadescuela;
	String gradotitulo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "idresolucion")
	Resolucion idresolucion;

	@Lob
	@Column(name = "pdf", columnDefinition = "LONGBLOB")
	byte[] pdf;

	public Integer getIdgradotitulo() {
		return idgradotitulo;
	}

	public void setIdgradotitulo(Integer idgradotitulo) {
		this.idgradotitulo = idgradotitulo;
	}

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

	public LocalDate getFechaexpedicion() {
		return fechaexpedicion;
	}

	public void setFechaexpedicion(LocalDate fechaexpedicion) {
		this.fechaexpedicion = fechaexpedicion;
	}
}