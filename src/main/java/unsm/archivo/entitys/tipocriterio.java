package unsm.archivo.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class tipocriterio 
{
	@Id
	@GeneratedValue
	Integer mainid;
	
	@Column
	String criteryname;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcriteryid")
    tipocriterio subcriteryid;

	public Integer getMainid() {
		return mainid;
	}

	public void setMainid(Integer mainid) {
		this.mainid = mainid;
	}

	public String getCriteryname() {
		return criteryname;
	}

	public void setCriteryname(String criteryname) {
		this.criteryname = criteryname;
	}

	public tipocriterio getSubcriteryid() {
		return subcriteryid;
	}

	public void setSubcriteryid(tipocriterio subcriteryid) {
		this.subcriteryid = subcriteryid;
	}
}
