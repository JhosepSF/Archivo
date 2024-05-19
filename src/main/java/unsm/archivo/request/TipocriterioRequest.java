package unsm.archivo.request;

public class TipocriterioRequest 
{
	String criteryname;
	Integer subcriteryid;
	
	public String getCriteryname() {
		return criteryname;
	}
	public void setCriteryname(String criteryname) {
		this.criteryname = criteryname;
	}
	public Integer getSubcriteryid() {
		return subcriteryid;
	}
	public void setSubcriteryid(Integer subcriteryid) {
		this.subcriteryid = subcriteryid;
	}
}