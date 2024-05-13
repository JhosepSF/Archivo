package unsm.archivo.DTO;

public class usuarioDTO 
{
	Integer id;
    String name;
    String lastname;
    String address;
    String cargoid;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCargoid() {
		return cargoid;
	}
	public void setCargoid(String cargoid) {
		this.cargoid = cargoid;
	}
	public usuarioDTO(Integer id, String name, String lastname, String address, String cargoid) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.cargoid = cargoid;
	}
}
