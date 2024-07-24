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
public class Posgrado 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	Integer idposgrado;
	
	@Column
	String nombreapellido;
	String dni;
	LocalDate fechaexpedicion;
	String maestriadoctorado;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "idresolucion")
	Resolucion idresolucion;

	@Lob
	@Column(name = "pdf", columnDefinition = "LONGBLOB")
	byte[] pdf;

	public Integer getIdposgrado() {
		return idposgrado;
	}

	public void setIdposgrado(Integer idposgrado) {
		this.idposgrado = idposgrado;
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

	public LocalDate getFechaexpedicion() {
		return fechaexpedicion;
	}

	public void setFechaexpedicion(LocalDate fechaexpedicion) {
		this.fechaexpedicion = fechaexpedicion;
	}

	public String getMaestriadoctorado() {
		return maestriadoctorado;
	}

	public void setMaestriadoctorado(String maestriadoctorado) {
		this.maestriadoctorado = maestriadoctorado;
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
}
