package unsm.archivo.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class tipodoc 
{
	@Id
	@GeneratedValue
	Integer idtipo;
	
	@Column
	String tiponame;

	public Integer getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}

	public String getTiponame() {
		return tiponame;
	}

	public void setTiponame(String tiponame) {
		this.tiponame = tiponame;
	}
}
