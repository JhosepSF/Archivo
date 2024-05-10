package unsm.archivo.request;

public class usuariorequest
{
	String name;
    String lastname;
    String address;
    Integer cargoid;
    String username;
    String password;
    
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
	public Integer getCargoid() {
		return cargoid;
	}
	public void setCargoid(Integer cargoid) {
		this.cargoid = cargoid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
}