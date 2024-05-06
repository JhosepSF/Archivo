package unsm.archivo.entitys;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class documentos 
{
	@Id
	@GeneratedValue
	Integer iddoc;
	
	@Column
	String titulo;
	String estado;
	LocalDate fecha;
	Integer duracion;
	LocalDate vencimiento;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "idtipo")
	tipodoc idtipo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "idtipocriterio")
	tipocriterio idtipocriterio;
}
